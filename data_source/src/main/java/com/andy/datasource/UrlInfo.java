package com.andy.datasource;

import com.andyqin.framework.network.BaseUrlInfo;

/**
 * Created by qinbaoyuan on 2017/11/9.
 * ...
 */
public class UrlInfo extends BaseUrlInfo {

    public static BaseUrlInfo getInstance() {
        if (instance == null) {
            instance = new UrlInfo();
            instance.initUrl();
        }
        return instance;
    }

    @Override
    public void initUrl() {
        this.protocol = "http://";
        //this.ip = "123.57.242.138";
        this.ip = "10.0.90.36";
        //this.port = "1109";
        this.port = "8080";
    }

    @Override
    public String getUrlPre() {
        return protocol + ip + ":" + port;
    }
}
