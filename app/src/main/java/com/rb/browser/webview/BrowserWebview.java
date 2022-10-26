package com.rb.browser.webview;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.rb.browser.Browser;
import com.rb.browser.activities.BrowserActivity;
import com.rb.browser.database.SettingsKeys;
import com.rb.browser.utils.SettingsUtils;

public class BrowserWebview extends WebView {

    BrowserActivity act;
    Context cxt;
    SharedPreferences pref;

    public BrowserWebview(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        cxt = context;
        pref = ((Browser) context.getApplicationContext()).pref;
    }

    public void notifyWebviewSetup(){
        act = (BrowserActivity) cxt;

        doSettingsCheck();
    }

    public void doSettingsCheck(){
        if(SettingsUtils.getPrefNum(pref, SettingsKeys.theme_id) == 0){

        }
    }
}
