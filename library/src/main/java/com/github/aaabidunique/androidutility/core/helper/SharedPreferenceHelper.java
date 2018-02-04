package com.github.aaabidunique.androidutility.core.helper;

import android.content.Context;
import android.content.SharedPreferences;

@SuppressWarnings("unused")
public class SharedPreferenceHelper {

    private static String PREF_FILE = "PREF";

    private SharedPreferenceHelper() {
    }

    private void setPreferenceFileName(String fileName) {
        PREF_FILE = fileName;
    }

    public static String getString(Context context, String key, String defValue) {
        return getString(context, PREF_FILE, key, defValue);
    }

    public static String getString(Context context, String fileName, String key, String defValue) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, 0);
        return preferences.getString(key, defValue);
    }

    public static void setString(Context context, String key, String value) {
        setString(context, PREF_FILE, key, value);
    }

    public static void setString(Context context, String fileName, String key, String value) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static int getInt(Context context, String key, int defValue) {
        return getInt(context, PREF_FILE, key, defValue);
    }

    public static int getInt(Context context, String fileName, String key, int defValue) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, 0);
        return preferences.getInt(key, defValue);
    }

    public static void setInt(Context context, String key, int value) {
        setInt(context, PREF_FILE, key, value);
    }

    public static void setInt(Context context, String fileName, String key, int value) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        return getBoolean(context, PREF_FILE, key, defValue);
    }

    public static boolean getBoolean(Context context, String fileName, String key, boolean defValue) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, 0);
        return preferences.getBoolean(key, defValue);
    }

    public static void setBoolean(Context context, String key, boolean value) {
        setBoolean(context, PREF_FILE, key, value);
    }

    public static void setBoolean(Context context, String fileName, String key, boolean value) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static void remove(Context context, String key) {
        remove(context, PREF_FILE, key);
    }

    public static void remove(Context context, String fileName, String key) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
        editor.apply();
    }
}