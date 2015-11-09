package com.linde.library.application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by LinDe on 2015/11/9.
 * Add Leak Listener
 */
public class LeakCanaryApplication extends VolleyApplication
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        LeakCanary.install(this);
    }
}
