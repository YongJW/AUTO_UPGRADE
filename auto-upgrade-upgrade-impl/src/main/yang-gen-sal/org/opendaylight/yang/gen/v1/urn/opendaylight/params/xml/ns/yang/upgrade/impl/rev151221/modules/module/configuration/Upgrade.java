package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.upgrade.Broker;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.modules.module.Configuration;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.upgrade.NcClient;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * &lt;p&gt;This class represents the following YANG schema fragment defined in module &lt;b&gt;upgrade-impl&lt;/b&gt;
 * &lt;br&gt;(Source path: &lt;i&gt;META-INF\yang\yang-upgrade-impl.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * case upgrade {
 *     container nc-client {
 *         leaf type {
 *             type leafref;
 *         }
 *         leaf name {
 *             type leafref;
 *         }
 *         uses service-ref {
 *             refine (urn:opendaylight:params:xml:ns:yang:upgrade:impl?revision=2015-12-21)type {
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
 *             refine (urn:opendaylight:params:xml:ns:yang:upgrade:impl?revision=2015-12-21)type {
 *                 leaf type {
 *                     type leafref;
 *                 }
 *             }
 *         }
 *     }
 * }
 * &lt;/pre&gt;
 * The schema path to identify an instance is
 * &lt;i&gt;upgrade-impl/modules/module/configuration/(urn:opendaylight:params:xml:ns:yang:upgrade:impl?revision=2015-12-21)upgrade&lt;/i&gt;
 *
 */
public interface Upgrade
    extends
    DataObject,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade>,
    Configuration
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.cachedReference(org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:upgrade:impl","2015-12-21","upgrade"));

    NcClient getNcClient();
    
    Broker getBroker();

}

