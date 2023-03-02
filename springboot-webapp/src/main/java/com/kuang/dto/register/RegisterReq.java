package com.kuang.dto.register;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接收 post注册信息的request参数 的类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterReq {
    //    {
//        "username":"admin",
//        "password":"123456",
//        "checkPassword":"123456"
//    }
    private String username;
    private String password;
    private String checkPassword;
}
