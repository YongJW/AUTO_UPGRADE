package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.netconfclient.ProcessingExecutor;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.netconfclient.DomRegistry;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.netconfclient.EventExecutor;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.netconfclient.KeepaliveExecutor;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.netconfclient.BindingRegistry;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.netconfclient.ClientDispatcher;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient} instances.
 * 
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient
 *
 */
public class NetconfclientBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient> {

    private BindingRegistry _bindingRegistry;
    private ClientDispatcher _clientDispatcher;
    private DomRegistry _domRegistry;
    private EventExecutor _eventExecutor;
    private KeepaliveExecutor _keepaliveExecutor;
    private ProcessingExecutor _processingExecutor;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient>> augmentation = Collections.emptyMap();

    public NetconfclientBuilder() {
    }

    public NetconfclientBuilder(Netconfclient base) {
        this._bindingRegistry = base.getBindingRegistry();
        this._clientDispatcher = base.getClientDispatcher();
        this._domRegistry = base.getDomRegistry();
        this._eventExecutor = base.getEventExecutor();
        this._keepaliveExecutor = base.getKeepaliveExecutor();
        this._processingExecutor = base.getProcessingExecutor();
        if (base instanceof NetconfclientImpl) {
            NetconfclientImpl impl = (NetconfclientImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public BindingRegistry getBindingRegistry() {
        return _bindingRegistry;
    }
    
    public ClientDispatcher getClientDispatcher() {
        return _clientDispatcher;
    }
    
    public DomRegistry getDomRegistry() {
        return _domRegistry;
    }
    
    public EventExecutor getEventExecutor() {
        return _eventExecutor;
    }
    
    public KeepaliveExecutor getKeepaliveExecutor() {
        return _keepaliveExecutor;
    }
    
    public ProcessingExecutor getProcessingExecutor() {
        return _processingExecutor;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public NetconfclientBuilder setBindingRegistry(BindingRegistry value) {
        this._bindingRegistry = value;
        return this;
    }
    
    public NetconfclientBuilder setClientDispatcher(ClientDispatcher value) {
        this._clientDispatcher = value;
        return this;
    }
    
    public NetconfclientBuilder setDomRegistry(DomRegistry value) {
        this._domRegistry = value;
        return this;
    }
    
    public NetconfclientBuilder setEventExecutor(EventExecutor value) {
        this._eventExecutor = value;
        return this;
    }
    
    public NetconfclientBuilder setKeepaliveExecutor(KeepaliveExecutor value) {
        this._keepaliveExecutor = value;
        return this;
    }
    
    public NetconfclientBuilder setProcessingExecutor(ProcessingExecutor value) {
        this._processingExecutor = value;
        return this;
    }
    
    public NetconfclientBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public NetconfclientBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public Netconfclient build() {
        return new NetconfclientImpl(this);
    }

    private static final class NetconfclientImpl implements Netconfclient {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient.class;
        }

        private final BindingRegistry _bindingRegistry;
        private final ClientDispatcher _clientDispatcher;
        private final DomRegistry _domRegistry;
        private final EventExecutor _eventExecutor;
        private final KeepaliveExecutor _keepaliveExecutor;
        private final ProcessingExecutor _processingExecutor;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient>> augmentation = Collections.emptyMap();

        private NetconfclientImpl(NetconfclientBuilder base) {
            this._bindingRegistry = base.getBindingRegistry();
            this._clientDispatcher = base.getClientDispatcher();
            this._domRegistry = base.getDomRegistry();
            this._eventExecutor = base.getEventExecutor();
            this._keepaliveExecutor = base.getKeepaliveExecutor();
            this._processingExecutor = base.getProcessingExecutor();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public BindingRegistry getBindingRegistry() {
            return _bindingRegistry;
        }
        
        @Override
        public ClientDispatcher getClientDispatcher() {
            return _clientDispatcher;
        }
        
        @Override
        public DomRegistry getDomRegistry() {
            return _domRegistry;
        }
        
        @Override
        public EventExecutor getEventExecutor() {
            return _eventExecutor;
        }
        
        @Override
        public KeepaliveExecutor getKeepaliveExecutor() {
            return _keepaliveExecutor;
        }
        
        @Override
        public ProcessingExecutor getProcessingExecutor() {
            return _processingExecutor;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient>> E getAugmentation(java.lang.Class<E> augmentationType) {
            if (augmentationType == null) {
                throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
            }
            return (E) augmentation.get(augmentationType);
        }

        private int hash = 0;
        private volatile boolean hashValid = false;
        
        @Override
        public int hashCode() {
            if (hashValid) {
                return hash;
            }
        
            final int prime = 31;
            int result = 1;
            result = prime * result + ((_bindingRegistry == null) ? 0 : _bindingRegistry.hashCode());
            result = prime * result + ((_clientDispatcher == null) ? 0 : _clientDispatcher.hashCode());
            result = prime * result + ((_domRegistry == null) ? 0 : _domRegistry.hashCode());
            result = prime * result + ((_eventExecutor == null) ? 0 : _eventExecutor.hashCode());
            result = prime * result + ((_keepaliveExecutor == null) ? 0 : _keepaliveExecutor.hashCode());
            result = prime * result + ((_processingExecutor == null) ? 0 : _processingExecutor.hashCode());
            result = prime * result + ((augmentation == null) ? 0 : augmentation.hashCode());
        
            hash = result;
            hashValid = true;
            return result;
        }

        @Override
        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DataObject)) {
                return false;
            }
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient)obj;
            if (_bindingRegistry == null) {
                if (other.getBindingRegistry() != null) {
                    return false;
                }
            } else if(!_bindingRegistry.equals(other.getBindingRegistry())) {
                return false;
            }
            if (_clientDispatcher == null) {
                if (other.getClientDispatcher() != null) {
                    return false;
                }
            } else if(!_clientDispatcher.equals(other.getClientDispatcher())) {
                return false;
            }
            if (_domRegistry == null) {
                if (other.getDomRegistry() != null) {
                    return false;
                }
            } else if(!_domRegistry.equals(other.getDomRegistry())) {
                return false;
            }
            if (_eventExecutor == null) {
                if (other.getEventExecutor() != null) {
                    return false;
                }
            } else if(!_eventExecutor.equals(other.getEventExecutor())) {
                return false;
            }
            if (_keepaliveExecutor == null) {
                if (other.getKeepaliveExecutor() != null) {
                    return false;
                }
            } else if(!_keepaliveExecutor.equals(other.getKeepaliveExecutor())) {
                return false;
            }
            if (_processingExecutor == null) {
                if (other.getProcessingExecutor() != null) {
                    return false;
                }
            } else if(!_processingExecutor.equals(other.getProcessingExecutor())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                NetconfclientImpl otherImpl = (NetconfclientImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.netconfclient.impl.rev141210.modules.module.configuration.Netconfclient>> e : augmentation.entrySet()) {
                    if (!e.getValue().equals(other.getAugmentation(e.getKey()))) {
                        return false;
                    }
                }
                // .. and give the other one the chance to do the same
                if (!obj.equals(this)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public java.lang.String toString() {
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("Netconfclient [");
            boolean first = true;
        
            if (_bindingRegistry != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_bindingRegistry=");
                builder.append(_bindingRegistry);
             }
            if (_clientDispatcher != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_clientDispatcher=");
                builder.append(_clientDispatcher);
             }
            if (_domRegistry != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_domRegistry=");
                builder.append(_domRegistry);
             }
            if (_eventExecutor != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_eventExecutor=");
                builder.append(_eventExecutor);
             }
            if (_keepaliveExecutor != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_keepaliveExecutor=");
                builder.append(_keepaliveExecutor);
             }
            if (_processingExecutor != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_processingExecutor=");
                builder.append(_processingExecutor);
             }
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("augmentation=");
            builder.append(augmentation.values());
            return builder.append(']').toString();
        }
    }

}
