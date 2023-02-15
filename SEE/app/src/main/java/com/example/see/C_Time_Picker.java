package com.example.see;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class C_Time_Picker extends AppCompatActivity {
    TextView txt;
    TimePicker time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3_time_picker);

        txt = findViewById(R.id.txt);
        time = findViewById(R.id.time);
        time.setIs24HourView(true);

        time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener(){
            @Override
            public void onTimeChanged(TimePicker view, int hour, int minute){
                String tt = (hour>=12)? "pm" : "am";
                txt.setText(hour + " : " + minute + " " + tt);
                Toast.makeText(C_Time_Picker.this, txt.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
