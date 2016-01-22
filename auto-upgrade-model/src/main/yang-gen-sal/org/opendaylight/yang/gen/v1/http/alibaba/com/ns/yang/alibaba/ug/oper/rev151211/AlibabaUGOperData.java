package org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211;
import org.opendaylight.yangtools.yang.binding.DataRoot;


/**
 * All rights reserved.
 * 
 * &lt;p&gt;This class represents the following YANG schema fragment defined in module &lt;b&gt;Alibaba-UG-oper&lt;/b&gt;
 * &lt;br&gt;Source path: &lt;i&gt;META-INF\yang\Alibaba-UG-oper.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * module Alibaba-UG-oper {
 *     yang-version 1;
 *     namespace "http://alibaba.com/ns/yang/Alibaba-UG-oper";
 *     prefix "oper";
 * 
 *     revision 2015-12-11 {
 *         description "All rights reserved.
 *         ";
 *     }
 * 
 *     container interface-status {
 *         leaf stub {
 *             type string;
 *         }
 *     }
 * 
 *     rpc shutdown-all {
 *         status CURRENT;
 *     }
 *     rpc upgrade {
 *         status CURRENT;
 *     }
 * }
 * &lt;/pre&gt;
 *
 */
public interface AlibabaUGOperData
    extends
    DataRoot
{




    InterfaceStatus getInterfaceStatus();

}

