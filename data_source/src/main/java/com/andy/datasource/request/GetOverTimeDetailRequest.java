package com.andy.datasource.request;

import com.andyqin.framework.network.BaseRequest;
import com.andyqin.framework.network.RequestAnnotation;

/**
 * Created by qinbaoyuan on 2017/11/9.
 * ...
 */
@RequestAnnotation(path = "/api/getOverTimeDetail")
//@RequestAnnotation(path = "/myserver/api/getOverTimeDetail")
public class GetOverTimeDetailRequest extends BaseRequest{
    String phoneNum;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
