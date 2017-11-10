package com.andyqin.framework.network.volley;

import android.text.TextUtils;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.andyqin.framework.network.BaseRequest;
import com.andyqin.framework.network.HeaderUtil;
import com.andyqin.framework.network.NetWorkLog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qinbaoyuan on 2017/8/28.
 * 服务请求Request
 */
public class ServiceRequest<T> extends Request<T> {
    private ObjectMapper objectMapper = new ObjectMapper();
    private BaseRequest requestObject;

    private String url;
    private Class<T> clazz;
    private Response.Listener<T> listener;
    private Response.ErrorListener errorListener;

    private ServiceRequest(int method, String url, Response.ErrorListener listener) {
        super(method, url, listener);
    }

    public ServiceRequest(String url, BaseRequest request, Class<T> clazz, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        this(Method.POST, url, errorListener);
        this.url = url;
        this.clazz = clazz;
        this.requestObject = request;
        this.listener = listener;
        this.errorListener = errorListener;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        byte[] data = response.data;
        try {
            String json = new String(data, HttpHeaderParser.parseCharset(response.headers));
            showJSON(url, "Response", json);
            T result = objectMapper.readValue(json, clazz);
            return Response.success(result, HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return Response.error(new ParseError(e));
        } catch (IOException e) {
            e.printStackTrace();
            return Response.error(new ParseError(e));
        }
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        if (requestObject == null) {
            return null;
        }
        try {
            ObjectWriter writer = objectMapper.writer();
            String json = writer.writeValueAsString(requestObject);
            showJSON(url, "Request", json);
            return json.getBytes();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map map = HeaderUtil.getHeaders();
        if (map == null) {
            map = super.getHeaders();
        }
        return map;
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }

    @Override
    protected VolleyError parseNetworkError(VolleyError volleyError) {
        return super.parseNetworkError(volleyError);
    }

    @Override
    public void deliverError(VolleyError error) {
        super.deliverError(error);
        errorListener.onErrorResponse(error);
    }

    /**
     * logger
     */
    public static void showJSON(String url, String tag, String message) {
        if (!TextUtils.isEmpty(url)) NetWorkLog.e("@@@@@@-url: " + url);
        if (TextUtils.isEmpty(tag)) tag = " ";
        NetWorkLog.e("@@@@@@- Begin " + tag + " Body -@@@@@@");
        NetWorkLog.e(message);
        NetWorkLog.e("@@@@@@- End " + tag + " Body -@@@@@@");
    }
}
