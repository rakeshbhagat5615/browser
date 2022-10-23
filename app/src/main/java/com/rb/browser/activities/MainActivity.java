package com.rb.browser.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.CookieManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.rb.browser.R;
import com.rb.browser.utils.CommonUtils;

import cat.ereza.customactivityoncrash.config.CaocConfig;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!isWebviewEnabled()){
            CommonUtils.showToast(MainActivity.this, "Webview is required but not installed");
            finish();
        }

        CaocConfig.Builder.create()
                .backgroundMode(CaocConfig.BACKGROUND_MODE_SHOW_CUSTOM)
                .enabled(true)
                .showErrorDetails(true)
                .showRestartButton(true)
                .logErrorOnRestart(true)
                .trackActivities(true)
                .minTimeBetweenCrashesMs(2000)
                .restartActivity(MainActivity.class)
                .errorActivity(null)
                .apply();

        Intent openIntent = new Intent(MainActivity.this, BrowserActivity.class);

        Uri uri = null;
        openIntent.setData(uri);

        startActivity(openIntent);
    }

    public boolean isWebviewEnabled(){
        try{
            CookieManager.getInstance();
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
