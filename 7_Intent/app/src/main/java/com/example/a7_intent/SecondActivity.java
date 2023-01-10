package com.example.a7_intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    Button sbtn;
    TextView stxt, stxt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        sbtn = findViewById(R.id.sbtn);
        stxt = findViewById(R.id.stext);
        stxt2 = (TextView) findViewById(R.id.stext23);


        Bundle txtval = getIntent().getExtras();
        String val1 = (String) txtval.getString("textmsg");
        stxt2.setText(val1);

        sbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
