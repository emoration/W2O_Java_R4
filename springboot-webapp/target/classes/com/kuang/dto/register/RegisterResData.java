package com.kuang.dto.register;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 返回 post注册信息的response的data参数 的类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResData {
    private int id;
    private String username;
}
