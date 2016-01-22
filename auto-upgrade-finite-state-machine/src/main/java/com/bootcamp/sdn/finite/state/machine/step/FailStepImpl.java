/**
 * @author yongjie.wyj
 * @Email yongjie.wyj@bootcamp-inc.com
 */
package com.bootcamp.sdn.finite.state.machine.step;

import org.opendaylight.controller.sal.binding.api.BindingAwareBroker.ProviderContext;

public class FailStepImpl implements StepExecute{


    @Override
    public boolean execute(String key) throws Exception {
        return false;
    }

}
