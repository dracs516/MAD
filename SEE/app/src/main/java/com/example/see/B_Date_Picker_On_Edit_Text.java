package com.example.see;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class B_Date_Picker_On_Edit_Text extends AppCompatActivity {
    EditText edt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2_date_picker_on_edit_text);

        edt = findViewById(R.id.edt);
        edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cal = Calendar.getInstance();

                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(B_Date_Picker_On_Edit_Text.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        edt.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                },
                        year, month, day);
                datePickerDialog.show();
            }
        });
    }
}
