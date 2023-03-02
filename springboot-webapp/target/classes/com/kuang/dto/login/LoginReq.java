package com.kuang.dto.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接收 post登录信息的request参数 的类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginReq {
    private String username;
    private String password;
}
