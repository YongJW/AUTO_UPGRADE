/**
 * @author yongjie.wyj
 * @Email yongjie.wyj@bootcamp-inc.com
 */
package com.bootcamp.sdn.finite.state.machine.step;

import org.opendaylight.controller.config.yang.config.state_machine.MachineModule;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.ProviderContext;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.UpgradeStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bootcamp.sdn.auto.upgrade.model.util.DataBrokerUtil;

public class SuccessStepImpl implements StepExecute{
    
    private static final Logger LOG = LoggerFactory.getLogger(SuccessStepImpl.class);

    private DataBroker dataBroker; 

    public SuccessStepImpl(DataBroker dataBroker) {
        this.dataBroker = dataBroker;
    }

    @Override
    public boolean execute(String key) throws Exception {
        LOG.info("Auto Upgrade Success!");
        DataBrokerUtil.changNextStatus(key, dataBroker, UpgradeStatus.SUCCESS);
        return true;
    }

}
