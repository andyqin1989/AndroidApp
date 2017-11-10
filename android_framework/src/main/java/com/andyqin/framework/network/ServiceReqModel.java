package com.andyqin.framework.network;

/**
 * Created by qinbaoyuan on 2017/11/8.
 * 请求服务的对象集成
 */
public class ServiceReqModel {

    private Builder builder;

    public ServiceReqModel(Builder builder) {
        this.builder = builder;
    }

    public BaseRequest getRequest() {
        return builder.request;
    }

    @SuppressWarnings("unchecked")
    public <T> Class<T> getResponseClass() {
        return builder.responseClass;
    }

    @SuppressWarnings("unchecked")
    public <T> OnServiceListener<T> getServiceListener() {
        return builder.serviceListener;
    }

    public BaseUrlInfo getUrlInfo() {
        return builder.urlInfo;
    }


    public static class Builder<T> {
        public Builder() {
        }

        /**
         * 请求实体
         */
        private BaseRequest request;

        /**
         * 响应实体类型
         */
        private Class<T> responseClass;

        /**
         * 服务回调接口
         */
        private OnServiceListener<T> serviceListener;

        /**
         * ip地址相关数据
         */
        BaseUrlInfo urlInfo;

        public Builder setRequest(BaseRequest request) {
            this.request = request;
            return this;
        }

        public Builder setResponseClass(Class<T> responseClass) {
            this.responseClass = responseClass;
            return this;
        }

        public Builder setServiceListener(OnServiceListener<T> serviceListener) {
            this.serviceListener = serviceListener;
            return this;
        }

        public Builder setUrlInfo(BaseUrlInfo urlInfo) {
            this.urlInfo = urlInfo;
            return this;
        }

        public ServiceReqModel build() {
            return new ServiceReqModel(this);
        }
    }
}
