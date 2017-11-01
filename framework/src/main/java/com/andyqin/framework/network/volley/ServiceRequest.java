package com.andyqin.framework.network.volley;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by qinbaoyuan on 2017/8/28.
 */

public class ServiceRequest<T> extends Request<T> {
    private ObjectMapper objectMapper = new ObjectMapper();

    String url;
    Class<T> clazz;
    protected Response.Listener<T> listener;
    protected Response.ErrorListener errorListener;

    private ServiceRequest(int method, String url, Response.ErrorListener listener) {
        super(method, url, listener);
    }

    public ServiceRequest(String url, Class<T> clazz, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        this(Method.POST, url, errorListener);
        this.url = url;
        this.clazz = clazz;
        this.listener = listener;
        this.errorListener = errorListener;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        byte[] data = response.data;
        try {
            String json = new String(data, HttpHeaderParser.parseCharset(response.headers));
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
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }
}
