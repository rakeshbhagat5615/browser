package com.rb.browser;

import android.app.Application;
import android.content.SharedPreferences;

import com.rb.browser.database.SettingsInit;

public class Browser extends Application {

    public SharedPreferences pref;

    @Override
    public void onCreate() {
        super.onCreate();

        pref = new SettingsInit(this).pref;
    }
}
