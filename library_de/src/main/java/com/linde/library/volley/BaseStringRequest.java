package com.linde.library.volley;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by LinDe on 2015/11/6.
 * Base {@link StringRequest}
 */
public class BaseStringRequest extends StringRequest
{
    public BaseStringRequest(int method, String url, final BaseStringRequest.Listener listener)
    {
        super(method, url, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String s) {listener.onResponse(s);}
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError volleyError) {listener.onErrorResponse(volleyError);}
        });
    }

    public BaseStringRequest(String url, BaseStringRequest.Listener listener) {this(Method.GET, url, listener);}

    public interface Listener
    {
        void onResponse(String response);

        void onErrorResponse(VolleyError error);
    }
}
