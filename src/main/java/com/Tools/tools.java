package com.Tools;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;

public class tools {

    /* 获取手机系统版本号 */
    public static String getAndroidVersion() {
        String version_release = Build.VERSION.RELEASE;
        return version_release;
    }

    /* 获取手机设备名称 */
    public static String getAndroidName(Context context) {
        String androidId = Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        return androidId;
    }

    /* 获取设备序列号 */
    public static String getDeviceISN(Context context) {

        String device_model = Build.MODEL;
        return device_model;
    }

    /* 获取设备型号UUID */
    public static String getDeviceType(Context context) {
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            return "";
        }
        String deviceId = tm.getDeviceId();
        return deviceId;
    }

    /* 获取app当前版本号 */
    public static String getAppVersion(Context context) {
        String version = "";
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(),
                    0);
            version = info.versionName;


        } catch (Exception e) {
            e.printStackTrace();

        }
        return version;
    }

    /* 获取app当前版本号 */
    public static int getAppVersionCode(Context context) {
        int version = 1;
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(),
                    0);
            version = info.versionCode;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return version;
    }

}
