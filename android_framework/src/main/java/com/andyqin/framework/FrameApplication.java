package com.andyqin.framework;

import android.app.Application;

/**
 * Created by qinbaoyuan on 2017/11/8.
 * ...
 */
public class FrameApplication extends Application {
    private static FrameApplication instance = null;

    public static Application getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
