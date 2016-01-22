package org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.configuration;
import org.opendaylight.yangtools.yang.binding.DataContainer;
import org.opendaylight.yangtools.yang.common.QName;


/**
 * &lt;p&gt;This class represents the following YANG schema fragment defined in module &lt;b&gt;BootCamp-UG-cfg&lt;/b&gt;
 * &lt;br&gt;(Source path: &lt;i&gt;META-INF\yang\BootCamp-UG-cfg.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * choice elem-type {
 *     case switch {
 *         leaf prev-status {
 *             type upgrade-status;
 *         }
 *         leaf current-status {
 *             type upgrade-status;
 *         }
 *         leaf isolation-policy {
 *             type leafref;
 *         }
 *     }
 * }
 * &lt;/pre&gt;
 * The schema path to identify an instance is
 * &lt;i&gt;BootCamp-UG-cfg/configurations/configuration/elem-type&lt;/i&gt;
 *
 */
public interface ElemType
    extends
    DataContainer
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.cachedReference(org.opendaylight.yangtools.yang.common.QName.create("http://bootcamp.com/ns/yang/BootCamp-UG-cfg","2015-12-11","elem-type"));


}

