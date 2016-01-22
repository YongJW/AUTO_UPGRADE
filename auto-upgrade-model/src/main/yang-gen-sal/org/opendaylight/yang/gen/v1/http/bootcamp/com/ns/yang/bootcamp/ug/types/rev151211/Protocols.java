package org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211;


/**
 * The enumeration built-in type represents values from a set of assigned names.
 *
 */
public enum Protocols {
    SSH(0),
    
    TLS(1),
    
    SCP(2),
    
    BGP(3),
    
    OSPF(4),
    
    ISIS(5),
    
    MLAG(6),
    
    LACP(7)
    ;


    int value;
    private static final java.util.Map<java.lang.Integer, Protocols> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, Protocols> b = com.google.common.collect.ImmutableMap.builder();
        for (Protocols enumItem : Protocols.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private Protocols(int value) {
        this.value = value;
    }

    /**
     * @return integer value
     */
    public int getIntValue() {
        return value;
    }

    /**
     * @param valueArg
     * @return corresponding Protocols item
     */
    public static Protocols forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
