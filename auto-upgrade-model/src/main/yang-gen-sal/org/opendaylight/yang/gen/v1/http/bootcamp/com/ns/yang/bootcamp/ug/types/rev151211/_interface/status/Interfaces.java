package org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.InterfaceState;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.InterfaceStatus;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.binding.Augmentable;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.Interface;
import org.opendaylight.yangtools.yang.binding.Identifiable;


/**
 * &lt;p&gt;This class represents the following YANG schema fragment defined in module &lt;b&gt;BootCamp-UG-types&lt;/b&gt;
 * &lt;br&gt;(Source path: &lt;i&gt;META-INF\yang\BootCamp-UG-types.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * list interfaces {
 *     key "type" 
 * "name"
 *     leaf type {
 *         type interface-type;
 *     }
 *     leaf name {
 *         type string;
 *     }
 *     leaf prev-state {
 *         type interface-state;
 *     }
 *     leaf cur-state {
 *         type interface-state;
 *     }
 *     uses interface;
 * }
 * &lt;/pre&gt;
 * The schema path to identify an instance is
 * &lt;i&gt;BootCamp-UG-types/interface-status/interfaces&lt;/i&gt;
 * 
 * &lt;p&gt;To create instances of this class use {@link org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.InterfacesBuilder}.
 * @see org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.InterfacesBuilder
 * @see org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.InterfacesKey
 *
 */
public interface Interfaces
    extends
    ChildOf<InterfaceStatus>,
    Augmentable<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces>,
    Interface,
    Identifiable<InterfacesKey>
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.cachedReference(org.opendaylight.yangtools.yang.common.QName.create("http://bootcamp.com/ns/yang/BootCamp-UG-types","2015-12-11","interfaces"));

    InterfaceState getPrevState();
    
    InterfaceState getCurState();
    
    /**
     * Returns Primary Key of Yang List Type
     *
     */
    InterfacesKey getKey();

}

