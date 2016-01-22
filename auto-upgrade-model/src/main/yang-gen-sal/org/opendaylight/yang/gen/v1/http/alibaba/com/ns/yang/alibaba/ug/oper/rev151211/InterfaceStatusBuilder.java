package org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus} instances.
 * 
 * @see org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus
 *
 */
public class InterfaceStatusBuilder implements Builder <org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus> {

    private java.lang.String _stub;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus>>, Augmentation<org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus>> augmentation = Collections.emptyMap();

    public InterfaceStatusBuilder() {
    }

    public InterfaceStatusBuilder(InterfaceStatus base) {
        this._stub = base.getStub();
        if (base instanceof InterfaceStatusImpl) {
            InterfaceStatusImpl impl = (InterfaceStatusImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public java.lang.String getStub() {
        return _stub;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public InterfaceStatusBuilder setStub(java.lang.String value) {
        this._stub = value;
        return this;
    }
    
    public InterfaceStatusBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public InterfaceStatusBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public InterfaceStatus build() {
        return new InterfaceStatusImpl(this);
    }

    private static final class InterfaceStatusImpl implements InterfaceStatus {

        public java.lang.Class<org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus.class;
        }

        private final java.lang.String _stub;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus>>, Augmentation<org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus>> augmentation = Collections.emptyMap();

        private InterfaceStatusImpl(InterfaceStatusBuilder base) {
            this._stub = base.getStub();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus>>, Augmentation<org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus>>, Augmentation<org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public java.lang.String getStub() {
            return _stub;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + ((_stub == null) ? 0 : _stub.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus other = (org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus)obj;
            if (_stub == null) {
                if (other.getStub() != null) {
                    return false;
                }
            } else if(!_stub.equals(other.getStub())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                InterfaceStatusImpl otherImpl = (InterfaceStatusImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus>>, Augmentation<org.opendaylight.yang.gen.v1.http.alibaba.com.ns.yang.alibaba.ug.oper.rev151211.InterfaceStatus>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("InterfaceStatus [");
            boolean first = true;
        
            if (_stub != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_stub=");
                builder.append(_stub);
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
