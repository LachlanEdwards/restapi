package com.metlease.Enumerators;
import java.util.HashMap;

public enum UserRole {
    STANDARD(0),
    ADMIN(1);

    private int role;
    private static HashMap<Integer, UserRole> map = new HashMap<Integer, UserRole>();

    static {
        for (UserRole userRole : UserRole.values()) {
            map.put(userRole.role, userRole);
        }
    }

    UserRole(int role) {
        this.role = role;
    }

    public int toInt() {
        return this.role;
    }

    public static UserRole valueOf(int role) {
        return map.get(role);
    }
}