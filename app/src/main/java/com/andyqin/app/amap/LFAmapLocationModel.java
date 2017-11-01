package com.andyqin.app.amap;

/**
 * Created by youj on 2015/4/20.
 * <p>
 * 封装高德定位返回的原始数据(当有多个locator时可抽象)
 */
public class LFAmapLocationModel {

    /**
     * 经度
     */
    private double longitude;

    /**
     * 纬度
     */
    private double latitude;

    /**
     * 定位精度半径
     */
    private float accuracy;

    /**
     * 位置数据提供者名称("lbs"/"gps")
     */
    private String provider;

    /**
     * 省
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 城市编码
     */
    private String cityCode;

    /**
     * 区(县)
     */
    private String district;

    /**
     * 区域编码
     */
    private String adCode;

    /**
     * 街道和门牌信息
     */
    private String street;

    /**
     * 详细地址
     */
    private String address;

//    /**
//     * 生成时间
//     */
//    private long generateTime;

    LFAmapLocationModel() {

    }

    public LFAmapLocationModel(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

//    public void setGenerateTime(long generateTime) {
//        this.generateTime = generateTime;
//    }
//
//    public long getGenerateTime() {
//        return generateTime;
//    }

    public float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
