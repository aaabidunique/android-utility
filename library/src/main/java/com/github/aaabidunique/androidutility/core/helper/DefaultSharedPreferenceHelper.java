package com.github.aaabidunique.androidutility.core.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

@SuppressWarnings("unused")
public class DefaultSharedPreferenceHelper {

    /**
     * @param context  is used for getting preference manager.
     * @param key      is the key in preference file.
     * @param defValue is the default value when key in not present
     * @return a string value saved in preference file if found or returns default value.
     * <p>
     * This method is responsible for getting value from default preference file for the provided key if present else returns default value.
     */
    public static String getString(Context context, String key, String defValue) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, defValue);
    }

    /**
     * @param context  is used for getting preference manager.
     * @param key      is the key in preference file.
     * @param defValue is the default value when key in not present
     * @return a int value saved in preference file if found or returns default value.
     * <p>
     * This method is responsible for getting value from default preference file for the provided key if present else returns default value.
     */
    public static int getInt(Context context, String key, int defValue) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getInt(key, defValue);
    }

    /**
     * @param context  is used for getting preference manager.
     * @param key      is the key in preference file.
     * @param defValue is the default value when key in not present
     * @return a boolean value saved in preference file if found or returns default value.
     * <p>
     * This method is responsible for getting value from default preference file for the provided key if present else returns default value.
     */
    public static boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(key, defValue);
    }
}