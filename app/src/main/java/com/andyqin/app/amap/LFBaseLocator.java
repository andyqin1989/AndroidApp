package com.andyqin.app.amap;

/**
 * Created by youj on 2015/04/20.
 * <p>
 * 抽象所有定位库(目前仅有一个高德)
 */
public abstract class LFBaseLocator {

    /**
     * 启动定位
     */
    public abstract void startLocating();

}
