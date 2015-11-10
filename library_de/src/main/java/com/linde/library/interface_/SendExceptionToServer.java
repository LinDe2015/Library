package com.linde.library.interface_;

/**
 * Created by LinDe on 2015/11/9.
 * 将错误报告发送到服务器
 */
public interface SendExceptionToServer
{
    /**
     * @param errorString error message
     * @return true: delete file
     */
    boolean sendException(String errorString);
}
