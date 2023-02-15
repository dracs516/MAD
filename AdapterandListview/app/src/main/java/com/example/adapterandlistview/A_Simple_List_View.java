package com.example.adapterandlistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A_Simple_List_View extends AppCompatActivity {

    // Array of strings...
    ListView simpleList;
    AutoCompleteTextView atxt;
    Button btn;
    List<String> countryList = new ArrayList<>(Arrays.asList("India", "China", "Australia", "Portugal", "America", "NewZealand"));

    String suggestions[] = {"Nepal", "Netherlands", "Neverwhere", "Nigga"};

    @Override   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1_simple_list_view);

        simpleList = (ListView)findViewById(R.id.simpleListView);
        atxt = (AutoCompleteTextView) findViewById(R.id.atxt);
        btn = (Button) findViewById(R.id.btn);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_1_list_view_layout, R.id.textView, countryList);
        simpleList.setAdapter(arrayAdapter);

        ArrayAdapter<String> atxtAdapter = new ArrayAdapter<String>(this,R.layout.activity_1_auto_complete_text_view_layout,R.id.autotextView,suggestions);
        atxt.setThreshold(2);
        atxt.setAdapter(atxtAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countryList.contains(atxt.getText().toString())) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(A_Simple_List_View.this);
                    alert.setTitle("List");
                    alert.setMessage("Exists");
                    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(A_Simple_List_View.this, "OK", Toast.LENGTH_SHORT).show();
                            dialogInterface.cancel();
                        }
                    });
                    alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(A_Simple_List_View.this, "Cancel", Toast.LENGTH_SHORT).show();
                            dialogInterface.cancel();
                        }
                    });
                    alert.create();
                    alert.show();
                    Toast.makeText(A_Simple_List_View.this, "Already In List", Toast.LENGTH_SHORT).show();
                } else {
                    countryList.add(atxt.getText().toString());
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
