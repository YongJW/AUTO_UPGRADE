package org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Uri;


/**
 * The switch software package for switch upgrading.
 * 
 * &lt;p&gt;This class represents the following YANG schema fragment defined in module &lt;b&gt;BootCamp-UG-types&lt;/b&gt;
 * &lt;br&gt;(Source path: &lt;i&gt;META-INF\yang\BootCamp-UG-types.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * grouping switch-image {
 *     leaf repository {
 *         type uri;
 *     }
 *     leaf file {
 *         type string;
 *     }
 * }
 * &lt;/pre&gt;
 * The schema path to identify an instance is
 * &lt;i&gt;BootCamp-UG-types/switch-image&lt;/i&gt;
 *
 */
public interface SwitchImage
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.cachedReference(org.opendaylight.yangtools.yang.common.QName.create("http://bootcamp.com/ns/yang/BootCamp-UG-types","2015-12-11","switch-image"));

    /**
     * The directory for the switch or config point to save the switch soft packages. 
     * The direcotry SHOULD be created automatically if not present.
     *
     */
    Uri getRepository();
    
    java.lang.String getFile();

}

