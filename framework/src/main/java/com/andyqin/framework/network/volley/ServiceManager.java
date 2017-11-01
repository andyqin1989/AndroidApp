package com.andyqin.framework.network.volley;

import com.android.volley.Response;
import com.andyqin.framework.OnServiceListener;

/**
 * Created by qinbaoyuan on 2017/8/28.
 */

public abstract class ServiceManager<T> {
    public abstract void load(String url, Class<T> clazz, OnServiceListener<T> serviceListener);
}
