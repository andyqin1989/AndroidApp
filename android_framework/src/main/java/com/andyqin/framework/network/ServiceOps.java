package com.andyqin.framework.network;

import com.andyqin.framework.network.volley.ServiceManagerImpl;

/**
 * Created by qinbaoyuan on 2017/11/8.
 * ...
 */

public class ServiceOps {

    @SuppressWarnings("unchecked")
    public static void loadData(ServiceReqModel reqModel) {
        String url = getRequestUrl(reqModel);
        ServiceManagerImpl.getInstance().load(reqModel.getRequest(), url, reqModel.getResponseClass(), reqModel.getServiceListener());
    }

    /**
     * 获取请求url
     */
    private static String getRequestUrl(ServiceReqModel reqModel) {
        String path = getRequestPath(reqModel);

        if (path == null || path.length() == 0) {
            return null;
        }

        String urlPre = reqModel.getUrlInfo().getUrlPre();

        return urlPre + path;
    }

    /**
     * 获取请求路径
     */
    private static String getRequestPath(ServiceReqModel reqModel) {
        if (reqModel == null || reqModel.getRequest() == null || reqModel.getResponseClass() == null || reqModel.getUrlInfo() == null) {
            return null;
        }

        RequestAnnotation requestAnnotation = reqModel.getRequest().getClass().getAnnotation(RequestAnnotation.class);
        if (requestAnnotation == null || requestAnnotation.path().length() == 0) {
            return null;
        }

        return requestAnnotation.path();
    }

}
