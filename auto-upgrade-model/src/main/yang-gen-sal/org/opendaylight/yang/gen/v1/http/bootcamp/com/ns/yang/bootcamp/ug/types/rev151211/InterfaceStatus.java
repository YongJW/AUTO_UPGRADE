package org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import java.util.List;


/**
 * &lt;p&gt;This class represents the following YANG schema fragment defined in module &lt;b&gt;BootCamp-UG-types&lt;/b&gt;
 * &lt;br&gt;(Source path: &lt;i&gt;META-INF\yang\BootCamp-UG-types.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * grouping interface-status {
 *     list interfaces {
 *         key "type" 
 *     "name"
 *         leaf type {
 *             type interface-type;
 *         }
 *         leaf name {
 *             type string;
 *         }
 *         leaf prev-state {
 *             type interface-state;
 *         }
 *         leaf cur-state {
 *             type interface-state;
 *         }
 *         uses interface;
 *     }
 * }
 * &lt;/pre&gt;
 * The schema path to identify an instance is
 * &lt;i&gt;BootCamp-UG-types/interface-status&lt;/i&gt;
 *
 */
public interface InterfaceStatus
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.cachedReference(org.opendaylight.yangtools.yang.common.QName.create("http://bootcamp.com/ns/yang/BootCamp-UG-types","2015-12-11","interface-status"));

    List<Interfaces> getInterfaces();

}

