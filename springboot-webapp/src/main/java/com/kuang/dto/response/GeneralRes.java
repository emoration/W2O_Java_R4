package com.kuang.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralRes {
    private int code;
    private String message;
    private Object data;
    private String error;
}
