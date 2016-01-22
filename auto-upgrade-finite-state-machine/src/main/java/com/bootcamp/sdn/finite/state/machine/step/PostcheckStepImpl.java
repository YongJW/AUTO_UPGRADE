/**
 * @author yongjie.wyj
 * @Email yongjie.wyj@bootcamp-inc.com
 */
package com.bootcamp.sdn.finite.state.machine.step;

import java.util.ArrayList;
import java.util.List;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.ReadOnlyTransaction;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.ProviderContext;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.UpgradeStatus;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Uri;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.OutputActionCase;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.OutputActionCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.output.action._case.OutputActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.list.Action;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.list.ActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.list.ActionKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowCapableNode;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.Table;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.TableKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.table.Flow;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.SalFlowService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.UpdateFlowInput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.UpdateFlowInputBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.flow.update.OriginalFlowBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.flow.update.UpdatedFlowBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.flow.InstructionsBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.flow.MatchBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.instruction.ApplyActionsCase;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.instruction.ApplyActionsCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.instruction.apply.actions._case.ApplyActionsBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.list.Instruction;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.list.InstructionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.instruction.list.InstructionKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeConnectorId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeRef;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.Nodes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.Node;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.NodeKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.service.rev131107.SalPortService;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;

import com.bootcamp.sdn.auto.upgrade.model.util.DataBrokerUtil;
import com.google.common.base.Optional;

public class PostcheckStepImpl implements StepExecute{

    private DataBroker dataBroker;

    private SalPortService portService;
    
    private SalFlowService flowService;
    
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

    public DataBroker getDataBroker() {
        return dataBroker;
    }

    public void setDataBroker(DataBroker dataBroker) {
        this.dataBroker = dataBroker;
    }

    public PostcheckStepImpl(DataBroker dataBroker,SalPortService portService,SalFlowService flowService) {
        this.dataBroker = dataBroker;
        this.portService = portService;
        this.flowService = flowService;
    }
    
    private NodeRef getSwitch3(String node){
        
        final InstanceIdentifier<Node> switch2Id = InstanceIdentifier.builder(Nodes.class)
                .child(Node.class,new NodeKey(new NodeId("openflow:" + node)))
                .toInstance();
        NodeRef switch2Node = new NodeRef(switch2Id);
        
        return switch2Node;
    }
    
    private static MatchBuilder createInportMatch(String port) {
        final MatchBuilder match = new MatchBuilder();
        Uri uri = new Uri(port);
        NodeConnectorId id = new NodeConnectorId(uri);
        match.setInPort(id);
        return match;
    }    
    
    private static InstructionsBuilder createSendToPortInstructions(String port) {
        List<Action> actionList = new ArrayList<Action>();
        ActionBuilder ab = new ActionBuilder();

        OutputActionBuilder output = new OutputActionBuilder();
        output.setMaxLength(0);
        //Uri value = new Uri(OutputPortValues.ALL.toString());
        Uri value = new Uri(port);
        
        output.setOutputNodeConnector(value);
        ab.setAction(new OutputActionCaseBuilder().setOutputAction(output.build()).build());
        ab.setOrder(0);
        ab.setKey(new ActionKey(0));
        actionList.add(ab.build());
        // Create an Apply Action
        ApplyActionsBuilder aab = new ApplyActionsBuilder();
        aab.setAction(actionList);

        // Wrap our Apply Action in an Instruction
        InstructionBuilder ib = new InstructionBuilder();
        ib.setInstruction(new ApplyActionsCaseBuilder().setApplyActions(aab.build()).build());
        ib.setOrder(0);
        ib.setKey(new InstructionKey(0));

        // Put our Instruction in a list of Instructions
        InstructionsBuilder isb = new InstructionsBuilder();
        List<Instruction> instructions = new ArrayList<Instruction>();
        instructions.add(ib.build());
        isb.setInstruction(instructions);
        return isb;
    }

    private UpdateFlowInput getUpdate(Flow flow,String node,String match,String port){
        
        UpdateFlowInputBuilder ub = new UpdateFlowInputBuilder();
        
        UpdatedFlowBuilder uub = new UpdatedFlowBuilder();
        
        //uub.setBarrier();
        uub.setBufferId(flow.getBufferId());
        uub.setContainerName(flow.getContainerName());
        uub.setCookie(flow.getCookie());
        uub.setCookieMask(flow.getCookieMask());
        uub.setFlags(flow.getFlags());
        uub.setFlowName(flow.getFlowName());
        uub.setHardTimeout(flow.getHardTimeout());
        uub.setIdleTimeout(flow.getIdleTimeout());
        //uub.setInstallHw()
        //uub.setInstructions(flow.getInstructions());
        if(port != null){
            uub.setInstructions(createSendToPortInstructions(port).build());
        }else{
            uub.setInstructions(flow.getInstructions());
        }
        
        if(match != null){
            uub.setMatch(createInportMatch(match).build());
        }else{
            uub.setMatch(flow.getMatch());
        }
        //uub.setMatch(createL3IPv4Match("10.0.0.1/32").build());
        
        
        uub.setOutGroup(flow.getOutGroup());
        uub.setOutPort(flow.getOutPort());
        uub.setPriority(flow.getPriority());
        //uub.setStrict(flow.get)
        uub.setTableId(flow.getTableId());
        
        ub.setUpdatedFlow(uub.build());
        ub.setNode(getSwitch3(node));
        
        OriginalFlowBuilder ob = new OriginalFlowBuilder();
        //uub.setBarrier();
        ob.setBufferId(flow.getBufferId());
        ob.setContainerName(flow.getContainerName());
        ob.setCookie(flow.getCookie());
        ob.setCookieMask(flow.getCookieMask());
        ob.setFlags(flow.getFlags());
        ob.setFlowName(flow.getFlowName());
        ob.setHardTimeout(flow.getHardTimeout());
        ob.setIdleTimeout(flow.getIdleTimeout());
        //uub.setInstallHw()
        ob.setInstructions(flow.getInstructions());
        
        
        ob.setMatch(flow.getMatch());
        ob.setOutGroup(flow.getOutGroup());
        ob.setOutPort(flow.getOutPort());
        ob.setPriority(flow.getPriority());
        //uub.setStrict(flow.get)
        ob.setTableId(flow.getTableId());
        ub.setOriginalFlow(ob.build());
        return ub.build();
    }

    @Override
    public boolean execute(String key) throws Exception {
        
        Optional<Table> optional = null;
        Optional<Table> optional4 = null;
        ReadOnlyTransaction tx = dataBroker.newReadOnlyTransaction();
        
        System.out.println("recover policy runnig:flow");
        
        optional = tx.read(LogicalDatastoreType.OPERATIONAL, InstanceIdentifier.builder(Nodes.class)
            .child(Node.class, new NodeKey(new NodeId("openflow:2"))).
            augmentation(FlowCapableNode.class).child(Table.class,new TableKey((short) 0)).toInstance()).get();
        
        optional4 = tx.read(LogicalDatastoreType.OPERATIONAL, InstanceIdentifier.builder(Nodes.class)
            .child(Node.class, new NodeKey(new NodeId("openflow:4"))).
            augmentation(FlowCapableNode.class).child(Table.class,new TableKey((short) 0)).toInstance()).get();
        
        List<Flow> flows4 = optional4.get().getFlow();
        List<Flow> flows = optional.get().getFlow();
        for(int i = 0;i < flows.size();++ i){
            if(flows.get(i).getMatch().getInPort() == null){
                continue;//skip ALL ACTION
            }
            if("openflow:2:1".equals(flows.get(i).getMatch().getInPort().getValue())){
                //setMatch
                ApplyActionsCase case1 = ((ApplyActionsCase)flows.get(i).
                getInstructions().
                getInstruction().
                get(0).
                getInstruction());
                OutputActionCase output = ((OutputActionCase)case1.
                        getApplyActions().
                        getAction().get(0).getAction());
                flowService.updateFlow(getUpdate(flows.get(i),"2",null,"2"));
            }
        }
        
        for(int i = 0;i < flows4.size();++ i){
            if(flows4.get(i).getMatch().getInPort() == null){
                continue;//skip ALL ACTION
            }
            if("openflow:4:2".equals(flows4.get(i).getMatch().getInPort().getValue())){
                //setMatch
                ApplyActionsCase case1 = ((ApplyActionsCase)flows4.get(i).
                getInstructions().
                getInstruction().
                get(0).
                getInstruction());
                OutputActionCase output = ((OutputActionCase)case1.
                        getApplyActions().
                        getAction().get(0).getAction());
                flowService.updateFlow(getUpdate(flows4.get(i),"4",null,"1"));
            }
        }
        
        DataBrokerUtil.changNextStatus(key, dataBroker, UpgradeStatus.POSTCHECK);
        return true;
    }

}
