package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bootcamp.sdn.isolation.impl.impl.UpgradeServiceImpl;
import com.bootcamp.sdn.upgrade.api.service.UpgradeConfiguration;

public class UpgradeServiceModule extends org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.AbstractUpgradeServiceModule {

    private static final Logger LOG = LoggerFactory.getLogger(UpgradeServiceModule.class);
    
    public UpgradeServiceModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver) {
        super(identifier, dependencyResolver);
    }

    public UpgradeServiceModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver, org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.UpgradeServiceModule oldModule, java.lang.AutoCloseable oldInstance) {
        super(identifier, dependencyResolver, oldModule, oldInstance);
    }

    @Override
    public void customValidation() {
        // add custom validation form module attributes here.
    }

    @Override
    public java.lang.AutoCloseable createInstance() {
        final UpgradeServiceImpl provider = new UpgradeServiceImpl();
        getBrokerDependency().registerProvider(provider);
        provider.setNcService(getNcClientDependency());
        
        final class AutoCloseableUpgradeService implements com.bootcamp.sdn.upgrade.api.service.UpgradeService, AutoCloseable {

            @Override
            public void close() throws Exception {
                LOG.info("close upgrade module!");
            }

            @Override
            public void doUpgrade(UpgradeConfiguration cfg) {
                provider.doUpgrade(cfg);
                LOG.info("close upgrade service");
            }

        }
        
        return new AutoCloseableUpgradeService();
    }


}
