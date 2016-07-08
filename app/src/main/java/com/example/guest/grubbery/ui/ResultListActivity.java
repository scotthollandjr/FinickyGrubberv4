package com.example.guest.grubbery.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.guest.grubbery.R;

public class ResultListActivity extends AppCompatActivity {
    private ListView mListView;
    private String[] foods = new String[] {"Beef Frittata Veg", "Chicken A La Veg", "Duck & Sweet Potato", "Game Bird", "Hasen Duckenpfeffer", "Lamb & Lentil", "Pork & Applesauce", "Pork & Peas", "Salmon A La Veg", "Salmon Tunalini", "Surf & Turf", "Whitefish & Potato"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mListView = (ListView) findViewById(R.id.listView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, foods);
        mListView.setAdapter(adapter);
    }
}
