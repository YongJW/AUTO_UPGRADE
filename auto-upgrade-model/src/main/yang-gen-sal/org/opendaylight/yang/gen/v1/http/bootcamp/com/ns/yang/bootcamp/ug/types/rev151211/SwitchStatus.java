package org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;


/**
 * &lt;p&gt;This class represents the following YANG schema fragment defined in module &lt;b&gt;BootCamp-UG-types&lt;/b&gt;
 * &lt;br&gt;(Source path: &lt;i&gt;META-INF\yang\BootCamp-UG-types.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * grouping switch-status {
 *     leaf prev-status {
 *         type upgrade-status;
 *     }
 *     leaf current-status {
 *         type upgrade-status;
 *     }
 * }
 * &lt;/pre&gt;
 * The schema path to identify an instance is
 * &lt;i&gt;BootCamp-UG-types/switch-status&lt;/i&gt;
 *
 */
public interface SwitchStatus
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.cachedReference(org.opendaylight.yangtools.yang.common.QName.create("http://bootcamp.com/ns/yang/BootCamp-UG-types","2015-12-11","switch-status"));

    UpgradeStatus getPrevStatus();
    
    UpgradeStatus getCurrentStatus();

}

