package com.example.shared_preferences;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity extends AppCompatActivity {
    ListView list;
    String books[] = {"Science","Math","Social","Chemistry","English"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        list = findViewById(R.id.listview);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.books, R.id.textView,books);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = arrayAdapter.getItem((i));
                Toast.makeText(Activity.this,   "value", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
