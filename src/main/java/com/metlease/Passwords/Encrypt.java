package com.metlease.Passwords;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class Encrypt {
    public static String hash(String candidate) {
        return BCrypt.hashpw(candidate, BCrypt.gensalt());
    }
    public static boolean match(String candidate, String hash) {
        return (BCrypt.checkpw(candidate, hash));
    }
}
