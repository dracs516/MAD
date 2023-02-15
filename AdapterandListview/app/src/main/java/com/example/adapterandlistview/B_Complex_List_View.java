package com.example.adapterandlistview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class B_Complex_List_View extends AppCompatActivity {
    String[] countries = new String[] {
            "Nepal",
            "Bhutan",
            "Bangladesh",
            "India",
            "Sri Lanka",
            "Maldives",
            "Pakistan",
            "Afghanistan"
    };

    int[] flags = new int[] {
            R.drawable.nepal,
            R.drawable.bhutan,
            R.drawable.bangladesh,
            R.drawable.india,
            R.drawable.srilanka,
            R.drawable.maldives,
            R.drawable.img,
            R.drawable.img_1
    };

    String[] currencies = new String[]{
            "Nepalese Rupees",
            "Bhutani Rupees",
            "Bangladeshi Taka",
            "Indian Rupee",
            "Sri Lankan Rupee",
            "Pakistani Rupee",
            "Maldivian Rupees",
            "Afghani",
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2_complex_list_view);

        List<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();

        for(int i = 0 ; i < 8 ; i++){
            HashMap<String,String> hm = new HashMap<String,String>();
            hm.put("name", "Country: "+countries[i]);
            hm.put("flag", Integer.toString(flags[i]));
            hm.put("currency", "Currency: " + currencies[i]);
            list.add(hm);
        }

        String[] from = {"flag", "currency", "name"};
        int[] to = {R.id.flag,  R.id.cur, R.id.txt};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), list,R.layout.activity_2_list_view_layout, from,to);
        ListView lv = findViewById(R.id.listview);

        lv.setAdapter(simpleAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                LinearLayout parent = (LinearLayout) view;
                LinearLayout child = (LinearLayout) parent.getChildAt(1);
                TextView countryN = (TextView) child.getChildAt(0);

                Toast.makeText(B_Complex_List_View.this, countryN.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
