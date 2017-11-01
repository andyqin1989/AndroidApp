package com.andyqin.app;

import android.app.Application;

/**
 * Created by qinbaoyuan on 2017/9/11.
 */

public class MyApplication extends Application {
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
