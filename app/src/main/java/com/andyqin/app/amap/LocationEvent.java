package com.andyqin.app.amap;

/**
 * Created by youj on 2015/5/12.
 * eventbus定位事件，当定位请求返回时，用于封装定位成功或失败信息(目前仅有一个高德)
 */
public class LocationEvent {

    private LFAmapLocationModel locationModel;

    private LFAmapLocationFailModel locationFailModel;

    public LocationEvent(LFAmapLocationModel locationModel) {
        this.locationModel = locationModel;
    }

    public LocationEvent(LFAmapLocationFailModel locationFailModel) {
        this.locationFailModel = locationFailModel;
    }

    public LFAmapLocationModel getLocationModel() {
        return locationModel;
    }

    public void setLocationModel(LFAmapLocationModel locationModel) {
        this.locationModel = locationModel;
    }

    public LFAmapLocationFailModel getLocationFailModel() {
        return locationFailModel;
    }

    public void setLocationFailModel(LFAmapLocationFailModel locationFailModel) {
        this.locationFailModel = locationFailModel;
    }
}
