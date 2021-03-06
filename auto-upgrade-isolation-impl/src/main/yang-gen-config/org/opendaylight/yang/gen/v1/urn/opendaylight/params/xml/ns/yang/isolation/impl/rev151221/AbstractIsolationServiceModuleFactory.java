/*
* Generated file
*
* Generated from: yang module name: isolation-impl yang module local name: isolation
* Generated by: org.opendaylight.controller.config.yangjmxgenerator.plugin.JMXGenerator
* Generated at: Fri Jan 22 22:23:01 CST 2016
*
* Do not modify this file unless it is present under src/main directory
*/
package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.isolation.impl.rev151221;
@org.opendaylight.yangtools.yang.binding.annotations.ModuleQName(namespace = "urn:opendaylight:params:xml:ns:yang:isolation:impl", name = "isolation-impl", revision = "2015-12-21")

public abstract class AbstractIsolationServiceModuleFactory implements org.opendaylight.controller.config.spi.ModuleFactory {
    public static final java.lang.String NAME = "isolation";

    private static final java.util.Set<Class<? extends org.opendaylight.controller.config.api.annotations.AbstractServiceInterface>> serviceIfcs;

    @Override
    public final String getImplementationName() {
        return NAME;
    }

    static {
        java.util.Set<Class<? extends org.opendaylight.controller.config.api.annotations.AbstractServiceInterface>> serviceIfcs2 = new java.util.HashSet<Class<? extends org.opendaylight.controller.config.api.annotations.AbstractServiceInterface>>();
        serviceIfcs2.add(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.isolation.impl.rev151221.IsolationServiceServiceInterface.class);
        serviceIfcs = java.util.Collections.unmodifiableSet(serviceIfcs2);
    }

    @Override
    public final boolean isModuleImplementingServiceInterface(Class<? extends org.opendaylight.controller.config.api.annotations.AbstractServiceInterface> serviceInterface) {
        for (Class<?> ifc: serviceIfcs) {
            if (serviceInterface.isAssignableFrom(ifc)){
                return true;
            }
        }
        return false;
    }

    @Override
    public java.util.Set<Class<? extends org.opendaylight.controller.config.api.annotations.AbstractServiceInterface>> getImplementedServiceIntefaces() {
        return serviceIfcs;
    }

    @Override
    public org.opendaylight.controller.config.spi.Module createModule(String instanceName, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver, org.osgi.framework.BundleContext bundleContext) {
        return instantiateModule(instanceName, dependencyResolver, bundleContext);
    }

    @Override
    public org.opendaylight.controller.config.spi.Module createModule(String instanceName, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver, org.opendaylight.controller.config.api.DynamicMBeanWithInstance old, org.osgi.framework.BundleContext bundleContext) throws Exception {
        org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.isolation.impl.rev151221.IsolationServiceModule oldModule = null;
        try {
            oldModule = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.isolation.impl.rev151221.IsolationServiceModule) old.getModule();
        } catch(Exception e) {
            return handleChangedClass(old);
        }
        org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.isolation.impl.rev151221.IsolationServiceModule module = instantiateModule(instanceName, dependencyResolver, oldModule, old.getInstance(), bundleContext);
        module.setNcClient(oldModule.getNcClient());
        module.setBroker(oldModule.getBroker());

        return module;
    }

    public org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.isolation.impl.rev151221.IsolationServiceModule instantiateModule(String instanceName, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver, org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.isolation.impl.rev151221.IsolationServiceModule oldModule, java.lang.AutoCloseable oldInstance, org.osgi.framework.BundleContext bundleContext) {
        return new org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.isolation.impl.rev151221.IsolationServiceModule(new org.opendaylight.controller.config.api.ModuleIdentifier(NAME, instanceName), dependencyResolver, oldModule, oldInstance);
    }

    public org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.isolation.impl.rev151221.IsolationServiceModule instantiateModule(String instanceName, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver, org.osgi.framework.BundleContext bundleContext) {
        return new org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.isolation.impl.rev151221.IsolationServiceModule(new org.opendaylight.controller.config.api.ModuleIdentifier(NAME, instanceName), dependencyResolver);
    }

    public org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.isolation.impl.rev151221.IsolationServiceModule handleChangedClass(org.opendaylight.controller.config.api.DynamicMBeanWithInstance old) throws Exception {
        throw new UnsupportedOperationException("Class reloading is not supported");
    }

    @Override
    public java.util.Set<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.isolation.impl.rev151221.IsolationServiceModule> getDefaultModules(org.opendaylight.controller.config.api.DependencyResolverFactory dependencyResolverFactory, org.osgi.framework.BundleContext bundleContext) {
        return new java.util.HashSet<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.isolation.impl.rev151221.IsolationServiceModule>();
    }

}
