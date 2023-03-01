package com.kuang.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.lang.NonNull;

import java.util.Date;

public class JwtUtil {
    /**
     * 过期5小时
     */
    private static final long EXPIRE_TIME = 300 * 60 * 1000;

    /**
     * jwt密钥
     */
    private static final String SECRET = "jwt_secret";

    /**
     * 生成jwt字符串，五小时后过期  JWT(json web token)
     */
    public static String sign(Integer userId, String username) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            return JWT.create()
                    //将userId保存到token里面
                    .withAudience(Integer.toString(userId), username)
//                    //存放自定义数据
//                    .withClaim("info", info)// Map<String, Object> info
                    //五小时后token过期
                    .withExpiresAt(date)
                    //token的密钥
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据token获取userId
     */
    public static Integer getUserId(String token) throws JWTDecodeException {
            String userId = JWT.decode(token).getAudience().get(0);
            return Integer.parseInt(userId);
    }

    /**
     * 根据token获取自定义数据info
     */
    public static String getUsername(String token) {
        try {
            return JWT.decode(token).getAudience().get(1);
        } catch (JWTDecodeException e) {
            return null;
        }
    }

// 也可以装map

//    /**
//     * 根据token获取自定义数据info
//     * @param token
//     * @return
//     * */
//    public static Map<String, Object> getInfo(String token) {
//        try {
//            return JWT.decode(token).getClaim("info").asMap();
//        }catch (JWTDecodeException e) {
//            return null;
//        }
//    }

    /**
     * 校验token
     */
    public static boolean checkSign(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    //.withClaim("username, username)
                    .build();
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }
}

