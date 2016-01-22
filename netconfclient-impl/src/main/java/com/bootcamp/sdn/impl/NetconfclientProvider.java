/*
 * bootcamp and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package com.bootcamp.sdn.impl;

import com.bootcamp.sdn.netconfclient.service.NetconfclientConnContextAware;
import com.bootcamp.sdn.netconfclient.service.NetconfclientConnectionCallback;
import com.bootcamp.sdn.netconfclient.service.NetconfclientConnectionContext;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.DataChangeListener;
import org.opendaylight.controller.md.sal.binding.api.MountPointService;
import org.opendaylight.controller.md.sal.common.api.data.AsyncDataBroker;
import org.opendaylight.controller.md.sal.common.api.data.AsyncDataChangeEvent;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker;
import org.opendaylight.controller.sal.binding.api.BindingAwareProvider;
import org.opendaylight.yang.gen.v1.urn.opendaylight.netconf.node.topology.rev150114.NetconfNode;
import org.opendaylight.yang.gen.v1.urn.opendaylight.netconf.node.topology.rev150114.NetconfNodeFields;
import org.opendaylight.yang.gen.v1.urn.opendaylight.netconf.node.topology.rev150114.netconf.node.fields.AvailableCapabilities;
import org.opendaylight.yang.gen.v1.urn.opendaylight.netconf.node.topology.rev150114.netconf.node.fields.UnavailableCapabilities;
import org.opendaylight.yang.gen.v1.urn.opendaylight.netconf.node.topology.rev150114.network.topology.topology.topology.types.TopologyNetconf;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NetworkTopology;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NodeId;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.TopologyId;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.Topology;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.TopologyKey;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.Node;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.NodeKey;
import org.opendaylight.yangtools.concepts.ListenerRegistration;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.binding.Identifier;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NetconfclientProvider implements DataChangeListener, BindingAwareProvider, AutoCloseable {

    public static final InstanceIdentifier<Topology> NETCONF_TOPO_IID =
            InstanceIdentifier
                    .create(NetworkTopology.class)
                    .child(Topology.class,
                            new TopologyKey(new TopologyId(TopologyNetconf.QNAME.getLocalName())));
    private static final Logger LOG = LoggerFactory.getLogger(NetconfclientProvider.class);
    private DataBroker dataBroker;
    private MountPointService mountPointService;
    private NetconfclientConnContextAware contextAware;
    private ListenerRegistration<DataChangeListener> dclReg;

    public NetconfclientProvider(NetconfclientConnContextAware contextAware) {
        this.contextAware = contextAware;
    }

    @Override
    public void onSessionInitiated(BindingAwareBroker.ProviderContext session) {
        this.dataBroker = session.getSALService(DataBroker.class);
        this.mountPointService = session.getSALService(MountPointService.class);

        if (dataBroker != null) {
            this.dclReg = dataBroker.registerDataChangeListener(LogicalDatastoreType.OPERATIONAL,
                    NETCONF_TOPO_IID.child(Node.class),
                    this,
                    AsyncDataBroker.DataChangeScope.SUBTREE);
        }

    }

    @Override
    public void close() throws Exception {
        if (dclReg != null) {
            dclReg.close();
        }

        ConcurrentHashMap<String, NetconfclientConnectionContext> contexts = this.contextAware.getAllNetconfConnContext();
        if (contexts.size() != 0) {
            for (String nodeName : contexts.keySet()) {
                this.contextAware.closeNetconfNode(nodeName);
            }
        }
    }

    private void onNetconfConnected(NodeId nodeId,
                                    UnavailableCapabilities unavailableCapabilities,
                                    AvailableCapabilities availableCapabilities) {
        /* the netconf node is connected, we can invoke the RPC now. */
        NetconfclientConnectionContext netconfContext = this.contextAware.getNetconfConnContext(nodeId.getValue());
        if (netconfContext != null) {

            NetconfclientConnectionCallback callback = netconfContext.getCallback();
            if (callback != null) {
                try {
                    callback.validate(unavailableCapabilities, availableCapabilities);
                    callback.callback(mountPointService.getMountPoint(NETCONF_TOPO_IID.child(Node.class, new NodeKey(nodeId))));
                } catch (Exception e) {
                    LOG.error(e.getMessage());
                } finally {
                    this.contextAware.closeNetconfNode(nodeId.getValue());
                }
            }
        }
    }

    @Override
    public void onDataChanged(AsyncDataChangeEvent<InstanceIdentifier<?>, DataObject> change) {
        for (Map.Entry<InstanceIdentifier<?>,
                DataObject> entry : change.getUpdatedData().entrySet()) {
            if (entry.getKey().getTargetType() == NetconfNode.class) {
                NodeId nodeId = getNodeId(entry.getKey());

                NetconfNode netconfNode = (NetconfNode) entry.getValue();
                NetconfNodeFields.ConnectionStatus status = netconfNode.getConnectionStatus();

                switch (status) {
                    case Connected: {
                        onNetconfConnected(nodeId, netconfNode.getUnavailableCapabilities(), netconfNode.getAvailableCapabilities());
                        break;
                    }
                    case UnableToConnect: {
                        this.contextAware.closeNetconfNode(nodeId.getValue());
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        }
    }

    private NodeId getNodeId(final InstanceIdentifier<?> path) {
        for (InstanceIdentifier.PathArgument pathArgument : path.getPathArguments()) {
            if (pathArgument instanceof InstanceIdentifier.IdentifiableItem<?, ?>) {

                final Identifier key = ((InstanceIdentifier.IdentifiableItem) pathArgument).getKey();
                if (key instanceof NodeKey) {
                    return ((NodeKey) key).getNodeId();
                }
            }
        }
        return null;
    }
}
