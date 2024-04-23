package com.github.dschreid.shop.server.model;

/**
 * The enum Role.
 *
 * @author dschreid
 */
public enum Role {
    /**
     * Guest role.
     */
    GUEST(0),
    /**
     * Staff role.
     */
    STAFF(50),
    /**
     * Admin role.
     */
    ADMIN(100),
    /**
     * Owner role.
     */
    OWNER(1000);

    private final int permissionLevel;

    Role(int permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    /**
     * Gets permission level.
     *
     * @return the permission level
     */
    public int getPermissionLevel() {
        return permissionLevel;
    }

    /**
     * Has boolean.
     *
     * @param min the min
     * @return the boolean
     */
    public boolean has(Role min) {
        return getPermissionLevel() >= min.getPermissionLevel();
    }

    /**
     * Is boolean.
     *
     * @param permissionLevel the permission level
     * @return the boolean
     */
    public boolean is(int permissionLevel) {
        return getPermissionLevel() <= permissionLevel;
    }

}
