package com.example.see;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class A_Date_Picker_Spinner_Toast extends AppCompatActivity {

    DatePicker date;
    Button btn;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1_date_picker_spinner_toast);


        date = findViewById(R.id.date);
        btn = findViewById(R.id.btn);
        text = findViewById(R.id.text);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("Selected Date: " + getDate());
                Toast.makeText(A_Date_Picker_Spinner_Toast.this,text.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }


    public String getDate() {
        StringBuilder builder = new StringBuilder();
        builder.append(date.getDayOfMonth());
        builder.append("/");
        builder.append(date.getMonth() + 1);
        builder.append("/");
        builder.append(date.getYear());

        return builder.toString();
    }
}