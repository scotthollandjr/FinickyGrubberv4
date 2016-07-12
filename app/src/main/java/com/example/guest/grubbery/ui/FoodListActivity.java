package com.example.guest.grubbery.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.guest.grubbery.R;
import com.example.guest.grubbery.adapters.FoodListAdapter;
import com.example.guest.grubbery.models.Food;

import java.util.ArrayDeque;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FoodListActivity extends AppCompatActivity {
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private FoodListAdapter mAdapter;

    public ArrayList<Food> mFoods = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        getFoods();
    }

    private void getFoods() {
        Food a = new Food("Chicken and Rice", "Fromm");
        Food b = new Food("Venison and Sweet Potato", "Stella & Chewy's");
        Food c = new Food("Hundenflockken", "Solid Gold");
        Food d = new Food("Indigo Moon", "Solid Gold");
        Food e = new Food("Corn, Giblets and Rice", "Purina");
        mFoods.add(a);
        mFoods.add(b);
        mFoods.add(c);
        mFoods.add(d);
        mFoods.add(e);

        FoodListActivity.this.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                mAdapter = new FoodListAdapter(getApplicationContext(), mFoods);
                mRecyclerView.setAdapter(mAdapter);
                RecyclerView.LayoutManager layoutManager =
                        new LinearLayoutManager(FoodListActivity.this);
                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setHasFixedSize(true);

            }
        });
    }
}
