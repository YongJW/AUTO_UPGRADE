package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210;

import org.osgi.framework.BundleContext;

import com.bootcamp.sdn.impl.NetconfclientProvider;
import com.bootcamp.sdn.netconf.client.NetconfclientConnectionServiceImpl;
import com.bootcamp.sdn.netconfclient.service.NetconfclientConfiguration;
import com.bootcamp.sdn.netconfclient.service.NetconfclientConnectionCallback;

public class NetconfclientModule extends org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.AbstractNetconfclientModule {
	private BundleContext bundleContext;

    public NetconfclientModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver) {
        super(identifier, dependencyResolver);
    }

    public NetconfclientModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver, org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.NetconfclientModule oldModule, java.lang.AutoCloseable oldInstance) {
        super(identifier, dependencyResolver, oldModule, oldInstance);
    }

    @Override
    public void customValidation() {
        // add custom validation form module attributes here.
    }

    public void setBundleContext(final BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }

    @Override
    public java.lang.AutoCloseable createInstance() {
        final NetconfclientConnectionServiceImpl service = new NetconfclientConnectionServiceImpl(bundleContext,
                getDomRegistryDependency(),
                getBindingRegistryDependency(),
                getProcessingExecutorDependency(),
                getClientDispatcherDependency(),
                getKeepaliveExecutorDependency(),
                getEventExecutorDependency());
        final NetconfclientProvider provider = new NetconfclientProvider(service);
        getBindingRegistryDependency().registerProvider(provider);

        final class AutoCloseableNetconfConnService implements com.bootcamp.sdn.netconfclient.service.NetconfclientConnectionService, AutoCloseable {
            @Override
            public void close() throws Exception {
                provider.close();
            }

			@Override
			public void connect(NetconfclientConfiguration configuration,
					NetconfclientConnectionCallback callback) {
				service.connect(configuration, callback);
				
			}
        }

        AutoCloseable ret = new AutoCloseableNetconfConnService();
        /*
        int i = 100000;
        while (i > 0) {
            NetconfclientConfiguration configuration1 = new NetconfclientConfiguration(new InetSocketAddress("10.218.76.43", 830), new Long(10), new Long(20000), "junchen.wt", "tao.wangt11");
            ((AutoCloseableNetconfConnService) ret).connect(configuration1, new NetconfclientConnectionCallback() {
                @Override
                public void validate(UnavailableCapabilities unavailableCapabilities, AvailableCapabilities availableCapabilities) {

                }

                @Override
                public void callback(Optional<MountPoint> mountPointOptional) {
                    if (mountPointOptional.isPresent()) {
                        System.out.println("called!");
                    }
                }
            });
            i--;
        }
        */
        return ret;
    }
}
