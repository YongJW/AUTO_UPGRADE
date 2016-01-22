package org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211;
import org.opendaylight.yangtools.yang.binding.DataRoot;


/**
 * All rights reserved.
 * 
 * &lt;p&gt;This class represents the following YANG schema fragment defined in module &lt;b&gt;BootCamp-UG-cfg&lt;/b&gt;
 * &lt;br&gt;Source path: &lt;i&gt;META-INF\yang\BootCamp-UG-cfg.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * module BootCamp-UG-cfg {
 *     yang-version 1;
 *     namespace "http://bootcamp.com/ns/yang/BootCamp-UG-cfg";
 *     prefix "cfg";
 * 
 *     import BootCamp-UG-types { prefix "types"; }
 *     
 *     import BootCamp-UG-isolation { prefix "iso"; }
 *     
 *     import ietf-inet-types { prefix "inet"; }
 *     revision 2015-12-11 {
 *         description "All rights reserved.
 *         ";
 *     }
 * 
 *     container configurations {
 *         list configuration {
 *             key "name"
 *             leaf name {
 *                 type string;
 *             }
 *             leaf type {
 *                 type identityref;
 *             }
 *             leaf repository {
 *                 type uri;
 *             }
 *             leaf file {
 *                 type string;
 *             }
 *             leaf protocol {
 *                 type protocols;
 *             }
 *             leaf ip-version {
 *                 type ip-version;
 *             }
 *             leaf host {
 *                 type host;
 *             }
 *             leaf port {
 *                 type port-number;
 *             }
 *             leaf username {
 *                 type string;
 *             }
 *             leaf password {
 *                 type string;
 *             }
 *             choice elem-type {
 *                 case switch {
 *                     leaf prev-status {
 *                         type upgrade-status;
 *                     }
 *                     leaf current-status {
 *                         type upgrade-status;
 *                     }
 *                     leaf isolation-policy {
 *                         type leafref;
 *                     }
 *                 }
 *             }
 *             uses connection-cfg;
 *             uses switch-image;
 *         }
 *     }
 * 
 *     grouping connection-cfg {
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
 *     }
 * 
 *     identity cfg-type {
 *         description
 *             "Base type for config item.";
 *         status CURRENT;
 *     }
 *     identity cfgpoint {
 *         base "()IdentitySchemaNodeImpl[base=null, qname=(http://bootcamp.com/ns/yang/BootCamp-UG-cfg?revision=2015-12-11)cfg-type]";
 *         status CURRENT;
 *     }
 *     identity switch {
 *         base "()IdentitySchemaNodeImpl[base=null, qname=(http://bootcamp.com/ns/yang/BootCamp-UG-cfg?revision=2015-12-11)cfg-type]";
 *         status CURRENT;
 *     }
 * }
 * &lt;/pre&gt;
 *
 */
public interface BootCampUGCfgData
    extends
    DataRoot
{




    /**
     * Configurations for switch and config-point.
     *
     */
    Configurations getConfigurations();

}

