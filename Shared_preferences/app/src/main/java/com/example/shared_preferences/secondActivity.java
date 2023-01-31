package com.example.shared_preferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class secondActivity extends AppCompatActivity {
    SharedPreferences newPreference;
    Intent newIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        TextView result = findViewById(R.id.res_text);
        Button LogOut_btn = findViewById(R.id.LogOut);
        newPreference = getSharedPreferences("details", MODE_PRIVATE);
        newIntent = new Intent(secondActivity.this, MainActivity.class);
        Log.e("asdf",newPreference.getString("uss","asdf"));
        result.setText("Welcome, " + newPreference.getString("uss",null));
        LogOut_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor edit = newPreference.edit();
                edit.clear();
                edit.commit();
                startActivity(newIntent);
            }
        });
    }
}
