package com.linde.library.volley;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.linde.library.utils.LogUtils;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/**
 * Created by LinDe on 2015/11/6.
 * 重写StringRequest GZIP压缩
 */
public class GzipStringRequest extends BaseStringRequest
{
    private final LogUtils mLogUtils;

    public GzipStringRequest(int method, String url, Listener listener)
    {
        super(method, url, listener);
        mLogUtils = new LogUtils(this.getClass());
    }

    public GzipStringRequest(String url, Listener listener)
    {
        super(url, listener);
        mLogUtils = new LogUtils(this.getClass());
    }


    /**
     * 设置请求头 采用GZIP压缩
     *
     * @return {@link Map }
     * @throws AuthFailureError
     */
    @Override
    public Map<String, String> getHeaders() throws AuthFailureError
    {
        Map<String, String> headers = new HashMap<>();
        headers.put("Charset", "UTF-8");
        headers.put("Content-Type", "application/x-javascript");
        headers.put("Accept-Encoding", "gzip,deflate");
        return headers;
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response)
    {
        String jsonStr;
        String contentType = response.headers.get("Content-Encoding");
        final String GZIP_ENCODING_TYPE = "gzip";
        if (contentType != null && contentType.equalsIgnoreCase(GZIP_ENCODING_TYPE))
        {
            mLogUtils.i("服务器响应：GZIP解压缩");
            try
            {
                GZIPInputStream gzip = new GZIPInputStream(new BufferedInputStream(new ByteArrayInputStream(response.data)));
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[256];
                int count;
                while ((count = gzip.read(buffer)) >= 0)
                {
                    baos.write(buffer, 0, count);
                }
                byte[] bytes = baos.toByteArray();
                jsonStr = new String(bytes);
            }
            catch (IOException e)
            {
                e.printStackTrace();
                return Response.error(new ParseError(e));
            }
        } else
        {
            mLogUtils.i("服务器响应：不是GZIP解压缩");
            try
            {
                jsonStr = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            }
            catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
                return Response.error(new ParseError(e));
            }
        }
        return Response.success(jsonStr, HttpHeaderParser.parseCacheHeaders(response));
    }
}
