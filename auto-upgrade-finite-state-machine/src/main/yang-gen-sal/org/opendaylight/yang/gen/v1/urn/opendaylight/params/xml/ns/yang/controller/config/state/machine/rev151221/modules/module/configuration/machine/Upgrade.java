package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.state.machine.rev151221.modules.module.configuration.machine;
import org.opendaylight.yangtools.yang.binding.ChildOf;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.modules.Module;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.rev130405.ServiceRef;
import org.opendaylight.yangtools.yang.binding.Augmentable;


/**
 * &lt;p&gt;This class represents the following YANG schema fragment defined in module &lt;b&gt;state-machine&lt;/b&gt;
 * &lt;br&gt;(Source path: &lt;i&gt;META-INF\yang\finite-state-machine.yang&lt;/i&gt;):
 * &lt;pre&gt;
 * container upgrade {
 *     leaf type {
 *         type leafref;
 *     }
 *     leaf name {
 *         type leafref;
 *     }
 *     uses service-ref {
 *         refine (urn:opendaylight:params:xml:ns:yang:controller:config:state-machine?revision=2015-12-21)type {
 *             leaf type {
 *                 type leafref;
 *             }
 *         }
 *     }
 * }
 * &lt;/pre&gt;
 * The schema path to identify an instance is
 * &lt;i&gt;state-machine/modules/module/configuration/(urn:opendaylight:params:xml:ns:yang:controller:config:state-machine?revision=2015-12-21)machine/upgrade&lt;/i&gt;
 * 
 * &lt;p&gt;To create instances of this class use {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.state.machine.rev151221.modules.module.configuration.machine.UpgradeBuilder}.
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.state.machine.rev151221.modules.module.configuration.machine.UpgradeBuilder
 *
 */
public interface Upgrade
    extends
    ChildOf<Module>,
    Augmentable<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.controller.config.state.machine.rev151221.modules.module.configuration.machine.Upgrade>,
    ServiceRef
{



    public static final QName QNAME = org.opendaylight.yangtools.yang.common.QName.cachedReference(org.opendaylight.yangtools.yang.common.QName.create("urn:opendaylight:params:xml:ns:yang:controller:config:state-machine","2015-12-21","upgrade"));


}

