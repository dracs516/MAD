package com.example.see;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class D_Time_Picker_On_Edit_Text extends AppCompatActivity {
    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4_time_picker_on_edit_text);

        edt = findViewById(R.id.time);

        edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int min = cal.get(Calendar.MINUTE);

                TimePickerDialog tpd = new TimePickerDialog(D_Time_Picker_On_Edit_Text.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        String tt = (i>=12)? "pm" : "am";
                        edt.setText(i + " : " + i1 + " " + tt);
                    }
                }, hour, min, false);

                tpd.setTitle("Select bsdk");
                tpd.show();
            }
        });
    }
}
