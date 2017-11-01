package com.andyqin.framework.network;

import android.content.Context;

import com.android.volley.toolbox.Volley;
import com.andyqin.framework.network.volley.ServiceManager;
import com.andyqin.framework.network.volley.ServiceManagerImpl;

/**
 * Created by qinbaoyuan on 2017/8/29.
 */

public class ServiceController {
    public static <T> void sendService(Context context, Class<T> responseClass) {
        //ServiceManagerImpl.getInstance(context).load();
    }
}
