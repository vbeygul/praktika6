package com.mirea.vbeygul.notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private String fileName;

    private EditText text;
    private EditText name;
    private SharedPreferences mSettings;
    public static final String APP_PREFERENCES = "SETTINGS";
    public static String APP_PREFERENCES_NAME = "NAME";
    public static String APP_PREFERENCES_TEXT = "TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        text = findViewById(R.id.text);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        try {
            String nameText = "";
            if(mSettings.contains(APP_PREFERENCES_NAME)) {
                name.setText(mSettings.getString(APP_PREFERENCES_NAME, "DEFAULT"));
            }
            if(mSettings.contains(APP_PREFERENCES_TEXT)) {
                text.setText(mSettings.getString(APP_PREFERENCES_TEXT, "DEFAULT"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClick(View view) {
        String strName = name.getText().toString();
        String strText = text.getText().toString();
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_NAME, strName);
        editor.putString(APP_PREFERENCES_TEXT, strText);
        editor.apply();

        Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show(); }
}