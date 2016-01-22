package org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.Protocols;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.IpVersion;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Host;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.PortNumber;


/**
 * &lt;p&gt;This class represents the following YANG schema fragment defined in module &lt;b&gt;BootCamp-UG-cfg&lt;/b&gt;
 * &lt;br&gt;(Source path: &lt;i&gt;META-INF\yang\BootCamp-UG-cfg.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * grouping connection-cfg {
 *     leaf protocol {
 *         type protocols;
 *     }
 *     leaf ip-version {
 *         type ip-version;
 *     }
 *     leaf host {
 *         type host;
 *     }
 *     leaf port {
 *         type port-number;
 *     }
 *     leaf username {
 *         type string;
 *     }
 *     leaf password {
 *         type string;
 *     }
 * }
 * &lt;/pre&gt;
 * The schema path to identify an instance is
 * &lt;i&gt;BootCamp-UG-cfg/connection-cfg&lt;/i&gt;
 *
 */
public interface ConnectionCfg
    extends
    DataObject
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.cachedReference(org.opendaylight.yangtools.yang.common.QName.create("http://bootcamp.com/ns/yang/BootCamp-UG-cfg","2015-12-11","connection-cfg"));

    Protocols getProtocol();
    
    IpVersion getIpVersion();
    
    Host getHost();
    
    PortNumber getPort();
    
    java.lang.String getUsername();
    
    java.lang.String getPassword();

}

