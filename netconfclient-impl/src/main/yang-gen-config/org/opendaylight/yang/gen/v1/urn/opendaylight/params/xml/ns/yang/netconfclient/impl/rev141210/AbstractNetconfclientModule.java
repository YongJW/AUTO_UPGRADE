/*
* Generated file
*
* Generated from: yang module name: netconfclient-impl yang module local name: netconfclient
* Generated by: org.opendaylight.controller.config.yangjmxgenerator.plugin.JMXGenerator
* Generated at: Fri Jan 22 21:29:03 CST 2016
*
* Do not modify this file unless it is present under src/main directory
*/
package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210;
@org.opendaylight.yangtools.yang.binding.annotations.ModuleQName(namespace = "urn:opendaylight:params:xml:ns:yang:netconfclient:impl", name = "netconfclient-impl", revision = "2014-12-10")

public abstract class AbstractNetconfclientModule extends org.opendaylight.controller.config.spi.AbstractModule<AbstractNetconfclientModule> implements org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.NetconfclientModuleMXBean,org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.NetconfclientConnectionServiceServiceInterface {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.AbstractNetconfclientModule.class);

    //attributes start

    public static final org.opendaylight.controller.config.api.JmxAttribute eventExecutorJmxAttribute = new org.opendaylight.controller.config.api.JmxAttribute("EventExecutor");
    private javax.management.ObjectName eventExecutor; // mandatory

    public static final org.opendaylight.controller.config.api.JmxAttribute processingExecutorJmxAttribute = new org.opendaylight.controller.config.api.JmxAttribute("ProcessingExecutor");
    private javax.management.ObjectName processingExecutor; // mandatory

    public static final org.opendaylight.controller.config.api.JmxAttribute bindingRegistryJmxAttribute = new org.opendaylight.controller.config.api.JmxAttribute("BindingRegistry");
    private javax.management.ObjectName bindingRegistry; // mandatory

    public static final org.opendaylight.controller.config.api.JmxAttribute clientDispatcherJmxAttribute = new org.opendaylight.controller.config.api.JmxAttribute("ClientDispatcher");
    private javax.management.ObjectName clientDispatcher; // mandatory

    public static final org.opendaylight.controller.config.api.JmxAttribute domRegistryJmxAttribute = new org.opendaylight.controller.config.api.JmxAttribute("DomRegistry");
    private javax.management.ObjectName domRegistry; // mandatory

    public static final org.opendaylight.controller.config.api.JmxAttribute keepaliveExecutorJmxAttribute = new org.opendaylight.controller.config.api.JmxAttribute("KeepaliveExecutor");
    private javax.management.ObjectName keepaliveExecutor; // mandatory

    //attributes end

    public AbstractNetconfclientModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier,org.opendaylight.controller.config.api.DependencyResolver dependencyResolver) {
        super(identifier, dependencyResolver);
    }

    public AbstractNetconfclientModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier,org.opendaylight.controller.config.api.DependencyResolver dependencyResolver,AbstractNetconfclientModule oldModule,java.lang.AutoCloseable oldInstance) {
        super(identifier, dependencyResolver, oldModule, oldInstance);
    }

    @Override
    public void validate() {
        dependencyResolver.validateDependency(org.opendaylight.controller.config.yang.netty.EventExecutorServiceInterface.class, eventExecutor, eventExecutorJmxAttribute);
        dependencyResolver.validateDependency(org.opendaylight.controller.config.yang.threadpool.ThreadPoolServiceInterface.class, processingExecutor, processingExecutorJmxAttribute);
        dependencyResolver.validateDependency(org.opendaylight.controller.config.yang.md.sal.binding.BindingAwareBrokerServiceInterface.class, bindingRegistry, bindingRegistryJmxAttribute);
        dependencyResolver.validateDependency(org.opendaylight.controller.config.yang.config.netconf.NetconfClientDispatcherServiceInterface.class, clientDispatcher, clientDispatcherJmxAttribute);
        dependencyResolver.validateDependency(org.opendaylight.controller.config.yang.md.sal.dom.BrokerServiceInterface.class, domRegistry, domRegistryJmxAttribute);
        dependencyResolver.validateDependency(org.opendaylight.controller.config.yang.threadpool.ScheduledThreadPoolServiceInterface.class, keepaliveExecutor, keepaliveExecutorJmxAttribute);

        customValidation();
    }

    protected void customValidation() {
    }

    private io.netty.util.concurrent.EventExecutor eventExecutorDependency;
    protected final io.netty.util.concurrent.EventExecutor getEventExecutorDependency(){
        return eventExecutorDependency;
    }private org.opendaylight.controller.config.threadpool.ThreadPool processingExecutorDependency;
    protected final org.opendaylight.controller.config.threadpool.ThreadPool getProcessingExecutorDependency(){
        return processingExecutorDependency;
    }private org.opendaylight.controller.sal.binding.api.BindingAwareBroker bindingRegistryDependency;
    protected final org.opendaylight.controller.sal.binding.api.BindingAwareBroker getBindingRegistryDependency(){
        return bindingRegistryDependency;
    }private org.opendaylight.controller.netconf.client.NetconfClientDispatcher clientDispatcherDependency;
    protected final org.opendaylight.controller.netconf.client.NetconfClientDispatcher getClientDispatcherDependency(){
        return clientDispatcherDependency;
    }private org.opendaylight.controller.sal.core.api.Broker domRegistryDependency;
    protected final org.opendaylight.controller.sal.core.api.Broker getDomRegistryDependency(){
        return domRegistryDependency;
    }private org.opendaylight.controller.config.threadpool.ScheduledThreadPool keepaliveExecutorDependency;
    protected final org.opendaylight.controller.config.threadpool.ScheduledThreadPool getKeepaliveExecutorDependency(){
        return keepaliveExecutorDependency;
    }

    protected final void resolveDependencies() {
        keepaliveExecutorDependency = dependencyResolver.resolveInstance(org.opendaylight.controller.config.threadpool.ScheduledThreadPool.class, keepaliveExecutor, keepaliveExecutorJmxAttribute);
        processingExecutorDependency = dependencyResolver.resolveInstance(org.opendaylight.controller.config.threadpool.ThreadPool.class, processingExecutor, processingExecutorJmxAttribute);
        bindingRegistryDependency = dependencyResolver.resolveInstance(org.opendaylight.controller.sal.binding.api.BindingAwareBroker.class, bindingRegistry, bindingRegistryJmxAttribute);
        domRegistryDependency = dependencyResolver.resolveInstance(org.opendaylight.controller.sal.core.api.Broker.class, domRegistry, domRegistryJmxAttribute);
        clientDispatcherDependency = dependencyResolver.resolveInstance(org.opendaylight.controller.netconf.client.NetconfClientDispatcher.class, clientDispatcher, clientDispatcherJmxAttribute);
        eventExecutorDependency = dependencyResolver.resolveInstance(io.netty.util.concurrent.EventExecutor.class, eventExecutor, eventExecutorJmxAttribute);
    }

    public boolean canReuseInstance(AbstractNetconfclientModule oldModule){
        // allow reusing of old instance if no parameters was changed
        return isSame(oldModule);
    }

    public java.lang.AutoCloseable reuseInstance(java.lang.AutoCloseable oldInstance){
        // implement if instance reuse should be supported. Override canReuseInstance to change the criteria.
        return oldInstance;
    }

    public boolean isSame(AbstractNetconfclientModule other) {
        if (other == null) {
            throw new IllegalArgumentException("Parameter 'other' is null");
        }
        if (java.util.Objects.deepEquals(eventExecutor, other.eventExecutor) == false) {
            return false;
        }
        if(eventExecutor!= null) {
            if (!dependencyResolver.canReuseDependency(eventExecutor, eventExecutorJmxAttribute)) { // reference to dependency must be reusable as well
                return false;
            }
        }
        if (java.util.Objects.deepEquals(processingExecutor, other.processingExecutor) == false) {
            return false;
        }
        if(processingExecutor!= null) {
            if (!dependencyResolver.canReuseDependency(processingExecutor, processingExecutorJmxAttribute)) { // reference to dependency must be reusable as well
                return false;
            }
        }
        if (java.util.Objects.deepEquals(bindingRegistry, other.bindingRegistry) == false) {
            return false;
        }
        if(bindingRegistry!= null) {
            if (!dependencyResolver.canReuseDependency(bindingRegistry, bindingRegistryJmxAttribute)) { // reference to dependency must be reusable as well
                return false;
            }
        }
        if (java.util.Objects.deepEquals(clientDispatcher, other.clientDispatcher) == false) {
            return false;
        }
        if(clientDispatcher!= null) {
            if (!dependencyResolver.canReuseDependency(clientDispatcher, clientDispatcherJmxAttribute)) { // reference to dependency must be reusable as well
                return false;
            }
        }
        if (java.util.Objects.deepEquals(domRegistry, other.domRegistry) == false) {
            return false;
        }
        if(domRegistry!= null) {
            if (!dependencyResolver.canReuseDependency(domRegistry, domRegistryJmxAttribute)) { // reference to dependency must be reusable as well
                return false;
            }
        }
        if (java.util.Objects.deepEquals(keepaliveExecutor, other.keepaliveExecutor) == false) {
            return false;
        }
        if(keepaliveExecutor!= null) {
            if (!dependencyResolver.canReuseDependency(keepaliveExecutor, keepaliveExecutorJmxAttribute)) { // reference to dependency must be reusable as well
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractNetconfclientModule that = (AbstractNetconfclientModule) o;
        return identifier.equals(that.identifier);
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }

    // getters and setters
    @Override
    public javax.management.ObjectName getEventExecutor() {
        return eventExecutor;
    }

    @Override
    @org.opendaylight.controller.config.api.annotations.RequireInterface(value = org.opendaylight.controller.config.yang.netty.EventExecutorServiceInterface.class)
    public void setEventExecutor(javax.management.ObjectName eventExecutor) {
        this.eventExecutor = eventExecutor;
    }

    @Override
    public javax.management.ObjectName getProcessingExecutor() {
        return processingExecutor;
    }

    @Override
    @org.opendaylight.controller.config.api.annotations.RequireInterface(value = org.opendaylight.controller.config.yang.threadpool.ThreadPoolServiceInterface.class)
    public void setProcessingExecutor(javax.management.ObjectName processingExecutor) {
        this.processingExecutor = processingExecutor;
    }

    @Override
    public javax.management.ObjectName getBindingRegistry() {
        return bindingRegistry;
    }

    @Override
    @org.opendaylight.controller.config.api.annotations.RequireInterface(value = org.opendaylight.controller.config.yang.md.sal.binding.BindingAwareBrokerServiceInterface.class)
    public void setBindingRegistry(javax.management.ObjectName bindingRegistry) {
        this.bindingRegistry = bindingRegistry;
    }

    @Override
    public javax.management.ObjectName getClientDispatcher() {
        return clientDispatcher;
    }

    @Override
    @org.opendaylight.controller.config.api.annotations.RequireInterface(value = org.opendaylight.controller.config.yang.config.netconf.NetconfClientDispatcherServiceInterface.class)
    public void setClientDispatcher(javax.management.ObjectName clientDispatcher) {
        this.clientDispatcher = clientDispatcher;
    }

    @Override
    public javax.management.ObjectName getDomRegistry() {
        return domRegistry;
    }

    @Override
    @org.opendaylight.controller.config.api.annotations.RequireInterface(value = org.opendaylight.controller.config.yang.md.sal.dom.BrokerServiceInterface.class)
    public void setDomRegistry(javax.management.ObjectName domRegistry) {
        this.domRegistry = domRegistry;
    }

    @Override
    public javax.management.ObjectName getKeepaliveExecutor() {
        return keepaliveExecutor;
    }

    @Override
    @org.opendaylight.controller.config.api.annotations.RequireInterface(value = org.opendaylight.controller.config.yang.threadpool.ScheduledThreadPoolServiceInterface.class)
    public void setKeepaliveExecutor(javax.management.ObjectName keepaliveExecutor) {
        this.keepaliveExecutor = keepaliveExecutor;
    }

    public org.slf4j.Logger getLogger() {
        return LOGGER;
    }

}
