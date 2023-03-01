package com.kuang.util;

public class Token {
    public static String makeToken(String username) {
        return "token-token-token-"+username;
    }
    public static String parseToken(String token) {
        return token.replace("token-token-token-","");
    }

}
