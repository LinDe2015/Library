package com.linde.library.application;

import com.linde.library.utils.FindViewByIdUtils;

/**
 * Created by LinDe on 2015/11/10.
 * Inject
 */
public class InjectApplication extends VolleyApplication
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        FindViewByIdUtils.init(this);
    }
}
