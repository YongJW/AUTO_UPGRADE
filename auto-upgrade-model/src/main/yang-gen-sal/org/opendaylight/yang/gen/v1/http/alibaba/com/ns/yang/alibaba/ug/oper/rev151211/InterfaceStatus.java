package org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * &lt;p&gt;This class represents the following YANG schema fragment defined in module &lt;b&gt;Alibaba-UG-oper&lt;/b&gt;
 * &lt;br&gt;(Source path: &lt;i&gt;META-INF\yang\Alibaba-UG-oper.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * container interface-status {
 *     leaf stub {
 *         type string;
 *     }
 * }
 * &lt;/pre&gt;
 * The schema path to identify an instance is
 * &lt;i&gt;Alibaba-UG-oper/interface-status&lt;/i&gt;
 * 
 * &lt;p&gt;To create instances of this class use {@link org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatusBuilder}.
 * @see org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatusBuilder
 *
 */
public interface InterfaceStatus
    extends
    ChildOf<AlibabaUGOperData>,
    Augmentable<org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.cachedReference(org.opendaylight.yangtools.yang.common.QName.create("http://alibaba.com/ns/yang/Alibaba-UG-oper","2015-12-11","interface-status"));

    /**
     * do not need to sava any data yet, just used to work with pyang.
     *
     */
    java.lang.String getStub();

}

