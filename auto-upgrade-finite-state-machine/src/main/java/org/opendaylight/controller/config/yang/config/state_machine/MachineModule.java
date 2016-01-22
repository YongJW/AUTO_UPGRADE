package org.opendaylight.controller.config.yang.config.state_machine;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.common.api.data.AsyncDataBroker.DataChangeScope;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.SalFlowService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.service.rev131107.SalPortService;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bootcamp.sdn.finite.state.machine.fsm.FiniteStateMachineImpl;
import com.bootcamp.sdn.finite.state.machine.step.ConfigStepImpl;

public class MachineModule extends org.opendaylight.controller.config.yang.config.state_machine.AbstractMachineModule {
private static final Logger LOG = LoggerFactory.getLogger(MachineModule.class);
    
    public MachineModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver) {
        super(identifier, dependencyResolver);
    }

    public MachineModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver, org.opendaylight.controller.config.yang.config.state_machine.MachineModule oldModule, java.lang.AutoCloseable oldInstance) {
        super(identifier, dependencyResolver, oldModule, oldInstance);
    }

    @Override
    public void customValidation() {
        // add custom validation form module attributes here.
    }

    @Override
    public java.lang.AutoCloseable createInstance() {
        LOG.info("init FSM");
        
        SalPortService portService = getRpcRegistryDependency().getRpcService(SalPortService.class);
        SalFlowService flowService = getRpcRegistryDependency().getRpcService(SalFlowService.class);
        
        DataBroker dataBroker = getDataBrokerDependency();
        
        ConfigStepImpl configStep = new ConfigStepImpl();
        FiniteStateMachineImpl fsm = new FiniteStateMachineImpl();
        
        fsm.setIsolationService(getIsolationDependency());
        fsm.setUpgradeService(getUpgradeDependency());
        configStep.setDataBroker(dataBroker);
        fsm.setDataBroker(dataBroker);
        fsm.setFlowService(flowService);
        fsm.setPortService(portService);
        dataBroker.registerDataChangeListener(
            LogicalDatastoreType.CONFIGURATION, 
            InstanceIdentifier.builder(Configurations.class).build(), configStep, DataChangeScope.SUBTREE);
        
        dataBroker.registerDataChangeListener(
            LogicalDatastoreType.CONFIGURATION, 
            InstanceIdentifier.builder(Configurations.class).build(), fsm, DataChangeScope.SUBTREE);
    
        return new AutoCloseable(){

            @Override
            public void close() throws Exception {
                LOG.info("exit FSM module!");
            }
            
        };
    }
}
