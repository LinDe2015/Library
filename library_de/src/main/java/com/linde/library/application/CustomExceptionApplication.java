package com.linde.library.application;

import android.app.Application;

import com.linde.library.exception.AppExceptionHandler;
import com.linde.library.interface_.SendExceptionToServer;
import com.linde.library.utils.LogUtils;

/**
 * Created by LinDe on 2015/11/9.
 * 处理App异常，发送异常报告到服务器
 */
public class CustomExceptionApplication extends Application implements SendExceptionToServer
{
    public final LogUtils mLogUtils = new LogUtils(getClass());

    @Override
    public void onCreate()
    {
        super.onCreate();
        AppExceptionHandler app = AppExceptionHandler.getInstance(this, this);
        app.sendPreviousReportsToServer();
    }

    @Override
    public boolean sendException(String errorString)
    {
        mLogUtils.e(errorString);
        return false;
    }
}
