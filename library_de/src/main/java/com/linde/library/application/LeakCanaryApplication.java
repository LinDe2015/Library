package com.linde.library.application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by LinDe on 2015/11/9.
 * 监控App内存泄漏
 */
public class LeakCanaryApplication extends InjectApplication
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        LeakCanary.install(this);
    }
}
