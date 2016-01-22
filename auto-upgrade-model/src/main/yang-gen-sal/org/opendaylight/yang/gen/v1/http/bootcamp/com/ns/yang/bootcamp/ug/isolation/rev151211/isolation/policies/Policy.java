package org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.IsolationPolicies;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yangtools.yang.binding.Identifiable;


/**
 * &lt;p&gt;This class represents the following YANG schema fragment defined in module &lt;b&gt;BootCamp-UG-isolation&lt;/b&gt;
 * &lt;br&gt;(Source path: &lt;i&gt;META-INF\yang\BootCamp-UG-isolation.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * list policy {
 *     key "type"
 *     leaf type {
 *         type identityref;
 *     }
 * }
 * &lt;/pre&gt;
 * The schema path to identify an instance is
 * &lt;i&gt;BootCamp-UG-isolation/isolation-policies/policy&lt;/i&gt;
 * 
 * &lt;p&gt;To create instances of this class use {@link org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.PolicyBuilder}.
 * @see org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.PolicyBuilder
 * @see org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.PolicyKey
 *
 */
public interface Policy
    extends
    ChildOf<IsolationPolicies>,
    Augmentable<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy>,
    Identifiable<PolicyKey>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.cachedReference(org.opendaylight.yangtools.yang.common.QName.create("http://bootcamp.com/ns/yang/BootCamp-UG-isolation","2015-12-11","policy"));

    java.lang.Class<? extends org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.PolicyType> getType();
    
    /**
     * Returns Primary Key of Yang List Type
     *
     */
    PolicyKey getKey();

}

