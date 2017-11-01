package com.andyqin.app.amap;

import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.andyqin.app.MyApplication;


/**
 * Created by youj on 2015/04/20.
 * <p>
 * 封装高德定位的相关具体操作
 */
public class LFAMapLocator extends LFBaseLocator {
    private AMapLocationClient client;

    private CallBack callBack;

    public LFAMapLocator(CallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void startLocating() {
        getLocationManager().startLocation();
    }

    private AMapLocationClient getLocationManager() {
        if (null == client) {
            client = new AMapLocationClient(MyApplication.getInstance());
            client.setLocationOption(getOption());
            client.setLocationListener(new AMapLocationListenerImpl());
        }
        return client;
    }

    private AMapLocationClientOption getOption() {
        AMapLocationClientOption option = new AMapLocationClientOption();
        option.setGpsFirst(false);
        option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        option.setNeedAddress(true);
        option.setOnceLocation(true);
        option.setOnceLocationLatest(true);
        option.setLocationCacheEnable(false);
        return option;
    }

    private void stopLocating() {
        if (null != getLocationManager()) {
            getLocationManager().stopLocation();
        }
    }

    private class AMapLocationListenerImpl implements AMapLocationListener {

        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            callBack.onResult(aMapLocation);
            if (null != aMapLocation && aMapLocation.getErrorCode() == 0) {
                Log.e("andy", "定位成功 aMpaLocation = " + aMapLocation.toStr());
                LFAmapLocationModel locationModel = new LFAmapLocationModel();
                locationModel.setLatitude(aMapLocation.getLatitude());
                locationModel.setLongitude(aMapLocation.getLongitude());
                locationModel.setAccuracy(aMapLocation.getAccuracy());
                locationModel.setProvider(aMapLocation.getProvider());
                locationModel.setProvince(aMapLocation.getProvince());
                locationModel.setCity(aMapLocation.getCity());
                locationModel.setCityCode(aMapLocation.getCityCode());
                locationModel.setDistrict(aMapLocation.getDistrict());
                locationModel.setAdCode(aMapLocation.getAdCode());
                //locationModel.setStreet(aMapLocation.getStreet());
                locationModel.setAddress(aMapLocation.getAddress());
                //locationModel.setGenerateTime(aMapLocation.getTime());
//                WkEvent.BaseLibEvent evt = WkEvent.BaseLibEvent.Location_Event;
//                evt.setObject(new LocationEvent(locationModel));
//                EventBus.getDefault().post(evt);

            } else {
                LFAmapLocationFailModel failModel = new LFAmapLocationFailModel();
                if (null != aMapLocation) {
                    failModel.setErrorMessage(aMapLocation.getErrorInfo());
                }
//                WkEvent.BaseLibEvent evt = WkEvent.BaseLibEvent.Location_Event;
//                evt.setObject(new LocationEvent(failModel));
//                EventBus.getDefault().post(evt);
            }

        }
    }

    public interface CallBack {
        void onResult(AMapLocation aMapLocation);
    }

}
