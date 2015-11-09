package com.linde.library.exception;

/**
 * Created by LinDe on 2015/11/9.
 * 将错误报告发送到服务器
 */
public interface SendExceptionToService
{
    void sendException(String errorString);
}
