package com.github.aaabidunique.androidutility.core.utility;

import android.Manifest;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.annotation.RequiresPermission;
import android.util.Log;

import com.github.aaabidunique.androidutility.validation.ValidationUtility;

@SuppressWarnings("unused")
public class WifiUtility {

    private static final String TAG = WifiUtility.class.getSimpleName();

    private WifiUtility() {
    }

    /**
     * @param context is used for fetching connectivity manager.
     * @return boolean indicating whether device is connected to wifi or not.
     */
    @RequiresPermission(allOf = {Manifest.permission.ACCESS_WIFI_STATE, Manifest.permission.ACCESS_NETWORK_STATE})
    public static boolean isConnected(Context context) {
        boolean isConnected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (ValidationUtility.isNotEmpty(connectivityManager)) {
            NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            isConnected = wifi.isConnected();
        } else {
            String error = "Invalid connectivity manager instance";
            Log.e(TAG, error);
        }
        return isConnected;
    }

    /**
     * @param context is used for fetching wifi manager.
     * @return integer value which denotes thewifi signal strength
     */
    @RequiresPermission(allOf = {Manifest.permission.ACCESS_WIFI_STATE, Manifest.permission.ACCESS_NETWORK_STATE})
    public static int getCurrentSignalStrength(Context context) {
        final WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (ValidationUtility.isNotEmpty(wifiManager)) {
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            return wifiInfo.getRssi();
        }
        return -1;
    }

    /**
     * @param context      is used for fetching wifi manager.
     * @param qualityLevel is an integer value i.e quality scale(generally 10 but can be any value).
     * @return integer value denoting current signal quality based on qualityLevel provided in the argument.
     */
    @RequiresPermission(allOf = {Manifest.permission.ACCESS_WIFI_STATE, Manifest.permission.ACCESS_NETWORK_STATE})
    public static int getCurrentSignalQuality(Context context, int qualityLevel) {
        final WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (ValidationUtility.isNotEmpty(wifiManager)) {
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            return WifiManager.calculateSignalLevel(wifiInfo.getRssi(), qualityLevel);
        }
        return -1;
    }

    /**
     * @param context is used for fetching wifi manager.
     * @return integer value denoting current frequency.
     */
    @RequiresPermission(allOf = {Manifest.permission.ACCESS_WIFI_STATE, Manifest.permission.ACCESS_NETWORK_STATE})
    public static int getCurrentFrequency(Context context) {
        final WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (ValidationUtility.isNotEmpty(wifiManager)) {
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                return wifiInfo.getFrequency();
            }
        }
        return -1;
    }
}
