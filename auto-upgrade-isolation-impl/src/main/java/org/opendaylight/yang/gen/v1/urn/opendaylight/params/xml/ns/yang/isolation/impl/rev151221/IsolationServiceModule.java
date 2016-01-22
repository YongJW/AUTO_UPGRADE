package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.isolation.impl.rev151221;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bootcamp.sdn.isolation.api.service.IsolationConfiguration;
import com.bootcamp.sdn.isolation.impl.impl.IsolationServiceImpl;

public class IsolationServiceModule extends org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.isolation.impl.rev151221.AbstractIsolationServiceModule {
    
    private static final Logger LOG = LoggerFactory.getLogger(IsolationServiceModule.class);
    
    public IsolationServiceModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver) {
        super(identifier, dependencyResolver);
    }

    public IsolationServiceModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver, org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.isolation.impl.rev151221.IsolationServiceModule oldModule, java.lang.AutoCloseable oldInstance) {
        super(identifier, dependencyResolver, oldModule, oldInstance);
    }

    @Override
    public void customValidation() {
        // add custom validation form module attributes here.
    }

    @Override
    public java.lang.AutoCloseable createInstance() {
        
        final IsolationServiceImpl provider = new IsolationServiceImpl();
        getBrokerDependency().registerProvider(provider);
        provider.setNcService(getNcClientDependency());
        
        final class AutoCloseableIsolationService implements com.bootcamp.sdn.isolation.api.service.IsolationService, AutoCloseable {

            @Override
            public void close() throws Exception {
                LOG.info("close Isolation module!");
            }

            @Override
            public void doIsolation(IsolationConfiguration cfg) {
                provider.doIsolation(cfg);
                LOG.info("close Isolation service");
            }
        }
        
        return new AutoCloseableIsolationService();
    }

}
