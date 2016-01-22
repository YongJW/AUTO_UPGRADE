package org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration;
import org.opendaylight.yangtools.yang.common.QName;
import java.util.List;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * Configurations for switch and config-point.
 * 
 * &lt;p&gt;This class represents the following YANG schema fragment defined in module &lt;b&gt;BootCamp-UG-cfg&lt;/b&gt;
 * &lt;br&gt;(Source path: &lt;i&gt;META-INF\yang\BootCamp-UG-cfg.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * container configurations {
 *     list configuration {
 *         key "name"
 *         leaf name {
 *             type string;
 *         }
 *         leaf type {
 *             type identityref;
 *         }
 *         leaf repository {
 *             type uri;
 *         }
 *         leaf file {
 *             type string;
 *         }
 *         leaf protocol {
 *             type protocols;
 *         }
 *         leaf ip-version {
 *             type ip-version;
 *         }
 *         leaf host {
 *             type host;
 *         }
 *         leaf port {
 *             type port-number;
 *         }
 *         leaf username {
 *             type string;
 *         }
 *         leaf password {
 *             type string;
 *         }
 *         choice elem-type {
 *             case switch {
 *                 leaf prev-status {
 *                     type upgrade-status;
 *                 }
 *                 leaf current-status {
 *                     type upgrade-status;
 *                 }
 *                 leaf isolation-policy {
 *                     type leafref;
 *                 }
 *             }
 *         }
 *         uses connection-cfg;
 *         uses switch-image;
 *     }
 * }
 * &lt;/pre&gt;
 * The schema path to identify an instance is
 * &lt;i&gt;BootCamp-UG-cfg/configurations&lt;/i&gt;
 * 
 * &lt;p&gt;To create instances of this class use {@link org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.ConfigurationsBuilder}.
 * @see org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.ConfigurationsBuilder
 *
 */
public interface Configurations
    extends
    ChildOf<BootCampUGCfgData>,
    Augmentable<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.cachedReference(org.opendaylight.yangtools.yang.common.QName.create("http://bootcamp.com/ns/yang/BootCamp-UG-cfg","2015-12-11","configurations"));

    List<Configuration> getConfiguration();

}

