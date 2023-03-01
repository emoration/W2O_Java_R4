package com.kuang.dto;

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

    public static GeneralRes BadRes403(String message, String error) {
        return new GeneralRes(403, message, null, error);
    }

    public static GeneralRes GoodRes200(Object data) {
        return new GeneralRes(200, "success", data, "");
    }

    public static GeneralRes UnauthorizedRes401(String message, String error) {
        return new GeneralRes(401, message, null, error);
    }

    public static GeneralRes BackendErrorRes500(String message, String error) {
        return new GeneralRes(500, message, null, error);
    }
}
