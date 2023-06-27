package collection;

import org.jetbrains.annotations.Nullable;

/**
 * The enum Weapon type.
 */
public enum WeaponType {
    /**
     * Hammer weapon type.
     */
    HAMMER("HAMMER", "1", 10),
    /**
     * Pistol weapon type.
     */
    PISTOL("PISTOL", "2", 45),
    /**
     * Shotgun weapon type.
     */
    SHOTGUN("SHOTGUN", "3", 80);

    private final String name, order;

    private final int power;

    WeaponType(String name, String order, int power) {
        this.name = name;
        this.order = order;
        this.power = power;
    }


    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return (name == null ? "null" : name);
    }

    /**
     * Gets order.
     *
     * @return the order
     */
    public String getOrder() {
        return order;
    }

    /**
     * Gets power.
     *
     * @return the power
     */
    public int getPower() {
        return power;
    }

    /**
     * Gets weapon type.
     *
     * @param s the s
     * @return the weapon type
     */
    public static @Nullable WeaponType getWeaponType(String s) {
        WeaponType[] weaponTypesValues = WeaponType.values();
        for (WeaponType weaponType : weaponTypesValues) {
            if (s.equals(weaponType.getName().toLowerCase()) || s.equals(weaponType.getOrder())) {
                return weaponType;
            }
        }
        return null;
    }

    /**
     * Gets string values.
     *
     * @return the string values
     */
    public static String getStringValues() {
        StringBuilder sb = new StringBuilder();
        for (WeaponType weaponType : WeaponType.values()) {
            sb.append(weaponType.getOrder()).append(" - ").append(weaponType.getName()).append(" | ");
        }
        sb.delete(sb.length() - 3, sb.length()); // удаление последнего разделителя "| "
        return sb.toString();
    }

    @Override
    public String toString(){
        return getName();
    }

}