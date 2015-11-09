package com.linde.library.application;

import com.linde.library.utils.VolleyUtils;

/**
 * Created by LinDe on 2015/11/9.
 * Wrap Volley
 */
public class VolleyApplication extends CustomExceptionApplication
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        VolleyUtils.install(this);
    }
}
