package com.example.a5_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox c1, c2, c3, custom;
    TextView t;
    Button btn,radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1 = findViewById(R.id.option1);
        c2 = findViewById(R.id.option2);
        c3 = findViewById(R.id.option3);
        t = findViewById(R.id.menu);
        btn = findViewById(R.id.btn);
        custom = findViewById(R.id.custom);
        radio=findViewById(R.id.radio1);
        
        radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Radio", Toast.LENGTH_SHORT).show();
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            int count = 0;

            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Niyati", Toast.LENGTH_SHORT).show();
                count++;
                if (count % 2 != 0) {
                    btn.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.empty, 0);
                } else {
                    btn.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.full, 0);
                }
            }
        });

    }
//
//    public void checkBoxed(View v) {
//        if (custom.isChecked()) {
//            custom.setButtonDrawable(R.drawable.checkbox_gradient);
//        }
//        else{
//            custom.setButtonDrawable(R.drawable.checkbox);
//        }
//    }

    public void checkBox(View v) {
        StringBuilder str = new StringBuilder();
        str.append("Order: \n");
        float total = 0;
        if (c1.isChecked()) {
            str.append("Coffee: 50\n");
            total += 50;
            c1.setButtonDrawable(R.drawable.minus);
        } else {
            c1.setButtonDrawable(R.drawable.add);
        }
        if (c2.isChecked()) {
            str.append("Tea: 30\n");
            total += 30;
            c2.setButtonDrawable(R.drawable.minus);
        } else {
            c2.setButtonDrawable(R.drawable.add);
        }
        if (c3.isChecked()) {
            str.append("Churot: 20\n");
            total += 20;
            c3.setButtonDrawable(R.drawable.minus);
        } else {
            c3.setButtonDrawable(R.drawable.add);
        }
        str.append("Total: " + total);
        t.setText(str);

    }


//    public void hourGlass(View v){
//        int count =0;
//        if(count % 2 == 0){
//            btn.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.empty,0);
//            count++;
//        }else{
//            btn.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.full,0);
//            count++;
//        }
//    }
}