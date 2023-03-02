package com.kuang.dto.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回 登录成功信息的response的data参数 的类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResData {
    private int id;
    private String username;
    private String token;
}
