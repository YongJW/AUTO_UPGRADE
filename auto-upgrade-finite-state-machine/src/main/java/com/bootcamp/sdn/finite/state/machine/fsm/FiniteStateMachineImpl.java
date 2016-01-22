/**
 * @author yongjie.wyj
 * @Email yongjie.wyj@bootcamp-inc.com
 */
package com.bootcamp.sdn.finite.state.machine.fsm;

import java.util.List;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.DataChangeListener;
import org.opendaylight.controller.md.sal.common.api.data.AsyncDataChangeEvent;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.configuration.elem.type.Switch;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.UpgradeStatus;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.SalFlowService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.service.rev131107.SalPortService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bootcamp.sdn.finite.state.machine.step.CopyImageStepImpl;
import com.bootcamp.sdn.finite.state.machine.step.IsolateflowStepImpl;
import com.bootcamp.sdn.finite.state.machine.step.PostcheckStepImpl;
import com.bootcamp.sdn.finite.state.machine.step.PrecheckStepImpl;
import com.bootcamp.sdn.finite.state.machine.step.StepExecute;
import com.bootcamp.sdn.finite.state.machine.step.SuccessStepImpl;
import com.bootcamp.sdn.finite.state.machine.step.UpgradeStepImpl;
import com.bootcamp.sdn.isolation.api.service.IsolationService;
import com.bootcamp.sdn.upgrade.api.service.UpgradeService;

public class FiniteStateMachineImpl implements DataChangeListener{
    
    private static final Logger LOG = LoggerFactory.getLogger(FiniteStateMachineImpl.class);

    private DataBroker dataBroker;
    
    private IsolationService isolationService;
    
    private SalPortService portService;
    
    private SalFlowService flowService;
    
    private UpgradeService upgradeService;

    public SalPortService getPortService() {
        return portService;
    }

    public void setPortService(SalPortService portService) {
        this.portService = portService;
    }

    public SalFlowService getFlowService() {
        return flowService;
    }

    public void setFlowService(SalFlowService flowService) {
        this.flowService = flowService;
    }

    public UpgradeService getUpgradeService() {
        return upgradeService;
    }

    public void setUpgradeService(UpgradeService upgradeService) {
        this.upgradeService = upgradeService;
    }

    public IsolationService getIsolationService() {
        return isolationService;
    }

    public void setIsolationService(IsolationService isolationService) {
        this.isolationService = isolationService;
    }

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
        
        if((oriObj != null) && (upObj != null)){
            //1.status change 2.config again
            List<Configuration> upNode = ((Configurations)upObj).getConfiguration();
            List<Configuration> oriNode = ((Configurations)oriObj).getConfiguration();
            
            for(Configuration uNode : upNode){
                for(Configuration oNode : oriNode){
                    if(uNode.getType().equals(org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Switch.class) &&
                            oNode.getType().equals(org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Switch.class) &&
                            uNode.getName().equals(oNode.getName()) &&
                            uNode.getType().equals(oNode.getType()) &&
                            uNode.getRepository().equals(oNode.getRepository()) &&
                            uNode.getFile().equals(oNode.getFile()) &&
                            uNode.getProtocol().equals(oNode.getProtocol()) &&
                            uNode.getIpVersion().equals(oNode.getIpVersion()) &&
                            uNode.getHost().equals(oNode.getHost()) &&
                            uNode.getPort().equals(oNode.getPort()) &&
                            uNode.getUsername().equals(oNode.getUsername()) &&
                            uNode.getPassword().equals(oNode.getPassword()) &&
                            ((Switch)uNode.getElemType()).getIsolationPolicy().equals(((Switch)oNode.getElemType()).getIsolationPolicy())){
                        //status change,change Event action
                        
                        UpgradeStatus current = ((Switch)uNode.getElemType()).getCurrentStatus();
                        
                        LOG.info("Now Running " + current + " step!");
                        
                        StepExecute step = null;
                        switch(current.getIntValue()){
                            case 0:
                            case 1:
                                step = new PrecheckStepImpl(dataBroker,portService,flowService);
                                break;
                            case 2:
                                step = new CopyImageStepImpl(dataBroker);
                                break;
                            case 3:
                                step = new IsolateflowStepImpl(isolationService,dataBroker);
                                break;
                            case 4:
                                step = new UpgradeStepImpl(upgradeService,dataBroker);
                                break;
                            case 5:
                                step = new PostcheckStepImpl(dataBroker,portService,flowService);
                                break;
                            case 6:
                                step = new SuccessStepImpl(dataBroker);
                                break;
                            case 7:
                                LOG.info("UpGrade Success!");
                                break;
                            case 8:
                                LOG.info("UpGrade Fail!");
                                break;
                        }
                        
                        try {
                            if(step != null && !step.execute(uNode.getName())){
                                LOG.warn("Run" + UpgradeStatus.forValue(current.getIntValue() + 1).toString() + "action Fail!");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            LOG.error("change status 1fail:" + e);
                        }
                        
                    }
                }
            }
        }
    }

}
