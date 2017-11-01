package com.andyqin.framework.network.volley;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.andyqin.framework.OnServiceListener;

/**
 * Created by qinbaoyuan on 2017/8/28.
 */

public class ServiceManagerImpl extends ServiceManager {
    private RequestQueue requestQueue;
    private Context context;
    private OnServiceListener serviceListener;


    private static ServiceManager instance;

    private ServiceManagerImpl(Context context) {
        this.context = context;
    }

    public static synchronized ServiceManager getInstance(Context context) {
        if (instance == null) {
            instance = new ServiceManagerImpl(context);
        }
        return instance;
    }


    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }

    Response.Listener listener = new Response.Listener() {
        @Override
        public void onResponse(Object response) {
            Log.e("andy", "onResponse");

        }
    };

    Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("andy", "onErrorResponse");
        }
    };

    @Override
    public void load(String url, Class clazz, OnServiceListener serviceListener) {
        Request request = new ServiceRequest(url, clazz, listener, errorListener);
        getRequestQueue().add(request);
    }
}
