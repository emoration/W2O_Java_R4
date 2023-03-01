package com.kuang.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.util.Date;
import java.util.Map;

public class JwtUtil {
    /**
     * 过期5分钟
     */
    private static final long EXPIRE_TIME = 5 * 60 * 1000;

    /**
     * jwt密钥
     */
    private static final String SECRET = "jwt_secret";

    /**
     * 生成jwt字符串，五分钟后过期  JWT(json web token)
     *
     * @param userId //     * @param info,Map的value只能存放值的类型为：Map，List，Boolean，Integer，Long，Double，String and Date
     * @return
     */
//    public static String sign(String userId, Map<String, Object> info) {
    public static String sign(Integer userId, String username) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            return JWT.create()
                    //将userId保存到token里面
                    .withAudience(Integer.toString(userId), username)
//                    //存放自定义数据
//                    .withClaim("info", info)
                    //五分钟后token过期
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
     *
     * @param token
     * @return
     */
    public static Integer getUserId(String token) {
        try {
            String userId = JWT.decode(token).getAudience().get(0);
            return Integer.parseInt(userId);
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 根据token获取自定义数据info
     *
     * @param token
     * @return
     */
    public static String getUsername(String token) {
        try {
            return JWT.decode(token).getAudience().get(1);
        } catch (JWTDecodeException e) {
            return null;
        }
    }

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
     *
     * @param token
     * @return
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
            throw new RuntimeException("token 无效，请重新获取");
        }
    }
}

