/**
 * @author yongjie.wyj
 * @Email yongjie.wyj@bootcamp-inc.com
 */
package com.bootcamp.sdn.finite.state.machine.step;

import org.opendaylight.controller.config.yang.config.state_machine.MachineModule;
import org.opendaylight.controller.sal.binding.api.BindingAwareProvider;

public interface StepExecute{
    
    public boolean execute(String key) throws Exception;
}
