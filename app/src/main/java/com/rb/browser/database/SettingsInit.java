package com.rb.browser.database;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SettingsInit {

    public SharedPreferences pref;

    public SettingsInit(Context context){
        pref = context.getSharedPreferences(SettingsKeys.browser_saver, Activity.MODE_PRIVATE);
    }
}
