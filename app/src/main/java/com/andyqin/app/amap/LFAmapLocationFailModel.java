package com.andyqin.app.amap;

/**
 * Created by youj on 2015/5/12.
 * <p/>
 * 封装高德定位的错误信息(当有多个locator时可抽象)
 */
public class LFAmapLocationFailModel {

//    private int errorCode = -1;

    private String errorMessage;

    public LFAmapLocationFailModel() {

    }

//    public int getErrorCode() {
//        return errorCode;
//    }
//
//    public void setErrorCode(int errorCode) {
//        this.errorCode = errorCode;
//    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
