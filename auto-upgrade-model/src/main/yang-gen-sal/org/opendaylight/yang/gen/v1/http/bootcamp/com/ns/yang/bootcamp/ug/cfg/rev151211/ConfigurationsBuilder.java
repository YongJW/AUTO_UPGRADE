package org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yangtools.yang.binding.DataObject;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.List;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations} instances.
 * 
 * @see org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations
 *
 */
public class ConfigurationsBuilder implements Builder <org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations> {

    private List<Configuration> _configuration;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations>>, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations>> augmentation = Collections.emptyMap();

    public ConfigurationsBuilder() {
    }

    public ConfigurationsBuilder(Configurations base) {
        this._configuration = base.getConfiguration();
        if (base instanceof ConfigurationsImpl) {
            ConfigurationsImpl impl = (ConfigurationsImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }


    public List<Configuration> getConfiguration() {
        return _configuration;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public ConfigurationsBuilder setConfiguration(List<Configuration> value) {
        this._configuration = value;
        return this;
    }
    
    public ConfigurationsBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public ConfigurationsBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public Configurations build() {
        return new ConfigurationsImpl(this);
    }

    private static final class ConfigurationsImpl implements Configurations {

        public java.lang.Class<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations.class;
        }

        private final List<Configuration> _configuration;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations>>, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations>> augmentation = Collections.emptyMap();

        private ConfigurationsImpl(ConfigurationsBuilder base) {
            this._configuration = base.getConfiguration();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations>>, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations>>, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public List<Configuration> getConfiguration() {
            return _configuration;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + ((_configuration == null) ? 0 : _configuration.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations other = (org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations)obj;
            if (_configuration == null) {
                if (other.getConfiguration() != null) {
                    return false;
                }
            } else if(!_configuration.equals(other.getConfiguration())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                ConfigurationsImpl otherImpl = (ConfigurationsImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations>>, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.Configurations>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("Configurations [");
            boolean first = true;
        
            if (_configuration != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_configuration=");
                builder.append(_configuration);
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
