package org.opendaylight.yang.gen.v1.http.bootcamp.com.ns.yang.bootcamp.ug.types.rev151211;


/**
 * The enumeration built-in type represents values from a set of assigned names.
 *
 */
public enum UpgradeStatus {
    /**
     * Switch upgrading not started.
     *
     */
    INITIAL(0),
    
    /**
     * Config the switch and config-point for switch upgrading.
     *
     */
    CONFIG(1),
    
    /**
     * Check the switch and config-point status before we upgrade the switch.
     *
     */
    PRECHECK(2),
    
    /**
     * Copy the specified software package from config-point to switch.
     *
     */
    COPYIMAGE(3),
    
    /**
     * Isolate the flows before we upgrade the switch based on the isolate policy.
     *
     */
    ISOLATEFLOW(4),
    
    /**
     * Tell the switch to upgrade to the new version, may need to restart the process 
     * or the switch.
     *
     */
    UPGRADE(5),
    
    /**
     * Check the switch status after switch upgraded.
     *
     */
    POSTCHECK(6),
    
    /**
     * The switch upgrades successfully.
     *
     */
    SUCCESS(7),
    
    /**
     * Failed to upgrade the switch.
     *
     */
    FAIL(8)
    ;


    int value;
    private static final java.util.Map<java.lang.Integer, UpgradeStatus> VALUE_MAP;

    static {
        final com.google.common.collect.ImmutableMap.Builder<java.lang.Integer, UpgradeStatus> b = com.google.common.collect.ImmutableMap.builder();
        for (UpgradeStatus enumItem : UpgradeStatus.values())
        {
            b.put(enumItem.value, enumItem);
        }

        VALUE_MAP = b.build();
    }

    private UpgradeStatus(int value) {
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
     * @return corresponding UpgradeStatus item
     */
    public static UpgradeStatus forValue(int valueArg) {
        return VALUE_MAP.get(valueArg);
    }
}
