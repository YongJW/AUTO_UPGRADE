package org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status;
import org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211.InterfaceType;
import org.opendaylight.yangtools.yang.binding.Identifier;


public class InterfacesKey
 implements Identifier<Interfaces> {
    private static final long serialVersionUID = 1621052466972009931L;
    private final InterfaceType _type;
    private final java.lang.String _name;


    public InterfacesKey(java.lang.String _name, InterfaceType _type) {
    
    
        this._type = _type;
        this._name = _name;
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public InterfacesKey(InterfacesKey source) {
        this._type = source._type;
        this._name = source._name;
    }


    public InterfaceType getType() {
        return _type;
    }
    
    public java.lang.String getName() {
        return _name;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_type == null) ? 0 : _type.hashCode());
        result = prime * result + ((_name == null) ? 0 : _name.hashCode());
        return result;
    }

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        InterfacesKey other = (InterfacesKey) obj;
        if (_type == null) {
            if (other._type != null) {
                return false;
            }
        } else if(!_type.equals(other._type)) {
            return false;
        }
        if (_name == null) {
            if (other._name != null) {
                return false;
            }
        } else if(!_name.equals(other._name)) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder builder = new java.lang.StringBuilder(org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211._interface.status.InterfacesKey.class.getSimpleName()).append(" [");
        boolean first = true;
    
        if (_type != null) {
            if (first) {
                first = false;
            } else {
                builder.append(", ");
            }
            builder.append("_type=");
            builder.append(_type);
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
        return builder.append(']').toString();
    }



}

