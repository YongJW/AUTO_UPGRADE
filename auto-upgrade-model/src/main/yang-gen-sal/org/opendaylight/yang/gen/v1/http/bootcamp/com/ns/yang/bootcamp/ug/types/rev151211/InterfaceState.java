package org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211;


/**
 * The enumeration built-in type represents values from a set of assigned names.
 *
 */
public enum InterfaceState {
    UP(0),
    
    DOWN(1)
    ;


    int value;
    private static final java.util.Map<java.lang.Integer, InterfaceState> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, InterfaceState> b = com.google.common.collect.ImmutableMap.builder();
        for (InterfaceState enumItem : InterfaceState.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private InterfaceState(int value) {
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
     * @return corresponding InterfaceState item
     */
    public static InterfaceState forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
