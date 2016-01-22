/**
 * @author yongjie.wyj
 * @Email yongjie.wyj@bootcamp-inc.com
 */
package com.bootcamp.sdn.isolation.impl.impl;

import java.net.InetSocketAddress;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.MountPoint;
import org.opendaylight.controller.md.sal.binding.api.MountPointService;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.ProviderContext;
import org.opendaylight.controller.sal.binding.api.BindingAwareProvider;
import org.opendaylight.controller.sal.binding.api.RpcConsumerRegistry;
import org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.AlibabaUGOperService;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.configuration.elem.type.Switch;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.PortPolicy;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.UpgradeStatus;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.NodeId;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.Nodes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.Node;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.NodeKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.netconf.node.inventory.rev140108.NetconfNode;
import org.opendaylight.yang.gen.v1.urn.opendaylight.netconf.node.topology.rev150114.netconf.node.fields.AvailableCapabilities;
import org.opendaylight.yang.gen.v1.urn.opendaylight.netconf.node.topology.rev150114.netconf.node.fields.UnavailableCapabilities;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bootcamp.sdn.auto.upgrade.model.util.DataBrokerUtil;
import com.bootcamp.sdn.isolation.api.service.IsolationConfiguration;
import com.bootcamp.sdn.isolation.api.service.IsolationService;
import com.bootcamp.sdn.netconfclient.service.NetconfclientAutoCloseable;
import com.bootcamp.sdn.netconfclient.service.NetconfclientConfiguration;
import com.bootcamp.sdn.netconfclient.service.NetconfclientConnectionCallback;
import com.bootcamp.sdn.netconfclient.service.NetconfclientConnectionService;
import com.google.common.base.Optional;

public class IsolationServiceImpl implements IsolationService, BindingAwareProvider {
    
    private static final Logger LOG = LoggerFactory.getLogger(IsolationServiceImpl.class);

    private static final int DEFAULT_NETCONF_PORT = 830;
    
    private static final long CONNECTION_MAX_ATTEMPTS = 10;
    
    private static final long CONNECTION_TIMEOUT_MILLIS = 1000;
    
    private NetconfclientConnectionService ncService;
    
    private DataBroker        dataBroker;

    public NetconfclientConnectionService getNcService() {
        return ncService;
    }

    public void setNcService(NetconfclientConnectionService ncService) {
        this.ncService = ncService;
    }

    @Override
    public void doIsolation(IsolationConfiguration cfg) {
        
        final Configuration con = DataBrokerUtil.getConfigurationNode(cfg.getKey(), dataBroker);
        
        if(con != null){
            InetSocketAddress address = new InetSocketAddress(con.getHost().getIpAddress().getIpv4Address().getValue(), 
                DEFAULT_NETCONF_PORT);
            NetconfclientConfiguration conn = new NetconfclientConfiguration(address, CONNECTION_MAX_ATTEMPTS,CONNECTION_TIMEOUT_MILLIS, con.getUsername(), con.getPassword());
            
            ncService.connect(conn, new NetconfclientConnectionCallback(){

                @Override
                public void validate(UnavailableCapabilities unavailableCapabilities,
                                     AvailableCapabilities availableCapabilities) {
                    LOG.info("isolation  validate!");
                }

                @Override
                public void callback(Optional<MountPoint> mountPointOptional) {
                    
                    if(mountPointOptional.isPresent()){
                        Optional<RpcConsumerRegistry> rpcServiceOption = mountPointOptional.get().getService(RpcConsumerRegistry.class);
                        
                        if(rpcServiceOption.isPresent()){
                            
                            if(((Switch)con.getElemType()).getIsolationPolicy().equals(PortPolicy.class)){
                                AlibabaUGOperService rpc = rpcServiceOption.get().getRpcService(AlibabaUGOperService.class);
                                rpc.shutdownAll();
                                
                                DataBrokerUtil.changNextStatus(con.getName(), dataBroker, UpgradeStatus.ISOLATEFLOW);
                            }
                        }
                    }
                }
            });
        }
        
    }

    @Override
    public void onSessionInitiated(ProviderContext session) {
        LOG.info("IsolationServiceImpl Session Initiated");
        
        this.dataBroker = session.getSALService(DataBroker.class);
    }

}
