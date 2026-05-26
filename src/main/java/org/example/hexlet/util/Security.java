package org.example.hexlet.util;

public class Security {
    public static String encrypt(String password) {
        // Для учебных целей просто добавляем префикс
        return "encrypted_" + password;
    }
}
