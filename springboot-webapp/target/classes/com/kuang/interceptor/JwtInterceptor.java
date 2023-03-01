package com.kuang.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.kuang.dto.GeneralRes;
import com.kuang.util.JwtUtil;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        String token = request.getHeader("Authorization");
        // judge whether token is null
        if (token == null) {
            String json = JSONObject.toJSONString(GeneralRes.UnauthorizedRes401("No token, please login","TokenNotFound"));
            returnJson(response, json);
            return false;
        }
        // check token whether valid
        if (!JwtUtil.checkSign(token)) {
            String json = JSONObject.toJSONString(GeneralRes.UnauthorizedRes401("The token is invalid or expired, please login again","TokenError"));
            returnJson(response, json);
            return false;
        }


        // test to get the userId and userName
//        String userId = JwtUtil.getUserId(token).toString();
//        System.out.println("id : " + userId);
//        String username = JwtUtil.getUsername(token);
//        System.out.println("name : " + username);

        return true;
    }

    /**
     * when error, return the json
     */
    private void returnJson(HttpServletResponse response, String json) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.print(json);
        }
    }
}

