package com.rb.browser.activities;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.rb.browser.Browser;
import com.rb.browser.R;
import com.rb.browser.database.SettingsKeys;
import com.rb.browser.utils.SettingsUtils;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {

    SharedPreferences pref;
    ListView lvSettings;
    List<String> lvItems = new ArrayList<>();
    ArrayAdapter adapter;

    String[] themes = {"System default", "Light", "Dark"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        pref = ((Browser) getApplicationContext()).pref;
        initiateListView();
    }

    private void initiateListView() {
        lvSettings = findViewById(R.id.activity_settings_list_view);

        lvItems.add("Search Engine");
        lvItems.add("HomePage");
        lvItems.add("Theme");

        adapter = new ArrayAdapter(SettingsActivity.this, android.R.layout.simple_list_item_1, lvItems);

        lvSettings.setAdapter(adapter);
        lvSettings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 2:
                        int[] checkedTheme = {SettingsUtils.getPrefNum(pref, SettingsKeys.theme_id)};
                        new MaterialAlertDialogBuilder(SettingsActivity.this).setTitle("Select theme")
                                .setSingleChoiceItems(themes, SettingsUtils.getPrefNum(pref, SettingsKeys.theme_id), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        checkedTheme[0] = i;
                                    }
                                })
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        SettingsUtils.setPrefNum(pref, SettingsKeys.theme_id, checkedTheme[0]);
                                    }
                                })
                                .setNegativeButton("Cancel", null)
                                .create().show();
                }
            }
        });
    }
}
