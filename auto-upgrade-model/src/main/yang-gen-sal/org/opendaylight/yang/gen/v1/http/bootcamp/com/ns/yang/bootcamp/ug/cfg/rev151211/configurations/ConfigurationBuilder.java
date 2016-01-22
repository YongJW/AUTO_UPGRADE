package org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations;
import org.opendaylight.yangtools.yang.binding.AugmentationHolder;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.Protocols;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.IpVersion;
import java.util.HashMap;
import org.opendaylight.yangtools.concepts.Builder;
import java.util.ArrayList;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Host;
import com.google.common.collect.Range;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.Uri;
import org.opendaylight.yangtools.yang.binding.Augmentation;
import org.opendaylight.yangtools.yang.binding.DataObject;
import java.math.BigInteger;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.configuration.ElemType;
import java.util.List;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev100924.PortNumber;
import java.util.Collections;
import java.util.Map;


/**
 * Class that builds {@link org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration} instances.
 * 
 * @see org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration
 *
 */
public class ConfigurationBuilder implements Builder <org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration> {

    private ElemType _elemType;
    private java.lang.String _file;
    private static void check_fileLength(final String value) {
        final int length = value.length();
        if (length >= 0 && length <= 128) {
            return;
        }
        throw new IllegalArgumentException(String.format("Invalid length: %s, expected: [[0¨E128]].", value));
    }
    private Host _host;
    private IpVersion _ipVersion;
    private ConfigurationKey _key;
    private java.lang.String _name;
    private static void check_nameLength(final String value) {
        final int length = value.length();
        if (length >= 3 && length <= 128) {
            return;
        }
        throw new IllegalArgumentException(String.format("Invalid length: %s, expected: [[3¨E128]].", value));
    }
    private java.lang.String _password;
    private static void check_passwordLength(final String value) {
        final int length = value.length();
        if (length >= 3 && length <= 128) {
            return;
        }
        throw new IllegalArgumentException(String.format("Invalid length: %s, expected: [[3¨E128]].", value));
    }
    private PortNumber _port;
    private Protocols _protocol;
    private Uri _repository;
    private java.lang.Class<? extends org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.CfgType> _type;
    private java.lang.String _username;

    Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration>>, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration>> augmentation = Collections.emptyMap();

    public ConfigurationBuilder() {
    }
    public ConfigurationBuilder(org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.ConnectionCfg arg) {
        this._protocol = arg.getProtocol();
        this._ipVersion = arg.getIpVersion();
        this._host = arg.getHost();
        this._port = arg.getPort();
        this._username = arg.getUsername();
        this._password = arg.getPassword();
    }
    public ConfigurationBuilder(org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.SwitchImage arg) {
        this._repository = arg.getRepository();
        this._file = arg.getFile();
    }

    public ConfigurationBuilder(Configuration base) {
        if (base.getKey() == null) {
            this._key = new ConfigurationKey(
                base.getName()
            );
            this._name = base.getName();
        } else {
            this._key = base.getKey();
            this._name = _key.getName();
        }
        this._elemType = base.getElemType();
        this._file = base.getFile();
        this._host = base.getHost();
        this._ipVersion = base.getIpVersion();
        this._password = base.getPassword();
        this._port = base.getPort();
        this._protocol = base.getProtocol();
        this._repository = base.getRepository();
        this._type = base.getType();
        this._username = base.getUsername();
        if (base instanceof ConfigurationImpl) {
            ConfigurationImpl impl = (ConfigurationImpl) base;
            if (!impl.augmentation.isEmpty()) {
                this.augmentation = new HashMap<>(impl.augmentation);
            }
        } else if (base instanceof AugmentationHolder) {
            @SuppressWarnings("unchecked")
            AugmentationHolder<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration> casted =(AugmentationHolder<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration>) base;
            if (!casted.augmentations().isEmpty()) {
                this.augmentation = new HashMap<>(casted.augmentations());
            }
        }
    }

    /**
     *Set fields from given grouping argument. Valid argument is instance of one of following types:
     * <ul>
     * <li>org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.SwitchImage</li>
     * <li>org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.ConnectionCfg</li>
     * </ul>
     *
     * @param arg grouping object
     * @throws IllegalArgumentException if given argument is none of valid types
    */
    public void fieldsFrom(DataObject arg) {
        boolean isValidArg = false;
        if (arg instanceof org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.SwitchImage) {
            this._repository = ((org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.SwitchImage)arg).getRepository();
            this._file = ((org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.SwitchImage)arg).getFile();
            isValidArg = true;
        }
        if (arg instanceof org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.ConnectionCfg) {
            this._protocol = ((org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.ConnectionCfg)arg).getProtocol();
            this._ipVersion = ((org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.ConnectionCfg)arg).getIpVersion();
            this._host = ((org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.ConnectionCfg)arg).getHost();
            this._port = ((org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.ConnectionCfg)arg).getPort();
            this._username = ((org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.ConnectionCfg)arg).getUsername();
            this._password = ((org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.ConnectionCfg)arg).getPassword();
            isValidArg = true;
        }
        if (!isValidArg) {
            throw new IllegalArgumentException(
              "expected one of: [org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.SwitchImage, org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.ConnectionCfg] \n" +
              "but was: " + arg
            );
        }
    }

    public ElemType getElemType() {
        return _elemType;
    }
    
    public java.lang.String getFile() {
        return _file;
    }
    
    public Host getHost() {
        return _host;
    }
    
    public IpVersion getIpVersion() {
        return _ipVersion;
    }
    
    public ConfigurationKey getKey() {
        return _key;
    }
    
    public java.lang.String getName() {
        return _name;
    }
    
    public java.lang.String getPassword() {
        return _password;
    }
    
    public PortNumber getPort() {
        return _port;
    }
    
    public Protocols getProtocol() {
        return _protocol;
    }
    
    public Uri getRepository() {
        return _repository;
    }
    
    public java.lang.Class<? extends org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.CfgType> getType() {
        return _type;
    }
    
    public java.lang.String getUsername() {
        return _username;
    }
    
    @SuppressWarnings("unchecked")
    public <E extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration>> E getAugmentation(java.lang.Class<E> augmentationType) {
        if (augmentationType == null) {
            throw new IllegalArgumentException("Augmentation Type reference cannot be NULL!");
        }
        return (E) augmentation.get(augmentationType);
    }

    public ConfigurationBuilder setElemType(ElemType value) {
        this._elemType = value;
        return this;
    }
    
    public ConfigurationBuilder setFile(java.lang.String value) {
        if (value != null) {
            check_fileLength(value);
        }
        this._file = value;
        return this;
    }
    /**
     * @deprecated This method is slated for removal in a future release. See BUG-1485 for details.
     */
    @Deprecated
    public static List<Range<BigInteger>> _file_length() {
        List<Range<BigInteger>> ret = new ArrayList<>(1);
        ret.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(128L)));
        return ret;
    }
    
    public ConfigurationBuilder setHost(Host value) {
        if (value != null) {
        }
        this._host = value;
        return this;
    }
    
    public ConfigurationBuilder setIpVersion(IpVersion value) {
        this._ipVersion = value;
        return this;
    }
    
    public ConfigurationBuilder setKey(ConfigurationKey value) {
        this._key = value;
        return this;
    }
    
    public ConfigurationBuilder setName(java.lang.String value) {
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
        ret.add(Range.closed(BigInteger.valueOf(3L), BigInteger.valueOf(128L)));
        return ret;
    }
    
    public ConfigurationBuilder setPassword(java.lang.String value) {
        if (value != null) {
            check_passwordLength(value);
        }
        this._password = value;
        return this;
    }
    /**
     * @deprecated This method is slated for removal in a future release. See BUG-1485 for details.
     */
    @Deprecated
    public static List<Range<BigInteger>> _password_length() {
        List<Range<BigInteger>> ret = new ArrayList<>(1);
        ret.add(Range.closed(BigInteger.valueOf(3L), BigInteger.valueOf(128L)));
        return ret;
    }
    
    private static void checkPortRange(final int value) {
        if (value >= 0 && value <= 65535) {
            return;
        }
        throw new IllegalArgumentException(String.format("Invalid range: %s, expected: [[0¨E65535]].", value));
    }
    
    public ConfigurationBuilder setPort(PortNumber value) {
        if (value != null) {
            checkPortRange(value.getValue());
        }
        this._port = value;
        return this;
    }
    /**
     * @deprecated This method is slated for removal in a future release. See BUG-1485 for details.
     */
    @Deprecated
    public static List<Range<BigInteger>> _port_range() {
        final List<Range<BigInteger>> ret = new java.util.ArrayList<>(1);
        ret.add(Range.closed(BigInteger.ZERO, BigInteger.valueOf(65535L)));
        return ret;
    }
    
    public ConfigurationBuilder setProtocol(Protocols value) {
        this._protocol = value;
        return this;
    }
    
    public ConfigurationBuilder setRepository(Uri value) {
        if (value != null) {
        }
        this._repository = value;
        return this;
    }
    
    public ConfigurationBuilder setType(java.lang.Class<? extends org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.CfgType> value) {
        this._type = value;
        return this;
    }
    
    public ConfigurationBuilder setUsername(java.lang.String value) {
        if (value != null) {
        }
        this._username = value;
        return this;
    }
    
    public ConfigurationBuilder addAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration>> augmentationType, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration> augmentation) {
        if (augmentation == null) {
            return removeAugmentation(augmentationType);
        }
    
        if (!(this.augmentation instanceof HashMap)) {
            this.augmentation = new HashMap<>();
        }
    
        this.augmentation.put(augmentationType, augmentation);
        return this;
    }
    
    public ConfigurationBuilder removeAugmentation(java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration>> augmentationType) {
        if (this.augmentation instanceof HashMap) {
            this.augmentation.remove(augmentationType);
        }
        return this;
    }

    public Configuration build() {
        return new ConfigurationImpl(this);
    }

    private static final class ConfigurationImpl implements Configuration {

        public java.lang.Class<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration> getImplementedInterface() {
            return org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration.class;
        }

        private final ElemType _elemType;
        private final java.lang.String _file;
        private final Host _host;
        private final IpVersion _ipVersion;
        private final ConfigurationKey _key;
        private final java.lang.String _name;
        private final java.lang.String _password;
        private final PortNumber _port;
        private final Protocols _protocol;
        private final Uri _repository;
        private final java.lang.Class<? extends org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.CfgType> _type;
        private final java.lang.String _username;

        private Map<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration>>, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration>> augmentation = Collections.emptyMap();

        private ConfigurationImpl(ConfigurationBuilder base) {
            if (base.getKey() == null) {
                this._key = new ConfigurationKey(
                    base.getName()
                );
                this._name = base.getName();
            } else {
                this._key = base.getKey();
                this._name = _key.getName();
            }
            this._elemType = base.getElemType();
            this._file = base.getFile();
            this._host = base.getHost();
            this._ipVersion = base.getIpVersion();
            this._password = base.getPassword();
            this._port = base.getPort();
            this._protocol = base.getProtocol();
            this._repository = base.getRepository();
            this._type = base.getType();
            this._username = base.getUsername();
            switch (base.augmentation.size()) {
            case 0:
                this.augmentation = Collections.emptyMap();
                break;
            case 1:
                final Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration>>, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration>> e = base.augmentation.entrySet().iterator().next();
                this.augmentation = Collections.<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration>>, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration>>singletonMap(e.getKey(), e.getValue());
                break;
            default :
                this.augmentation = new HashMap<>(base.augmentation);
            }
        }

        @Override
        public ElemType getElemType() {
            return _elemType;
        }
        
        @Override
        public java.lang.String getFile() {
            return _file;
        }
        
        @Override
        public Host getHost() {
            return _host;
        }
        
        @Override
        public IpVersion getIpVersion() {
            return _ipVersion;
        }
        
        @Override
        public ConfigurationKey getKey() {
            return _key;
        }
        
        @Override
        public java.lang.String getName() {
            return _name;
        }
        
        @Override
        public java.lang.String getPassword() {
            return _password;
        }
        
        @Override
        public PortNumber getPort() {
            return _port;
        }
        
        @Override
        public Protocols getProtocol() {
            return _protocol;
        }
        
        @Override
        public Uri getRepository() {
            return _repository;
        }
        
        @Override
        public java.lang.Class<? extends org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.CfgType> getType() {
            return _type;
        }
        
        @Override
        public java.lang.String getUsername() {
            return _username;
        }
        
        @SuppressWarnings("unchecked")
        @Override
        public <E extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration>> E getAugmentation(java.lang.Class<E> augmentationType) {
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
            result = prime * result + ((_elemType == null) ? 0 : _elemType.hashCode());
            result = prime * result + ((_file == null) ? 0 : _file.hashCode());
            result = prime * result + ((_host == null) ? 0 : _host.hashCode());
            result = prime * result + ((_ipVersion == null) ? 0 : _ipVersion.hashCode());
            result = prime * result + ((_key == null) ? 0 : _key.hashCode());
            result = prime * result + ((_name == null) ? 0 : _name.hashCode());
            result = prime * result + ((_password == null) ? 0 : _password.hashCode());
            result = prime * result + ((_port == null) ? 0 : _port.hashCode());
            result = prime * result + ((_protocol == null) ? 0 : _protocol.hashCode());
            result = prime * result + ((_repository == null) ? 0 : _repository.hashCode());
            result = prime * result + ((_type == null) ? 0 : _type.hashCode());
            result = prime * result + ((_username == null) ? 0 : _username.hashCode());
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
            if (!org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration.class.equals(((DataObject)obj).getImplementedInterface())) {
                return false;
            }
            org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration other = (org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration)obj;
            if (_elemType == null) {
                if (other.getElemType() != null) {
                    return false;
                }
            } else if(!_elemType.equals(other.getElemType())) {
                return false;
            }
            if (_file == null) {
                if (other.getFile() != null) {
                    return false;
                }
            } else if(!_file.equals(other.getFile())) {
                return false;
            }
            if (_host == null) {
                if (other.getHost() != null) {
                    return false;
                }
            } else if(!_host.equals(other.getHost())) {
                return false;
            }
            if (_ipVersion == null) {
                if (other.getIpVersion() != null) {
                    return false;
                }
            } else if(!_ipVersion.equals(other.getIpVersion())) {
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
            if (_password == null) {
                if (other.getPassword() != null) {
                    return false;
                }
            } else if(!_password.equals(other.getPassword())) {
                return false;
            }
            if (_port == null) {
                if (other.getPort() != null) {
                    return false;
                }
            } else if(!_port.equals(other.getPort())) {
                return false;
            }
            if (_protocol == null) {
                if (other.getProtocol() != null) {
                    return false;
                }
            } else if(!_protocol.equals(other.getProtocol())) {
                return false;
            }
            if (_repository == null) {
                if (other.getRepository() != null) {
                    return false;
                }
            } else if(!_repository.equals(other.getRepository())) {
                return false;
            }
            if (_type == null) {
                if (other.getType() != null) {
                    return false;
                }
            } else if(!_type.equals(other.getType())) {
                return false;
            }
            if (_username == null) {
                if (other.getUsername() != null) {
                    return false;
                }
            } else if(!_username.equals(other.getUsername())) {
                return false;
            }
            if (getClass() == obj.getClass()) {
                // Simple case: we are comparing against self
                ConfigurationImpl otherImpl = (ConfigurationImpl) obj;
                if (augmentation == null) {
                    if (otherImpl.augmentation != null) {
                        return false;
                    }
                } else if(!augmentation.equals(otherImpl.augmentation)) {
                    return false;
                }
            } else {
                // Hard case: compare our augments with presence there...
                for (Map.Entry<java.lang.Class<? extends Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration>>, Augmentation<org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.cfg.rev151211.configurations.Configuration>> e : augmentation.entrySet()) {
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
            java.lang.StringBuilder builder = new java.lang.StringBuilder ("Configuration [");
            boolean first = true;
        
            if (_elemType != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_elemType=");
                builder.append(_elemType);
             }
            if (_file != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_file=");
                builder.append(_file);
             }
            if (_host != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_host=");
                builder.append(_host);
             }
            if (_ipVersion != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_ipVersion=");
                builder.append(_ipVersion);
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
            if (_password != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_password=");
                builder.append(_password);
             }
            if (_port != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_port=");
                builder.append(_port);
             }
            if (_protocol != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_protocol=");
                builder.append(_protocol);
             }
            if (_repository != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_repository=");
                builder.append(_repository);
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
            if (_username != null) {
                if (first) {
                    first = false;
                } else {
                    builder.append(", ");
                }
                builder.append("_username=");
                builder.append(_username);
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
