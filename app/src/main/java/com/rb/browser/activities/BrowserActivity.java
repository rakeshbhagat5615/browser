package com.rb.browser.activities;

import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.rb.browser.R;
import com.rb.browser.utils.ColorUtils;
import com.rb.browser.webview.BrowserWebview;

public class BrowserActivity extends AppCompatActivity {

    AppCompatImageView ivHome, ivFavIcon, ivOptions;
    AppCompatAutoCompleteTextView etSearch;
    RelativeLayout rlSearch;
    ProgressBar pbWebview;
    SwipeRefreshLayout srlWebview;
    BrowserWebview webview;
    String colorBase, colorOpacity, colorStatusBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(checkDarkThemeElseLight()){
            //dark
            colorBase = ColorUtils.darkBase;
            colorOpacity = ColorUtils.darkOpacityBase;
            colorStatusBar = ColorUtils.darkStatusBar;
        }else{
            //light
            colorBase = ColorUtils.lightBase;
            colorOpacity = ColorUtils.lightOpacityBase;
            colorStatusBar = ColorUtils.lightStatusBar;
        }

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor(colorStatusBar));
        
        initiateViews();



    }

    private void initiateViews() {
        ivHome = findViewById(R.id.activity_main_search_bar_home_iv);
        ivFavIcon = findViewById(R.id.activity_main_search_bar_fav_icon_iv);
        ivOptions = findViewById(R.id.activity_main_search_bar_options_iv);
        etSearch = findViewById(R.id.activity_main_search_bar_url_et);
        rlSearch = findViewById(R.id.activity_main_search_bar_et_container);
        pbWebview = findViewById(R.id.activity_main_webview_pb);
        srlWebview = findViewById(R.id.activity_main_webview_srl);
        webview = findViewById(R.id.activity_main_webview);

        ivHome.setColorFilter(Color.parseColor(colorBase), PorterDuff.Mode.SRC_IN);
        ivFavIcon.setColorFilter(Color.parseColor(colorBase), PorterDuff.Mode.SRC_IN);
        ivOptions.setColorFilter(Color.parseColor(colorBase), PorterDuff.Mode.SRC_IN);
        etSearch.setTextColor(Color.parseColor(colorBase));
        etSearch.setHintTextColor(Color.parseColor(colorBase));
        rlSearch.getBackground().setColorFilter(Color.parseColor(colorOpacity), PorterDuff.Mode.SRC_ATOP);
        pbWebview.getProgressDrawable().setColorFilter(Color.parseColor(colorBase), PorterDuff.Mode.SRC_IN);



    }

    public boolean checkDarkThemeElseLight(){
        return (getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES;
    }
}
