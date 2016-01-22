package org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211;


/**
 * The enumeration built-in type represents values from a set of assigned names.
 *
 */
public enum InterfaceType {
    PHY(0),
    
    LACP(1),
    
    LAG(2),
    
    VLAN(3)
    ;


    int value;
    private static final java.util.Map<java.lang.Integer, InterfaceType> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, InterfaceType> b = com.google.common.collect.ImmutableMap.builder();
        for (InterfaceType enumItem : InterfaceType.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private InterfaceType(int value) {
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
     * @return corresponding InterfaceType item
     */
    public static InterfaceType forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
