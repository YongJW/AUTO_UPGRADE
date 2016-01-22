package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.upgrade.Broker;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.upgrade.NcClient;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade} instances.
 * 
 * @see org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade
 *
 */
public class UpgradeBuilder implements Builder <org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade> {

    private Broker _broker;
    private NcClient _ncClient;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade>> augmentation = Collections.emptyMap();

    public UpgradeBuilder() {
    }

    public UpgradeBuilder(Upgrade base) {
        this._broker = base.getBroker();
        this._ncClient = base.getNcClient();
        if (base instanceof UpgradeImpl) {
            UpgradeImpl impl = (UpgradeImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public Broker getBroker() {
        return _broker;
    }
    
    public NcClient getNcClient() {
        return _ncClient;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public UpgradeBuilder setBroker(Broker value) {
        this._broker = value;
        return this;
    }
    
    public UpgradeBuilder setNcClient(NcClient value) {
        this._ncClient = value;
        return this;
    }
    
    public UpgradeBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public UpgradeBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public Upgrade build() {
        return new UpgradeImpl(this);
    }

    private static final class UpgradeImpl implements Upgrade {

        public java.lang.Class<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade.class;
        }

        private final Broker _broker;
        private final NcClient _ncClient;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade>> augmentation = Collections.emptyMap();

        private UpgradeImpl(UpgradeBuilder base) {
            this._broker = base.getBroker();
            this._ncClient = base.getNcClient();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public Broker getBroker() {
            return _broker;
        }
        
        @Override
        public NcClient getNcClient() {
            return _ncClient;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + ((_broker == null) ? 0 : _broker.hashCode());
            result = prime * result + ((_ncClient == null) ? 0 : _ncClient.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade other = (org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade)obj;
            if (_broker == null) {
                if (other.getBroker() != null) {
                    return false;
                }
            } else if(!_broker.equals(other.getBroker())) {
                return false;
            }
            if (_ncClient == null) {
                if (other.getNcClient() != null) {
                    return false;
                }
            } else if(!_ncClient.equals(other.getNcClient())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                UpgradeImpl otherImpl = (UpgradeImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade>>, Augmentation<org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.upgrade.impl.rev151221.modules.module.configuration.Upgrade>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("Upgrade [");
            boolean first = true;
        
            if (_broker != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_broker=");
                builder.append(_broker);
             }
            if (_ncClient != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ncClient=");
                builder.append(_ncClient);
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
