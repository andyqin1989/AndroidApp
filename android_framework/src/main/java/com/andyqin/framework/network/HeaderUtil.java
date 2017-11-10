package com.andyqin.framework.network;

import java.util.HashMap;

/**
 * Created by qinbaoyuan on 2017/11/10.
 * ...
 */

public class HeaderUtil {
    public static HashMap<String, String> getHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json; charset=UTF-8");
        return headers;
    }
}
