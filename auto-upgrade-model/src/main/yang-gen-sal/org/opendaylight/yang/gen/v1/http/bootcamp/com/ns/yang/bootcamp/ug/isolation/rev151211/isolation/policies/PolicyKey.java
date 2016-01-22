package org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies;
import org.opendaylight.yangtools.yang.binding.Identifier;


public class PolicyKey
 implements Identifier<Policy> {
    private static final long serialVersionUID = 6313462767480311868L;
    private final java.lang.Class<? extends org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.PolicyType> _type;


    public PolicyKey(java.lang.Class<? extends org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.PolicyType> _type) {
    
    
        this._type = _type;
    }
    
    /**
     * Creates a copy from Source Object.
     *
     * @param source Source object
     */
    public PolicyKey(PolicyKey source) {
        this._type = source._type;
    }


    public java.lang.Class<? extends org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.PolicyType> getType() {
        return _type;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_type == null) ? 0 : _type.hashCode());
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
        PolicyKey other = (PolicyKey) obj;
        if (_type == null) {
            if (other._type != null) {
                return false;
            }
        } else if(!_type.equals(other._type)) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        java.lang.StringBuilder builder = new java.lang.StringBuilder(org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.isolation.rev151211.isolation.policies.PolicyKey.class.getSimpleName()).append(" [");
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
        return builder.append(']').toString();
    }



}

