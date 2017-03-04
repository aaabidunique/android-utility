package com.ali.androidutility.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceHelper {
    public final static String PREF_FILE = "PREF";

    public static String getString(Context context, String key, String defValue) {
        return getString(context, PREF_FILE, key, defValue);
    }

    public static String getString(Context context, String fileName, String key, String defValue) {
        SharedPreferences settings = context.getSharedPreferences(fileName, 0);
        return settings.getString(key, defValue);
    }

    public static void setString(Context context, String key, String value) {
        setString(context, PREF_FILE, key, value);
    }

    public static void setString(Context context, String fileName, String key, String value) {
        SharedPreferences settings = context.getSharedPreferences(fileName, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static int getInt(Context context, String key, int defValue) {
        return getInt(context, PREF_FILE, key, defValue);
    }

    public static int getInt(Context context, String fileName, String key, int defValue) {
        SharedPreferences settings = context.getSharedPreferences(fileName, 0);
        return settings.getInt(key, defValue);
    }

    public static void setInt(Context context, String key, int value) {
        setInt(context, PREF_FILE, key, value);
    }

    public static void setInt(Context context, String fileName, String key, int value) {
        SharedPreferences settings = context.getSharedPreferences(fileName, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        return getBoolean(context, PREF_FILE, key, defValue);
    }

    public static boolean getBoolean(Context context, String fileName, String key, boolean defValue) {
        SharedPreferences settings = context.getSharedPreferences(fileName, 0);
        return settings.getBoolean(key, defValue);
    }

    public static void setBoolean(Context context, String key, boolean value) {
        setBoolean(context, PREF_FILE, key, value);
    }

    public static void setBoolean(Context context, String fileName, String key, boolean value) {
        SharedPreferences settings = context.getSharedPreferences(fileName, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static void remove(Context context, String key) {
        remove(context, PREF_FILE, key);
    }

    public static void remove(Context context, String fileName, String key) {
        SharedPreferences settings = context.getSharedPreferences(fileName, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.remove(key);
        editor.apply();
    }
}