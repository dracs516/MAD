package com.example.a5_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox c1,c2,c3;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1=findViewById(R.id.option1);
        c2=findViewById(R.id.option2);
        c3=findViewById(R.id.option3);
        t=findViewById(R.id.menu);
        
    }
    
    public void checkBox(View v){
        StringBuilder str = new StringBuilder();
        str.append("Menu: \n");
        float total = 0;
        if(c1.isChecked()){
            str.append("Coffee: 50\n");
            total+=50;
            c1.setButtonDrawable(R.drawable.minus);
        } else{
            c1.setButtonDrawable(R.drawable.add);
        }
        if(c2.isChecked()){
            str.append("Tea: 30\n");
            total+=30;
            c2.setButtonDrawable(R.drawable.minus);
        } else{
            c2.setButtonDrawable(R.drawable.add);
        }
        if(c3.isChecked()){
            str.append("Churot: 20\n");
            total+=20;
            c3.setButtonDrawable(R.drawable.minus);
        } else{
            c3.setButtonDrawable(R.drawable.add);
        }
        str.append("Total: "+total);
        t.setText(str);
        
    }
}