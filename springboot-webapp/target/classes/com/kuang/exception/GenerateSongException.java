package com.kuang.exception;

/**
 * 音乐生成异常类，一般是路径不对
 */
public class GenerateSongException extends Exception{
    public GenerateSongException(Throwable cause) {
        super(cause);
    }
}
