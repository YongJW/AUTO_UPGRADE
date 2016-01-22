/**
 * @author yongjie.wyj
 * @Email yongjie.wyj@bootcamp-inc.com
 */
package com.bootcamp.sdn.finite.state.machine.step;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.opendaylight.controller.config.yang.config.state_machine.MachineModule;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.ReadOnlyTransaction;
import org.opendaylight.controller.md.sal.binding.api.ReadWriteTransaction;
import org.opendaylight.controller.md.sal.binding.api.WriteTransaction;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.ProviderContext;
import org.opendaylight.openflowplugin.api.OFConstants;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.ConfigurationBuilder;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.ConfigurationKey;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.configuration.elem.type.Switch;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.configuration.elem.type.SwitchBuilder;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.UpgradeStatus;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Ipv4Prefix;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Uri;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.yang.types.rev100924.MacAddress;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.OutputActionCase;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.OutputActionCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.action.output.action._case.OutputActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.list.Action;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.list.ActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.action.types.rev131112.action.list.ActionKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowCapableNode;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowCapableNodeConnector;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.FlowNodeConnector;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.Table;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.TableKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.table.Flow;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.table.FlowBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.inventory.rev130819.tables.table.FlowKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.AddFlowInput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.AddFlowInputBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.RemoveFlowInput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.RemoveFlowInputBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.SalFlowService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.UpdateFlowInput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.UpdateFlowInputBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.flow.update.OriginalFlowBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.service.rev130819.flow.update.UpdatedFlowBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.port.rev130925.PortConfig;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.port.rev130925.PortFeatures;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.port.rev130925.PortNumberUni;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.port.rev130925.port.mod.PortBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.port.rev130925.port.mod.port.Port;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.port.rev130925.port.mod.port.PortKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.FlowCookie;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.FlowModFlags;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.FlowRef;
import org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.rev131026.OutputPortValues;
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
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.node.NodeConnector;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.node.NodeConnectorKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.Node;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.NodeKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.l2.types.rev130827.EtherType;
import org.opendaylight.yang.gen.v1.urn.opendaylight.model.match.types.rev131026.ethernet.match.fields.EthernetTypeBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.model.match.types.rev131026.match.EthernetMatchBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.model.match.types.rev131026.match.layer._3.match.Ipv4MatchBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.service.rev131107.SalPortService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.service.rev131107.UpdatePortInputBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.service.rev131107.UpdatePortOutput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.service.rev131107.port.update.UpdatedPortBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev131214.FlowCapableNodeConnectorStatisticsData;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.opendaylight.yangtools.yang.common.RpcResult;

import com.bootcamp.sdn.auto.upgrade.model.util.DataBrokerUtil;
import com.bootcamp.sdn.isolation.api.service.IsolationService;
import com.google.common.base.Optional;

public class PrecheckStepImpl implements StepExecute{

    private DataBroker dataBroker;
    
    private SalPortService portService;
    
    private SalFlowService flowService;
    
    private static final String LLDP_PUNT_WHOLE_PACKET_FLOW = "LLDP_PUNT_WHOLE_PACKET_FLOW";
    private static final String DEFAULT_FLOW_ID = "42";
    
    private static final short TABLE_ID = (short) 0;
    
    public PrecheckStepImpl(DataBroker dataBroker,SalPortService portService,SalFlowService flowService) {
        this.dataBroker = dataBroker;
        this.portService = portService;
        this.flowService = flowService;
    }
    
    private static MatchBuilder createInportMatch(String port) {
        final MatchBuilder match = new MatchBuilder();
        Uri uri = new Uri(port);
        NodeConnectorId id = new NodeConnectorId(uri);
        match.setInPort(id);
        return match;
    }
    
    
    private void downPort(String node_id, String port, boolean isDown) {
        Optional<Node> optional = null;
        try {
            optional = dataBroker.newReadOnlyTransaction()
                .read(LogicalDatastoreType.OPERATIONAL,
                    InstanceIdentifier.builder(Nodes.class)
                        .child(Node.class,
                            new NodeKey(
                                new NodeId("openflow:" + node_id)))
                        .build())
                .get();
        } catch (Exception e1) {
            System.out.println("change fail!");
        }

        Node node = (Node) optional.get();
        List<NodeConnector> connectors = node.getNodeConnector();
        for (NodeConnector nodeConnector : connectors) {
            FlowCapableNodeConnector flowCapableNodeConnector = nodeConnector
                .getAugmentation(FlowCapableNodeConnector.class);

            if (nodeConnector.getId().getValue().equalsIgnoreCase("openflow:" + node_id + ":" + port)) {
                Future<RpcResult<UpdatePortOutput>> out = portService.updatePort(
                    getPortInput(getSwitch(node_id), flowCapableNodeConnector, port, isDown)
                        .build());
                try {
                    RpcResult<UpdatePortOutput> rs = out.get();

                    if (rs.isSuccessful()) {
                        rs.getResult();
                        System.out.println("port service mod port status successful!");
                    }
                } catch (Exception e) {
                    System.out.println("exception...");
                    e.printStackTrace();
                }
            }
        }
    }

    private static Port createPort(FlowCapableNodeConnector flowCapableNodeConnector, String port,
                                   boolean isDown) {
        org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.port.rev130925.port.mod.port.PortBuilder portBuilder = new org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.port.rev130925.port.mod.port.PortBuilder();

        //portBuilder.setPortName(flowCapableNodeConnector.getName());
        //port.setMask(new PortConfig(true, true, true, true));
        portBuilder.setConfiguration(new PortConfig(true, true, true, isDown));
        portBuilder.setAdvertisedFeatures(new PortFeatures(true, true, true, true, false, false,
            false, false, true, true, true, true, false, false, false, false));
        portBuilder.setPortNumber(new PortNumberUni(Long.valueOf(port)));
        portBuilder
            .setHardwareAddress(new MacAddress(flowCapableNodeConnector.getHardwareAddress()));
        //port.setBarrier(true);
        //port.setContainerName("TestContainer");
        //port.setPortModOrder(25L);
        portBuilder.setKey(new PortKey(2L));
        return portBuilder.build();
    }

    private UpdatePortInputBuilder getPortInput(NodeRef node,
                                                FlowCapableNodeConnector flowCapableNodeConnector,
                                                String port, boolean isDown) {

        UpdatePortInputBuilder input = new UpdatePortInputBuilder();
        input.setNode(node);
        PortBuilder portBuilder = new PortBuilder();
        List<Port> ports = new ArrayList<Port>();
        ports.add(createPort(flowCapableNodeConnector, port, isDown));
        portBuilder.setPort(ports);
        UpdatedPortBuilder updatedPortBuilder = new UpdatedPortBuilder();
        updatedPortBuilder.setPort(portBuilder.build());
        input.setUpdatedPort(updatedPortBuilder.build());
        return input;
    }
    
    /**
     * CreateInstructions
     * @return
     */
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
    
    private static Port createPort(String mac) {
        org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.port.rev130925.port.mod.port.PortBuilder port =
                new org.opendaylight.yang.gen.v1.urn.opendaylight.flow.types.port.rev130925.port.mod.port.PortBuilder();

        //port.setPortName("TestingPort01");
        //port.setMask(new PortConfig(true, true, true, true));
        port.setConfiguration(new PortConfig(true, true, true, true));
        port.setAdvertisedFeatures(new PortFeatures(true, true, true, true,
                                                    false, false, false, false,
                                                    true, true, true, true,
                                                    false, false, false, false));
        port.setPortNumber(new PortNumberUni(2L));
        port.setHardwareAddress(new MacAddress(mac));
        //port.setBarrier(true);
        //port.setContainerName("TestContainer");
        //port.setPortModOrder(25L);
        port.setKey(new PortKey(2L));
        return port.build();
    }
    
    /**
     * 
     * @param node
     * @param mac
     * @return
     */
    private UpdatePortInputBuilder getPortInput(NodeRef node,String mac){
        
        UpdatePortInputBuilder input = new UpdatePortInputBuilder();
        input.setNode(node);
        PortBuilder portBuilder = new PortBuilder();
        List<Port> ports = new ArrayList<Port>();
        ports.add(createPort(mac));
        portBuilder.setPort(ports);
        UpdatedPortBuilder updatedPortBuilder = new UpdatedPortBuilder();
        updatedPortBuilder.setPort(portBuilder.build());
        input.setUpdatedPort(updatedPortBuilder.build());
        return input;
    }
    
    private NodeRef getSwitch(String node){
        
        final InstanceIdentifier<Node> switch2Id = InstanceIdentifier.builder(Nodes.class)
                .child(Node.class,new NodeKey(new NodeId("openflow:" + node)))
                .toInstance();
        NodeRef switch2Node = new NodeRef(switch2Id);
        
        return switch2Node;
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
        ub.setNode(getSwitch(node));
        
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
        
        //downPort("3", "1", true);
        
        Optional<Table> optional = null;
        Optional<Table> optional4 = null;
        ReadOnlyTransaction tx = dataBroker.newReadOnlyTransaction();
        
        System.out.println("isolation policy runnig:flow");
        
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
                flowService.updateFlow(getUpdate(flows.get(i),"2",null,"3"));
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
                flowService.updateFlow(getUpdate(flows4.get(i),"4",null,"3"));
            }
        }
        
        DataBrokerUtil.changNextStatus(key, dataBroker, UpgradeStatus.PRECHECK);
        return true;
    }

}
