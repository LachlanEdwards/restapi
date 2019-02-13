package com.metlease.Enumerators;
import java.util.HashMap;

public enum UserGender {
    MALE(0),
    FEMALE(1),
    NONBINARY(2);

    private int gender;
    private static HashMap<Integer, UserGender> map = new HashMap<Integer, UserGender>();

    static {
        for (UserGender userGender : UserGender.values()) {
            map.put(userGender.gender, userGender);
        }
    }

    UserGender(int gender) {
        this.gender = gender;
    }

    public int toInt() {
        return this.gender;
    }

    public static UserGender valueOf(int gender) {
        return map.get(gender);
    }
}