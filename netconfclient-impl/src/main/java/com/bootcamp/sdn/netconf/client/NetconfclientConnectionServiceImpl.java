package com.bootcamp.sdn.netconf.client;

import com.bootcamp.sdn.netconfclient.service.*;

import io.netty.util.concurrent.EventExecutor;

import org.opendaylight.controller.config.threadpool.ScheduledThreadPool;
import org.opendaylight.controller.config.threadpool.ThreadPool;
import org.opendaylight.controller.netconf.client.NetconfClientDispatcher;
import org.opendaylight.controller.netconf.client.conf.NetconfClientConfiguration;
import org.opendaylight.controller.netconf.client.conf.NetconfReconnectingClientConfiguration;
import org.opendaylight.controller.netconf.client.conf.NetconfReconnectingClientConfigurationBuilder;
import org.opendaylight.controller.netconf.nettyutil.handler.ssh.authentication.LoginPassword;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker;
import org.opendaylight.controller.sal.connect.api.RemoteDeviceHandler;
import org.opendaylight.controller.sal.connect.netconf.NetconfDevice;
import org.opendaylight.controller.sal.connect.netconf.NetconfStateSchemas;
import org.opendaylight.controller.sal.connect.netconf.listener.NetconfDeviceCommunicator;
import org.opendaylight.controller.sal.connect.netconf.listener.NetconfSessionPreferences;
import org.opendaylight.controller.sal.connect.netconf.sal.KeepaliveSalFacade;
import org.opendaylight.controller.sal.connect.netconf.sal.NetconfDeviceSalFacade;
import org.opendaylight.controller.sal.connect.util.RemoteDeviceId;
import org.opendaylight.controller.sal.core.api.Broker;
import org.opendaylight.protocol.framework.ReconnectStrategy;
import org.opendaylight.protocol.framework.ReconnectStrategyFactory;
import org.opendaylight.protocol.framework.TimedReconnectStrategy;
import org.opendaylight.yangtools.yang.model.repo.api.SchemaContextFactory;
import org.opendaylight.yangtools.yang.model.repo.api.SchemaSourceFilter;
import org.opendaylight.yangtools.yang.model.repo.api.YangTextSchemaSource;
import org.opendaylight.yangtools.yang.model.repo.util.FilesystemSchemaSourceCache;
import org.opendaylight.yangtools.yang.parser.repo.SharedSchemaRepository;
import org.opendaylight.yangtools.yang.parser.util.TextToASTTransformer;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class NetconfclientConnectionServiceImpl implements NetconfclientConnectionService, NetconfclientConnContextAware{
    private static final Logger logger = LoggerFactory.getLogger(NetconfclientConnectionServiceImpl.class);

    private static final int  DEFAULT_CONN_ATTEMPTS_GAP = 2000;
    private static final BigDecimal DEFAULT_CONN_ATTEMPTS_GAP_FACTOR = new BigDecimal(1.5);
    private static final long DEFAULT_REQ_TIMEOUT_MILLIS = 60000;
    private static final long DEFAULT_KEEP_ALIVE_DELAY = 120;

    private final SharedSchemaRepository repository = new SharedSchemaRepository("sal-netconf-connector");
    private final SchemaContextFactory schemaContextFactory
            = repository.createSchemaContextFactory(SchemaSourceFilter.ALWAYS_ACCEPT);

    private final BundleContext bundleContext;
    private final Broker domRegistry;
    private final BindingAwareBroker bindingRegistry;
    private final ThreadPool processingExecutor;
    private final NetconfClientDispatcher clientDispatcher;
    private final ScheduledThreadPool keepaliveExecutor;
    private final EventExecutor eventExecutor;

    private ConcurrentHashMap<String, NetconfclientConnectionContext> netconfclientConnectionContext = new ConcurrentHashMap<>();

    public NetconfclientConnectionServiceImpl(BundleContext bundleContext, Broker domRegistry, BindingAwareBroker bindingRegistry,
                                              ThreadPool threadPool, NetconfClientDispatcher clientDispatcher,
                                              ScheduledThreadPool keepaliveExecutor, EventExecutor eventExecutor) {
        this.bundleContext = bundleContext;
        this.domRegistry = domRegistry;
        this.bindingRegistry = bindingRegistry;
        this.processingExecutor = threadPool;
        this.clientDispatcher = clientDispatcher;
        this.keepaliveExecutor = keepaliveExecutor;
        this.eventExecutor = eventExecutor;

        final FilesystemSchemaSourceCache<YangTextSchemaSource> cache = new FilesystemSchemaSourceCache<>(repository, YangTextSchemaSource.class, new File("cache/schema"));
        repository.registerSchemaSourceListener(cache);
        repository.registerSchemaSourceListener(TextToASTTransformer.create(repository, repository));
    }

    private static final class TimedReconnectStrategyFactory implements ReconnectStrategyFactory {
        private final Long connectionAttempts;
        private final EventExecutor executor;
        private final double sleepFactor;
        private final int minSleep;

        TimedReconnectStrategyFactory(final EventExecutor executor, final Long maxConnectionAttempts, final int minSleep, final BigDecimal sleepFactor) {
            if (maxConnectionAttempts != null && maxConnectionAttempts > 0) {
                connectionAttempts = maxConnectionAttempts;
            } else {
                connectionAttempts = null;
            }

            this.sleepFactor = sleepFactor.doubleValue();
            this.executor = executor;
            this.minSleep = minSleep;
        }

        @Override
        public ReconnectStrategy createReconnectStrategy() {
            final Long maxSleep = null;
            final Long deadline = null;

            return new TimedReconnectStrategy(executor, minSleep,
                    minSleep, sleepFactor, maxSleep, connectionAttempts, deadline);
        }
    }

    private NetconfReconnectingClientConfiguration getClientConfig(final NetconfDeviceCommunicator listener, NetconfclientConfiguration configuration) {
        final ReconnectStrategyFactory sf = new TimedReconnectStrategyFactory(
                eventExecutor, configuration.getConnectionMaxAttempts(), DEFAULT_CONN_ATTEMPTS_GAP, DEFAULT_CONN_ATTEMPTS_GAP_FACTOR);
        final ReconnectStrategy strategy = sf.createReconnectStrategy();

        return NetconfReconnectingClientConfigurationBuilder.create()
                .withAddress(configuration.getAddress())
                .withConnectionTimeoutMillis(configuration.getConnectionTimeoutMillis())
                .withReconnectStrategy(strategy)
                .withAuthHandler(new LoginPassword(configuration.getUsername(), configuration.getPassword()))
                .withProtocol(NetconfClientConfiguration.NetconfClientProtocol.SSH)
                .withConnectStrategyFactory(sf)
                .withSessionListener(listener)
                .build();
    }

    @Override
    public void closeNetconfNode(String nodeName) {
        NetconfclientConnectionContext context = getNetconfConnContext(nodeName);
        if (context != null) {
            removeNetconfConnContext(nodeName);
            try {
                Thread.sleep(5000);
                context.getSession().close();
            } catch (Exception e) {
                logger.error("netconf connection close failed.");
            }
        }
    }

    @Override
    public NetconfclientConnectionContext getNetconfConnContext(String nodeName) {
        return netconfclientConnectionContext.get(nodeName);
    }

    @Override
    public void removeNetconfConnContext(String nodeName) {
       netconfclientConnectionContext.remove(nodeName);
    }

    @Override
    public ConcurrentHashMap<String, NetconfclientConnectionContext> getAllNetconfConnContext() {
        return netconfclientConnectionContext;
    }

    @Override
    public void connect(final NetconfclientConfiguration configuration, final NetconfclientConnectionCallback callback) {
        logger.debug("connect to" + configuration.getAddress().getAddress().getHostAddress());
        /* The sessionId SHOULD be unique, try to avoid multi-processes problems */
        String sessionId = UUID.randomUUID().toString();
        final RemoteDeviceId id = new RemoteDeviceId(sessionId, configuration.getAddress());
        final NetconfDevice.SchemaResourcesDTO schemaResourcesDTO = new NetconfDevice.SchemaResourcesDTO(repository, schemaContextFactory, new NetconfStateSchemas.NetconfStateSchemasResolverImpl());

        RemoteDeviceHandler<NetconfSessionPreferences> facade = new NetconfDeviceSalFacade(id, domRegistry, bindingRegistry, bundleContext, DEFAULT_REQ_TIMEOUT_MILLIS);
        facade = new KeepaliveSalFacade(id, facade, keepaliveExecutor.getExecutor(), DEFAULT_KEEP_ALIVE_DELAY);

        final NetconfDevice device = new NetconfDevice(schemaResourcesDTO, id, facade, processingExecutor.getExecutor(), Boolean.FALSE);
        final NetconfDeviceCommunicator listener = new NetconfDeviceCommunicator(id, device);
        ((KeepaliveSalFacade)facade).setListener(listener);

        /* 1. save the context */
        netconfclientConnectionContext.putIfAbsent(sessionId, new NetconfclientConnectionContext(configuration, callback, new NetconfclientAutoCloseable(sessionId, listener, facade)));

        try {
            /* 2. connect to the netconf server */
            listener.initializeRemoteConnection(clientDispatcher, getClientConfig(listener, configuration));
        } catch(Exception e) {
            logger.error("cannot connect to netconf node.");
            closeNetconfNode(sessionId);
            throw new RuntimeException("cannot connect to netconf node", e);
        }
    }
}
