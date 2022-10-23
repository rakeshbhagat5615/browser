package com.rb.browser.utils;

import android.content.Context;
import android.widget.Toast;

public class CommonUtils {

    public static void showToast(Context context, String text){
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
}
