package com.andyqin.app;

import android.app.Application;

import com.andyqin.framework.FrameApplication;

/**
 * Created by qinbaoyuan on 2017/9/11.
 */

public class MyApplication extends FrameApplication {
    private static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
