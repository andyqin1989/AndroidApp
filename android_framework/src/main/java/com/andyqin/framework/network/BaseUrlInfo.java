package com.andyqin.framework.network;

/**
 * Created by qinbaoyuan on 2017/11/8.
 * ...
 */

public abstract class BaseUrlInfo {
    protected String protocol;
    protected String ip;
    protected String port;
    protected String path;

    protected static BaseUrlInfo instance;

    public abstract void initUrl();

    public abstract String getUrlPre();


}
