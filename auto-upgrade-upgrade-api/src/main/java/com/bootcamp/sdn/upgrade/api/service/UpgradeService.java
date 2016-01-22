/**
 * @author yongjie.wyj
 * @Email yongjie.wyj@alibaba-inc.com
 */
package com.bootcamp.sdn.upgrade.api.service;

import com.bootcamp.sdn.upgrade.api.service.UpgradeConfiguration;

public interface UpgradeService {

    public void doUpgrade(UpgradeConfiguration cfg);
}
