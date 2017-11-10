package com.andyqin.framework.network;

/**
 * Created by qinbaoyuan on 2017/9/13.
 */
public class ServiceEvent<T> {
    private T response;

    public ServiceEvent(T response) {
        this.response = response;
    }
}
