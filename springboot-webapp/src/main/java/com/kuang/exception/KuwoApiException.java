package com.kuang.exception;

/**
 * 酷我音乐Api异常类，有可能是请求信息过时之类的
 */
public class KuwoApiException extends Exception {
    public KuwoApiException(Throwable cause) {
        super(cause);
    }
}