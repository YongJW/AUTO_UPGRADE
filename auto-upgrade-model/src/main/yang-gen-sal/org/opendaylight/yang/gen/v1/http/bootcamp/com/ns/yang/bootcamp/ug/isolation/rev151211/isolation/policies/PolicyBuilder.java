package org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy} instances.
 * 
 * @see org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy
 *
 */
public class PolicyBuilder implements Builder <org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy> {

    private PolicyKey _key;
    private java.lang.Class<? extends org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.PolicyType> _type;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy>>, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy>> augmentation = Collections.emptyMap();

    public PolicyBuilder() {
    }

    public PolicyBuilder(Policy base) {
        if (base.getKey() == null) {
            this._key = new PolicyKey(
                base.getType()
            );
            this._type = base.getType();
        } else {
            this._key = base.getKey();
            this._type = _key.getType();
        }
        if (base instanceof PolicyImpl) {
            PolicyImpl impl = (PolicyImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public PolicyKey getKey() {
        return _key;
    }
    
    public java.lang.Class<? extends org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.PolicyType> getType() {
        return _type;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public PolicyBuilder setKey(PolicyKey value) {
        this._key = value;
        return this;
    }
    
    public PolicyBuilder setType(java.lang.Class<? extends org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.PolicyType> value) {
        this._type = value;
        return this;
    }
    
    public PolicyBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public PolicyBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public Policy build() {
        return new PolicyImpl(this);
    }

    private static final class PolicyImpl implements Policy {

        public java.lang.Class<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy.class;
        }

        private final PolicyKey _key;
        private final java.lang.Class<? extends org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.PolicyType> _type;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy>>, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy>> augmentation = Collections.emptyMap();

        private PolicyImpl(PolicyBuilder base) {
            if (base.getKey() == null) {
                this._key = new PolicyKey(
                    base.getType()
                );
                this._type = base.getType();
            } else {
                this._key = base.getKey();
                this._type = _key.getType();
            }
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy>>, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy>>, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public PolicyKey getKey() {
            return _key;
        }
        
        @Override
        public java.lang.Class<? extends org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.PolicyType> getType() {
            return _type;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + ((_key == null) ? 0 : _key.hashCode());
            result = prime * result + ((_type == null) ? 0 : _type.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy other = (org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy)obj;
            if (_key == null) {
                if (other.getKey() != null) {
                    return false;
                }
            } else if(!_key.equals(other.getKey())) {
                return false;
            }
            if (_type == null) {
                if (other.getType() != null) {
                    return false;
                }
            } else if(!_type.equals(other.getType())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                PolicyImpl otherImpl = (PolicyImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy>>, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.Policy>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("Policy [");
            boolean first = true;
        
            if (_key != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_key=");
                builder.append(_key);
             }
            if (_type != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_type=");
                builder.append(_type);
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
