package com.example.cieiimenus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout clayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clayout = findViewById(R.id.clayout);
        TextView textView = findViewById(R.id.text_view);
        registerForContextMenu(textView);
    }

    public void showpopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.inflate(R.menu.popup);
        popup.show();
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item1:
                        Toast.makeText(getApplicationContext(), "option1 selected", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.item2:
                        Toast.makeText(getApplicationContext(), "option2 selected", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
//                        return super.onContextItemSelected(item);
                }
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose an option");
        getMenuInflater().inflate(R.menu.context, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option1:
                display("option 1");
                return true;
            case R.id.option2:
                display("option 2");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    void display(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.red:
                clayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.blue:
                clayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.green:
                clayout.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.yellow:
                clayout.setBackgroundColor(Color.YELLOW);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
