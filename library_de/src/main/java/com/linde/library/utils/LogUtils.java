package com.linde.library.utils;

import android.util.Log;

/**
 * Created by LinDe on 2015/11/6.
 * 日志工具类
 */
public class LogUtils
{
    private final String TAG;

    public LogUtils(Class clazz) {TAG = clazz.getName();}

    public void v(String msg) {this.v(msg, null); }

    public void v(String msg, Throwable tr)
    {
        msg = msg == null ? "null" : msg;
        if (tr == null) Log.v(TAG, msg);
        else Log.v(TAG, msg, tr);
    }

    public void d(String msg) {this.d(msg, null); }

    public void d(String msg, Throwable tr)
    {
        msg = msg == null ? "null" : msg;
        if (tr == null) Log.d(TAG, msg);
        else Log.d(TAG, msg, tr);
    }

    public void i(String msg) {this.i(msg, null); }

    public void i(String msg, Throwable tr)
    {
        msg = msg == null ? "null" : msg;
        if (tr == null) Log.i(TAG, msg);
        else Log.i(TAG, msg, tr);
    }

    public void w(String msg) {this.w(msg, null);}

    public void w(String msg, Throwable tr)
    {
        msg = msg == null ? "null" : msg;
        if (tr == null) Log.w(TAG, msg);
        else Log.w(TAG, msg, tr);
    }

    public void e(String msg) {this.e(msg, null); }

    public void e(String msg, Throwable tr)
    {
        msg = msg == null ? "null" : msg;
        if (tr == null) Log.e(TAG, msg);
        else Log.e(TAG, msg, tr);
    }
}
