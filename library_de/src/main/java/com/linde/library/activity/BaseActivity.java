package com.linde.library.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.linde.library.utils.LogUtils;

/**
 * Created by LinDe on 2015/11/6.
 * Wrap Activity
 */
public abstract class BaseActivity extends AppCompatActivity
{
    protected final LogUtils mLogUtils = new LogUtils(getClass());

    public <T extends View> T initViewById(int id)
    {
        //noinspection unchecked
        return (T) findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mLogUtils.i("onCreate well onStart");
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        mLogUtils.i("onStart well onResume");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        mLogUtils.i("onResume well onPause");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        mLogUtils.i("onPause well onResume or onStop");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        mLogUtils.i("onRestart well onStart");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        mLogUtils.i("onStop well onRestart or onDestroy");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        mLogUtils.i("onDestroy and The Activity is shut down");
    }
}
