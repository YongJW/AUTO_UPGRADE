package org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.InterfaceState;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.ArrayList;
import com.google.common.collect.Range;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.InterfaceType;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.math.BigInteger;
import java.util.List;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces} instances.
 * 
 * @see org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces
 *
 */
public class InterfacesBuilder implements Builder <org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces> {

    private InterfaceState _curState;
    private InterfacesKey _key;
    private java.lang.String _name;
    private static void check_nameLength(final String value) {
        final int length = value.length();
        if (length >= 3 && length <= 64) {
            return;
        }
        throw new IllegalArgumentException(String.format("Invalid length: %s, expected: [[3¨E64]].", value));
    }
    private InterfaceState _prevState;
    private InterfaceType _type;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces>>, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces>> augmentation = Collections.emptyMap();

    public InterfacesBuilder() {
    }
    public InterfacesBuilder(org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.Interface arg) {
        this._type = arg.getType();
        this._name = arg.getName();
    }

    public InterfacesBuilder(Interfaces base) {
        if (base.getKey() == null) {
            this._key = new InterfacesKey(
                base.getName(), 
                base.getType()
            );
            this._name = base.getName();
            this._type = base.getType();
        } else {
            this._key = base.getKey();
            this._name = _key.getName();
            this._type = _key.getType();
        }
        this._curState = base.getCurState();
        this._prevState = base.getPrevState();
        if (base instanceof InterfacesImpl) {
            InterfacesImpl impl = (InterfacesImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.Interface</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.Interface) {
            this._type = ((org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.Interface)arg).getType();
            this._name = ((org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.Interface)arg).getName();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.Interface] \n" +
              "but was: " + arg
            );
        }
    }

    public InterfaceState getCurState() {
        return _curState;
    }
    
    public InterfacesKey getKey() {
        return _key;
    }
    
    public java.lang.String getName() {
        return _name;
    }
    
    public InterfaceState getPrevState() {
        return _prevState;
    }
    
    public InterfaceType getType() {
        return _type;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public InterfacesBuilder setCurState(InterfaceState value) {
        this._curState = value;
        return this;
    }
    
    public InterfacesBuilder setKey(InterfacesKey value) {
        this._key = value;
        return this;
    }
    
    public InterfacesBuilder setName(java.lang.String value) {
        if (value != null) {
            check_nameLength(value);
        }
        this._name = value;
        return this;
    }
    /**
     * @deprecated This method is slated for removal in a future release. See BUG-1485 for details.
     */
    @Deprecated
    public static List<Range<BigInteger>> _name_length() {
        List<Range<BigInteger>> ret = new ArrayList<>(1);
        ret.add(Range.closed(BigInteger.valueOf(3L), BigInteger.valueOf(64L)));
        return ret;
    }
    
    public InterfacesBuilder setPrevState(InterfaceState value) {
        this._prevState = value;
        return this;
    }
    
    public InterfacesBuilder setType(InterfaceType value) {
        this._type = value;
        return this;
    }
    
    public InterfacesBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public InterfacesBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public Interfaces build() {
        return new InterfacesImpl(this);
    }

    private static final class InterfacesImpl implements Interfaces {

        public java.lang.Class<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces.class;
        }

        private final InterfaceState _curState;
        private final InterfacesKey _key;
        private final java.lang.String _name;
        private final InterfaceState _prevState;
        private final InterfaceType _type;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces>>, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces>> augmentation = Collections.emptyMap();

        private InterfacesImpl(InterfacesBuilder base) {
            if (base.getKey() == null) {
                this._key = new InterfacesKey(
                    base.getName(), 
                    base.getType()
                );
                this._name = base.getName();
                this._type = base.getType();
            } else {
                this._key = base.getKey();
                this._name = _key.getName();
                this._type = _key.getType();
            }
            this._curState = base.getCurState();
            this._prevState = base.getPrevState();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces>>, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces>>, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public InterfaceState getCurState() {
            return _curState;
        }
        
        @Override
        public InterfacesKey getKey() {
            return _key;
        }
        
        @Override
        public java.lang.String getName() {
            return _name;
        }
        
        @Override
        public InterfaceState getPrevState() {
            return _prevState;
        }
        
        @Override
        public InterfaceType getType() {
            return _type;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + ((_curState == null) ? 0 : _curState.hashCode());
            result = prime * result + ((_key == null) ? 0 : _key.hashCode());
            result = prime * result + ((_name == null) ? 0 : _name.hashCode());
            result = prime * result + ((_prevState == null) ? 0 : _prevState.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces other = (org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces)obj;
            if (_curState == null) {
                if (other.getCurState() != null) {
                    return false;
                }
            } else if(!_curState.equals(other.getCurState())) {
                return false;
            }
            if (_key == null) {
                if (other.getKey() != null) {
                    return false;
                }
            } else if(!_key.equals(other.getKey())) {
                return false;
            }
            if (_name == null) {
                if (other.getName() != null) {
                    return false;
                }
            } else if(!_name.equals(other.getName())) {
                return false;
            }
            if (_prevState == null) {
                if (other.getPrevState() != null) {
                    return false;
                }
            } else if(!_prevState.equals(other.getPrevState())) {
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
                InterfacesImpl otherImpl = (InterfacesImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces>>, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.Interfaces>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("Interfaces [");
            boolean first = true;
        
            if (_curState != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_curState=");
                builder.append(_curState);
             }
            if (_key != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_key=");
                builder.append(_key);
             }
            if (_name != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_name=");
                builder.append(_name);
             }
            if (_prevState != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_prevState=");
                builder.append(_prevState);
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
