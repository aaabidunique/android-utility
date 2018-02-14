package com.github.aaabidunique.androidutility.core.helper;

import android.content.Context;
import android.content.SharedPreferences;

@SuppressWarnings("unused")
public class SharedPreferenceHelper {

    private static String PREF_FILE = "PREF";

    private SharedPreferenceHelper() {
    }


    /**
     * @param fileName is the file name which will be used while getting values.
     *                 Default value is {@link #PREF_FILE}
     */
    private void setPreferenceFileName(String fileName) {
        PREF_FILE = fileName;
    }

    /**
     * @param context  is used for getting preference manager.
     * @param key      is the key in preference file.
     * @param defValue is the default value when key in not present
     * @return a string value saved in preference file if found or returns default value.
     * <p>
     * This method is responsible for getting value from preference file for the provided key if present else returns default value.
     */
    public static String getString(Context context, String key, String defValue) {
        return getString(context, PREF_FILE, key, defValue);
    }

    /**
     * @param context  is used for getting preference manager.
     * @param fileName is the fileName which will be used for fetching preference value.
     * @param key      is the key in preference file.
     * @param defValue is the default value when key in not present
     * @return a string value saved in preference file if found or returns default value.
     * <p>
     * This method is responsible for getting value from preference file for the provided key if present else returns default value.
     */
    public static String getString(Context context, String fileName, String key, String defValue) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, 0);
        return preferences.getString(key, defValue);
    }

    /**
     * @param context is used for getting preference manager.
     * @param key     is the key in preference file.
     * @param value   is the value for the key.
     *                This method is responsible for saving key with value.
     */
    public static void setString(Context context, String key, String value) {
        setString(context, PREF_FILE, key, value);
    }

    /**
     * @param context  is used for getting preference manager.
     * @param fileName is the fileName which will be used for saving preference value.
     * @param key      is the key in preference file.
     * @param value    is the value for the key.
     *                 This method is responsible for saving key with value.
     */
    public static void setString(Context context, String fileName, String key, String value) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * @param context  is used for getting preference manager.
     * @param key      is the key in preference file.
     * @param defValue is the default value when key in not present
     * @return a int value saved in preference file if found or returns default value.
     * <p>
     * This method is responsible for getting value from preference file for the provided key if present else returns default value.
     */
    public static int getInt(Context context, String key, int defValue) {
        return getInt(context, PREF_FILE, key, defValue);
    }

    /**
     * @param context  is used for getting preference manager.
     * @param fileName is the fileName which will be used for fetching preference value.
     * @param key      is the key in preference file.
     * @param defValue is the default value when key in not present
     * @return a int value saved in preference file if found or returns default value.
     * <p>
     * This method is responsible for getting value from preference file for the provided key if present else returns default value.
     */
    public static int getInt(Context context, String fileName, String key, int defValue) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, 0);
        return preferences.getInt(key, defValue);
    }

    /**
     * @param context is used for getting preference manager.
     * @param key     is the key in preference file.
     * @param value   is the value for the key.
     *                This method is responsible for saving key with value.
     */
    public static void setInt(Context context, String key, int value) {
        setInt(context, PREF_FILE, key, value);
    }

    /**
     * @param context  is used for getting preference manager.
     * @param fileName is the fileName which will be used for saving preference value.
     * @param key      is the key in preference file.
     * @param value    is the value for the key.
     *                 This method is responsible for saving key with value.
     */
    public static void setInt(Context context, String fileName, String key, int value) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    /**
     * @param context  is used for getting preference manager.
     * @param key      is the key in preference file.
     * @param defValue is the default value when key in not present
     * @return a boolean value saved in preference file if found or returns default value.
     * <p>
     * This method is responsible for getting value from preference file for the provided key if present else returns default value.
     */
    public static boolean getBoolean(Context context, String key, boolean defValue) {
        return getBoolean(context, PREF_FILE, key, defValue);
    }

    /**
     * @param context  is used for getting preference manager.
     * @param fileName is the fileName which will be used for fetching preference value.
     * @param key      is the key in preference file.
     * @param defValue is the default value when key in not present
     * @return a boolean value saved in preference file if found or returns default value.
     * <p>
     * This method is responsible for getting value from preference file for the provided key if present else returns default value.
     */
    public static boolean getBoolean(Context context, String fileName, String key, boolean defValue) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, 0);
        return preferences.getBoolean(key, defValue);
    }

    /**
     * @param context is used for getting preference manager.
     * @param key     is the key in preference file.
     * @param value   is the value for the key.
     *                This method is responsible for saving key with value.
     */
    public static void setBoolean(Context context, String key, boolean value) {
        setBoolean(context, PREF_FILE, key, value);
    }

    /**
     * @param context  is used for getting preference manager.
     * @param fileName is the fileName which will be used for saving preference value.
     * @param key      is the key in preference file.
     * @param value    is the value for the key.
     *                 This method is responsible for saving key with value.
     */
    public static void setBoolean(Context context, String fileName, String key, boolean value) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * @param context is used for getting preference manager.
     * @param key     is the key that need to be removed from preference file.
     *                This method removes the provided key from the preference file.
     */
    public static void remove(Context context, String key) {
        remove(context, PREF_FILE, key);
    }

    /**
     * @param context  is used for getting preference manager.
     * @param fileName is the fileName which will be used for removing preference value.
     * @param key      is the key that need to be removed from preference file.
     *                 This method removes the provided key from the preference file.
     */
    public static void remove(Context context, String fileName, String key) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
        editor.apply();
    }
}