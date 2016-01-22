/**
 * @author yongjie.wyj
 * @Email yongjie.wyj@bootcamp-inc.com
 */
package com.bootcamp.sdn.finite.state.machine.step;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.optional.ssh.Scp;
import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.md.sal.binding.api.ReadWriteTransaction;
import org.opendaylight.controller.md.sal.common.api.data.LogicalDatastoreType;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.ConfigurationBuilder;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.ConfigurationKey;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.configuration.elem.type.Switch;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.configuration.elem.type.SwitchBuilder;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.UpgradeStatus;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bootcamp.sdn.auto.upgrade.model.util.DataBrokerUtil;
import com.google.common.base.Optional;

public class CopyImageStepImpl implements StepExecute{

    private static final Logger LOG = LoggerFactory.getLogger(CopyImageStepImpl.class);
    
    private DataBroker dataBroker;

    public CopyImageStepImpl(DataBroker dataBroker) {
        this.dataBroker = dataBroker;
    }

    @Override
    public boolean execute(String key) throws Exception {
        
        Configuration sw = DataBrokerUtil.getConfigurationNode(key, dataBroker);
        //TODO Node name
        Configuration local = DataBrokerUtil.getConfigurationNode("controller-config", dataBroker);
        try{
            scpFile(sw.getHost().getIpAddress().getIpv4Address().getValue(),
                sw.getPort().getValue(),sw.getUsername(),sw.getPassword(),
                local.getRepository().getValue() + System.getProperty("file.separator") + local.getFile(),
                sw.getRepository().getValue() + System.getProperty("file.separator") + sw.getFile());
            DataBrokerUtil.changNextStatus(key, dataBroker, UpgradeStatus.COPYIMAGE);
            return true;
        }catch(Exception e){
            LOG.error("CopyImage Step Error:" + e); 
            return false;
        }
    }

    public static final void scpFile(String host,int port,String username,
            String password,String localFile,String remoteFile) throws Exception{
        
        Scp scp = new Scp();
        scp.setPort(port);
        scp.setLocalFile(localFile);
        scp.setTodir(username + ":" + password + "@" + host + ":" + remoteFile );
        scp.setProject(new Project());
        scp.setTrust(true);
        scp.execute();
    }
}
