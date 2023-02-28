package com.kuang.utils;

public class Secret {
    public static String makeSecret(String password) {
        return "secret" + password;
    }

    public static String parseSecret(String secretPassword) {
        return secretPassword.replace("secret", "");
    }

    public static boolean checkSecret(String password, String secretPassword) {
        return password.equals(parseSecret(secretPassword));
    }
}
