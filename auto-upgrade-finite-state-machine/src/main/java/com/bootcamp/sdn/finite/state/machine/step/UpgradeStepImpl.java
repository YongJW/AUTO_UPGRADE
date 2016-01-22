/**
 * @author yongjie.wyj
 * @Email yongjie.wyj@bootcamp-inc.com
 */
package com.bootcamp.sdn.finite.state.machine.step;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.UpgradeStatus;

import com.bootcamp.sdn.auto.upgrade.model.util.DataBrokerUtil;
import com.bootcamp.sdn.upgrade.api.service.UpgradeConfiguration;
import com.bootcamp.sdn.upgrade.api.service.UpgradeService;

public class UpgradeStepImpl implements StepExecute{

    private DataBroker dataBroker;
    
    private UpgradeService upgradeService;

    public DataBroker getDataBroker() {
        return dataBroker;
    }

    public void setDataBroker(DataBroker dataBroker) {
        this.dataBroker = dataBroker;
    }

    public UpgradeService getUpgradeService() {
        return upgradeService;
    }

    public void setUpgradeService(UpgradeService upgradeService) {
        this.upgradeService = upgradeService;
    }

    public UpgradeStepImpl(UpgradeService upgradeService, DataBroker dataBroker) {
        
        this.upgradeService = upgradeService;
        this.dataBroker = dataBroker;
    }

    @Override
    public boolean execute(String key) throws Exception {
        Thread.sleep(120000);
        UpgradeConfiguration cfg = new UpgradeConfiguration();
        cfg.setKey(key);
        upgradeService.doUpgrade(cfg);
        return true;
    }

}
