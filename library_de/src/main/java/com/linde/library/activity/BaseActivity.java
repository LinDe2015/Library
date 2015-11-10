package com.linde.library.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.linde.library.utils.LogUtils;

/**
 * Created by LinDe on 2015/11/6.
 * Wrap Activity
 */
public abstract class BaseActivity extends AppCompatActivity
{
    protected final LogUtils mLogUtils = new LogUtils(getClass());

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
        mLogUtils.i("onDestroy and the Activity is shut down");
    }

    @SuppressWarnings("unused")
    protected void addFragment(@IdRes int id, Fragment fragment)
    {
        try
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .add(id, fragment)
                    .commit();
        }
        catch (Exception e) {e.printStackTrace();}
    }

    @SuppressWarnings("unused")
    protected void replaceFragment(@IdRes int id, Fragment fragment)
    {
        try
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(id, fragment)
                    .commit();
        }
        catch (Exception e) {e.printStackTrace();}
    }

    @SuppressWarnings("unused")
    protected void removeFragment(Fragment fragment)
    {
        try
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                    .remove(fragment)
                    .commit();
        }
        catch (Exception e) {e.printStackTrace();}
    }
}
