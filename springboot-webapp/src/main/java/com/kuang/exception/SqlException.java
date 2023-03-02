package com.kuang.exception;

/**
 * sql异常类，可能是语句错误
 */
public class SqlException extends Exception{

    public SqlException() {
    }

    public SqlException(String message) {
        super(message);
    }
}
