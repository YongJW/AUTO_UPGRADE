/**
 * @author yongjie.wyj
 * @Email yongjie.wyj@bootcamp-inc.com
 */
package com.bootcamp.sdn.finite.state.machine.step;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.ReadWriteTransaction;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.ProviderContext;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.ConfigurationBuilder;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.ConfigurationKey;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.configuration.elem.type.Switch;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.configuration.elem.type.SwitchBuilder;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.UpgradeStatus;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;

import com.bootcamp.sdn.auto.upgrade.model.util.DataBrokerUtil;
import com.bootcamp.sdn.isolation.api.service.IsolationConfiguration;
import com.bootcamp.sdn.isolation.api.service.IsolationService;
import com.google.common.base.Optional;

public class IsolateflowStepImpl implements StepExecute{

    private IsolationService isolationService;
    
    private DataBroker dataBroker;
    

    public IsolateflowStepImpl(IsolationService isolationService, DataBroker dataBroker) {
        this.isolationService = isolationService;
        this.dataBroker = dataBroker;
    }

    @Override
    public boolean execute(String key) throws Exception {
        IsolationConfiguration cfg = new IsolationConfiguration();
        cfg.setKey(key);
        isolationService.doIsolation(cfg);
        return true;
    }

}
