package org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211;
import org.opendaylight.yangtools.yang.binding.DataRoot;


/**
 * All rights reserved.
 * 
 * &lt;p&gt;This class represents the following YANG schema fragment defined in module &lt;b&gt;BootCamp-UG-isolation&lt;/b&gt;
 * &lt;br&gt;Source path: &lt;i&gt;META-INF\yang\BootCamp-UG-isolation.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * module BootCamp-UG-isolation {
 *     yang-version 1;
 *     namespace "http://bootcamp.com/ns/yang/BootCamp-UG-isolation";
 *     prefix "iso";
 * 
 *     revision 2015-12-11 {
 *         description "All rights reserved.
 *         ";
 *     }
 * 
 *     container isolation-policies {
 *         list policy {
 *             key "type"
 *             leaf type {
 *                 type identityref;
 *             }
 *         }
 *     }
 * 
 *     identity policy-type {
 *         description
 *             "Policy identity base type. All policy identities must be derived from this type.";
 *         status CURRENT;
 *     }
 *     identity port-policy {
 *         base "()IdentitySchemaNodeImpl[base=null, qname=(http://bootcamp.com/ns/yang/BootCamp-UG-isolation?revision=2015-12-11)policy-type]";
 *         description
 *             "Port identity base type.";
 *         status CURRENT;
 *     }
 * }
 * &lt;/pre&gt;
 *
 */
public interface BootCampUGIsolationData
    extends
    DataRoot
{




    IsolationPolicies getIsolationPolicies();

}

