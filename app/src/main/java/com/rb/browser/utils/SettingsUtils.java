package com.rb.browser.utils;

import android.content.SharedPreferences;

public class SettingsUtils {

    public static void setPref(SharedPreferences pref, String tag, String value){
        pref.edit().putString(tag, value).apply();
    }

    public static void setPrefNum(SharedPreferences pref, String tag, int value){
        pref.edit().putInt(tag, value).apply();
    }

    public static String getPref(SharedPreferences pref, String tag){
        return pref.getString(tag, "");
    }

    public static int getPrefNum(SharedPreferences pref, String tag){
        return pref.getInt(tag, 0);
    }
}
