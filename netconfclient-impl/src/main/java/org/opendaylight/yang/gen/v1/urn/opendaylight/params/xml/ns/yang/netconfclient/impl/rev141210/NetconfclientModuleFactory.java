/*
* Generated file
*
* Generated from: yang module name: netconfclient-impl yang module local name: netconfclient
* Generated by: org.opendaylight.controller.config.yangjmxgenerator.plugin.JMXGenerator
* Generated at: Fri Jan 22 21:22:46 CST 2016
*
* Do not modify this file unless it is present under src/main directory
*/
package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210;

import org.opendaylight.controller.config.api.DependencyResolver;
import org.opendaylight.controller.config.api.DynamicMBeanWithInstance;
import org.opendaylight.controller.config.spi.Module;
import org.osgi.framework.BundleContext;

public class NetconfclientModuleFactory extends org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.AbstractNetconfclientModuleFactory {

    @Override
    public Module createModule(final String instanceName, final DependencyResolver dependencyResolver,
                               final DynamicMBeanWithInstance old, final BundleContext bundleContext) throws Exception {
        final NetconfclientModule module = (NetconfclientModule) super.createModule(instanceName, dependencyResolver,
                old, bundleContext);
        module.setBundleContext(bundleContext);
        return module;
    }

    @Override
    public Module createModule(final String instanceName, final DependencyResolver dependencyResolver, final BundleContext bundleContext) {
        final NetconfclientModule module = (NetconfclientModule) super.createModule(instanceName, dependencyResolver,
                bundleContext);
        module.setBundleContext(bundleContext);
        return module;
    }

}