package com.linde.library.application;

import android.app.Application;

import com.linde.library.exception.AppExceptionHandler;
import com.linde.library.exception.SendExceptionToService;
import com.linde.library.utils.LogUtils;

/**
 * Created by LinDe on 2015/11/9.
 * Wrap {@link Application}
 */
public class CustomExceptionApplication extends Application implements SendExceptionToService
{
    public final LogUtils mLogUtils = new LogUtils(getClass());

    @Override
    public void onCreate()
    {
        super.onCreate();
        AppExceptionHandler.getInstance(this, this);
    }

    @Override
    public void sendException(String errorString) {mLogUtils.i("You Need Send Exception to Service");}
}
