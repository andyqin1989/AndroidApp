package com.andyqin.framework.network.volley;

import com.andyqin.framework.network.BaseRequest;
import com.andyqin.framework.network.OnServiceListener;

/**
 * Created by qinbaoyuan on 2017/8/28.
 * 抽象服务管理器
 */
public abstract class ServiceManager<T> {
    public abstract void load(BaseRequest request, String url, Class<T> clazz, OnServiceListener<T> serviceListener);
}
