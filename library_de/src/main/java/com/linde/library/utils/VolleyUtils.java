package com.linde.library.utils;

import android.app.Application;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.linde.library.volley.BaseStringRequest;
import com.linde.library.volley.GzipStringRequest;

/**
 * Created by LinDe on 2015/11/6.
 * Wrap {@link com.android.volley.toolbox.Volley}
 */
public class VolleyUtils
{
    private static boolean hadInstall = false;
    private static VolleyUtils instance;
    private LogUtils mLogUtils;
    private RequestQueue queue;

    private VolleyUtils() {}

    public static void init(Application application)
    {
        if (hadInstall) return;
        final VolleyUtils utils = VolleyUtils.getInstance();
        utils.mLogUtils = new LogUtils(VolleyUtils.class);
        utils.queue = Volley.newRequestQueue(application);
        hadInstall = true;
    }

    public static VolleyUtils getInstance()
    {
        if (instance == null)
        {
            synchronized (VolleyUtils.class)
            {
                if (instance == null) {instance = new VolleyUtils();}
            }
        }
        return instance;
    }

    public BaseStringRequest StringRequest(String url, BaseStringRequest.Listener listener)
    {
        return StringRequest(Request.Method.GET, url, listener);
    }

    public BaseStringRequest StringRequest(int method, String url, BaseStringRequest.Listener listener)
    {
        if (method != Request.Method.GET && method != Request.Method.POST)
        {
            mLogUtils.e("method must be Request.Method.GET or Request.Method.POST");
            return null;
        }
        BaseStringRequest request = new BaseStringRequest(method, url, listener);
        setRequestAndAddQueue(request);
        return request;
    }

    public GzipStringRequest GzipStringRequest(String url, BaseStringRequest.Listener listener)
    {
        return GzipStringRequest(Request.Method.GET, url, listener);
    }

    public GzipStringRequest GzipStringRequest(int method, String url, BaseStringRequest.Listener listener)
    {
        if (method != Request.Method.GET && method != Request.Method.POST)
        {
            mLogUtils.e("method must be Request.Method.GET or Request.Method.POST");
            return null;
        }
        final GzipStringRequest request = new GzipStringRequest(method, url, listener);
        setRequestAndAddQueue(request);
        return request;
    }

    private void setRequestAndAddQueue(StringRequest request)
    {
        request.setRetryPolicy(new DefaultRetryPolicy(
                4000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        request.setCharset("UTF-8");
        queue.add(request);
    }
}
