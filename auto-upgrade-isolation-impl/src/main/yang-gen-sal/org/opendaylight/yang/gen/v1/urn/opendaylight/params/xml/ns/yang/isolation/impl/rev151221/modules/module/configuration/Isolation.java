package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.isolation.impl.rev151221.modules.module.configuration;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.isolation.impl.rev151221.modules.module.configuration.isolation.Broker;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.modules.module.Configuration;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.isolation.impl.rev151221.modules.module.configuration.isolation.NcClient;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * &lt;p&gt;This class represents the following YANG schema fragment defined in module &lt;b&gt;isolation-impl&lt;/b&gt;
 * &lt;br&gt;(Source path: &lt;i&gt;META-INF\yang\isolation-impl.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * case isolation {
 *     container nc-client {
 *         leaf type {
 *             type leafref;
 *         }
 *         leaf name {
 *             type leafref;
 *         }
 *         uses service-ref {
 *             refine (urn:opendaylight:params:xml:ns:yang:isolation:impl?revision=2015-12-21)type {
 *                 leaf type {
 *                     type leafref;
 *                 }
 *             }
 *         }
 *     }
 *     container broker {
 *         leaf type {
 *             type leafref;
 *         }
 *         leaf name {
 *             type leafref;
 *         }
 *         uses service-ref {
 *             refine (urn:opendaylight:params:xml:ns:yang:isolation:impl?revision=2015-12-21)type {
 *                 leaf type {
 *                     type leafref;
 *                 }
 *             }
 *         }
 *     }
 * }
 * &lt;/pre&gt;
 * The schema path to identify an instance is
 * &lt;i&gt;isolation-impl/modules/module/configuration/(urn:opendaylight:params:xml:ns:yang:isolation:impl?revision=2015-12-21)isolation&lt;/i&gt;
 *
 */
public interface Isolation
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.isolation.impl.rev151221.modules.module.configuration.Isolation>,
    Configuration
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.cachedReference(org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:isolation:impl","2015-12-21","isolation"));

    NcClient getNcClient();
    
    Broker getBroker();

}

