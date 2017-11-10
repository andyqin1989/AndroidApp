package com.andyqin.framework.network.volley;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.andyqin.framework.FrameApplication;
import com.andyqin.framework.network.BaseRequest;
import com.andyqin.framework.network.OnServiceListener;
import com.andyqin.framework.network.ServiceEvent;

/**
 * Created by qinbaoyuan on 2017/8/28.
 * 服务管理器实现
 */
public class ServiceManagerImpl extends ServiceManager {
    private RequestQueue requestQueue;
    private Context context;
    private OnServiceListener serviceListener;


    private static ServiceManager instance;

    private ServiceManagerImpl(Context context) {
        this.context = context;
    }

    public static synchronized ServiceManager getInstance() {
        if (instance == null) {
            instance = new ServiceManagerImpl(FrameApplication.getInstance());
        }
        return instance;
    }


    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }

    @SuppressWarnings("unchecked")
    private Response.Listener listener = new Response.Listener() {
        @Override
        public void onResponse(Object response) {
            ServiceEvent event = new ServiceEvent(response);
            serviceListener.OnServerSuccess(response, "00");
        }
    };

    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("andy", "error.toString()");
        }
    };

    @Override
    @SuppressWarnings("unchecked")
    public void load(BaseRequest requestObject, String url, Class clazz, OnServiceListener serviceListener) {
        this.serviceListener = serviceListener;
        Request request = new ServiceRequest(url, requestObject, clazz, listener, errorListener);
        //request.setTag(requestObject);
        getRequestQueue().add(request);
    }
}
