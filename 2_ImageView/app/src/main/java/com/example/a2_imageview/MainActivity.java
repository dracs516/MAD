package com.example.a2_imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    Button btn,sub;
    EditText edt;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img=findViewById(R.id.imageView);
        btn = findViewById(R.id.button);
        sub=findViewById(R.id.submit);
        edt=findViewById(R.id.edittext);
        txt=findViewById(R.id.textView);




        btn.setOnClickListener(new View.OnClickListener() {
            int count =0;
            @Override
            public void onClick(View view) {
                count++;
                if(count % 2==0)
                    img.setImageResource(R.drawable.random2);
                else
                    img.setImageResource(R.drawable.random1);

            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edt.getText().toString().equals("Abhay")){
                    txt.setText("Successfull attempt");
                    txt.setTextColor(Color.rgb(0,255,0));
                }
                else{
                    txt.setText("Try again");
                    txt.setTextColor(Color.rgb(255,0,0));
                }
            }
        });
    }
}