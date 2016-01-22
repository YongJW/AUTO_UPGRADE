/**
 * @author yongjie.wyj
 * @Email yongjie.wyj@bootcamp-inc.com
 */
package com.bootcamp.sdn.auto.upgrade.model.util;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.ReadOnlyTransaction;
import org.opendaylight.controller.md.sal.binding.api.ReadWriteTransaction;
import org.opendaylight.controller.md.sal.binding.api.WriteTransaction;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.ConfigurationBuilder;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.ConfigurationKey;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.configuration.elem.type.Switch;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.configuration.elem.type.SwitchBuilder;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.UpgradeStatus;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.Nodes;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.Node;
import org.opendaylight.yang.gen.v1.urn.opendaylight.inventory.rev130819.nodes.NodeKey;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;

public class DataBrokerUtil {

    private static final Logger LOG = LoggerFactory.getLogger(DataBrokerUtil.class);
    
    public static Configuration getConfigurationNode(final String key,DataBroker dataBroker){
        
        Optional<Configuration> optional = null;
        ReadOnlyTransaction tx = dataBroker.newReadOnlyTransaction();
        
        try {
            optional = tx.read(LogicalDatastoreType.CONFIGURATION, InstanceIdentifier.builder(Configurations.class)
                .child(Configuration.class, new ConfigurationKey(key)).toInstance()).get();
        } catch (Exception e) {
            LOG.error("getConfigurationNode Container Fail!");
            return null;
        }
        
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }
    
    public static Node getInventoryNode(final String key,DataBroker dataBroker){
        
        ReadOnlyTransaction tx = dataBroker.newReadOnlyTransaction();
        Optional<Nodes> optional = null;
        
        try {
            optional = tx.read(LogicalDatastoreType.OPERATIONAL,InstanceIdentifier.builder( Nodes.class ).build()).get();
        } catch (Exception e) {
            LOG.error("getInventoryNode Fail!");
            return null;
        } 
        
        if(optional.isPresent()){
            List<Node> nodes = ((Nodes)optional.get()).getNode();
            for(Node node : nodes){
                if(node.getId().getValue().equals(key)){
                    return node;
                }
            }
            
        }
        return null;
    }
    
    public static boolean changNextStatus(final String key,DataBroker dataBroker,UpgradeStatus next){
        
        ReadWriteTransaction tx = dataBroker.newReadWriteTransaction();
        Optional<Configuration> option;
        try {
            option = tx.read(LogicalDatastoreType.CONFIGURATION,InstanceIdentifier.builder(Configurations.class)
                .child(Configuration.class, new ConfigurationKey(key)).toInstance()).get();
        } catch (Exception e) {
            LOG.error("read Configuration:Key=" + key + " Fail!");
            return false;
        }
        
        if(option.isPresent()){
            Configuration cfg = option.get();
            
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setName(cfg.getName());
            cb.setType(org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Switch.class);
            cb.setRepository(cfg.getRepository());
            cb.setFile(cfg.getFile());
            cb.setProtocol(cfg.getProtocol());
            cb.setIpVersion(cfg.getIpVersion());
            cb.setHost(cfg.getHost());
            cb.setPort(cfg.getPort());
            cb.setUsername(cfg.getUsername());
            cb.setPassword(cfg.getPassword());
            
            SwitchBuilder sb = new SwitchBuilder();
            sb.setIsolationPolicy(((Switch)cfg.getElemType()).getIsolationPolicy());
            sb.setPrevStatus(UpgradeStatus.forValue(next.getIntValue() - 1));
            sb.setCurrentStatus(next);
            cb.setElemType(sb.build());
            
            tx.put(LogicalDatastoreType.CONFIGURATION, InstanceIdentifier.builder(Configurations.class)
                .child(Configuration.class, new ConfigurationKey(cfg.getName())).toInstance(), cb.build());
            tx.submit();
        
        }
        return true;
    }
}
