/**
 * @author yongjie.wyj
 * @Email yongjie.wyj@bootcamp-inc.com
 */
package com.bootcamp.sdn.finite.state.machine.step;

import java.util.List;

import org.opendaylight.controller.config.yang.config.state_machine.MachineModule;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.DataChangeListener;
import org.opendaylight.controller.md.sal.binding.api.WriteTransaction;
import org.opendaylight.controller.md.sal.common.api.data.AsyncDataChangeEvent;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.ConfigurationBuilder;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.ConfigurationKey;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.configuration.elem.type.Switch;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.configuration.elem.type.SwitchBuilder;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.UpgradeStatus;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bootcamp.sdn.auto.upgrade.model.util.DataBrokerUtil;

public class ConfigStepImpl implements DataChangeListener{

    private static final Logger LOG = LoggerFactory.getLogger(ConfigStepImpl.class);
    
    private DataBroker dataBroker;
    
    public DataBroker getDataBroker() {
        return dataBroker;
    }

    public void setDataBroker(DataBroker dataBroker) {
        this.dataBroker = dataBroker;
    }

    @Override
    public void onDataChanged(AsyncDataChangeEvent<InstanceIdentifier<?>, DataObject> change) {
        
        DataObject oriObj = change.getOriginalSubtree();
        DataObject upObj = change.getUpdatedSubtree();
        //change.getCreatedData()
        if((upObj != null) && (upObj instanceof Configurations) && (oriObj == null)){
            //configurations Node create
            LOG.info("need to change config status");
            List<Configuration> upNode = ((Configurations)upObj).getConfiguration();
            for(Configuration node : upNode){
                if(node.getType().equals(org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Switch.class)){
                    //Switch Cfg
                    //TODO batch change status
                    DataBrokerUtil.changNextStatus(node.getName(), dataBroker, UpgradeStatus.CONFIG);
                    
                }
            }
            
        }
    }

}
