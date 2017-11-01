package com.andyqin.framework;

/**
 * Created by qinbaoyuan on 2017/8/29.
 */

public abstract class OnServiceListener<T> {
    public abstract void OnServerSuccess(T response, String token);

    public void onServiceFail() {

    }
}
