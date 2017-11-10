package com.andyqin.framework.util;

import android.os.Build;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ted on 03/03/2017.
 * in com.wukong.sdk.hardware
 */

public class WKMobileType {

    /***
     * 是否是酷派机型
     */
    public static boolean isCoolpad() {
        try {
            String lowerCaseModel = Build.MODEL.toLowerCase();
            return lowerCaseModel.contains("coolpad") || lowerCaseModel.contains("dazen");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isBlur() {
        try {
            return Build.BRAND.toLowerCase().contains("blur");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 是否是中兴手机
     */
    public static boolean isZTE() {
        try {
            return Build.BRAND.toLowerCase().contains("zte");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 是否是三星S2
     */
    public static boolean isGalaxyS2() {
        try {
            String lowerCaseModel = Build.MODEL.toLowerCase();
            return lowerCaseModel.contains("gt-i9100")
                    || lowerCaseModel.contains("gt-i9108")
                    || lowerCaseModel.contains("gt-i9103");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 是否是魅族手机
     */
    public static boolean isMX() {
        try {
            String lowerCaseModel = Build.MODEL.toLowerCase();
            return lowerCaseModel.contains("m353") || lowerCaseModel.contains("mx");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 是否是Nexus手机
     */
    public static boolean isNexusS() {
        try {
            String lowerCaseModel = Build.MODEL.toLowerCase();
            return lowerCaseModel.contains("nexus s");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 是否是亚马逊的kindle fire
     */
    public static boolean isKindleFire() {
        try {
            return Build.MODEL.toLowerCase().contains("kindle fire");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isXiaoMi(){
        return "Xiaomi".equalsIgnoreCase(Build.MANUFACTURER);
    }

    /**
     * 是否是小米手机
     */
    public static boolean isMIUI() {
        File buildPropFile = new File("/system/build.prop");
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(buildPropFile));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("ro.miui.ui.version.code")) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
