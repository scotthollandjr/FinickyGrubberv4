package com.example.guest.grubbery.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.guest.grubbery.Constants;
import com.example.guest.grubbery.R;
import com.example.guest.grubbery.adapters.FirebaseFoodViewHolder;
import com.example.guest.grubbery.adapters.FoodListAdapter;
import com.example.guest.grubbery.models.Food;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayDeque;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FoodListActivity extends AppCompatActivity {
    private DatabaseReference mFoodReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_results);
        ButterKnife.bind(this);

        mFoodReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_DOG_FOODS);
        setUpFirebaseAdapter();
    }

    public void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Food, FirebaseFoodViewHolder>
                (Food.class, R.layout.food_list_item, FirebaseFoodViewHolder.class, mFoodReference) {

            @Override
            protected void populateViewHolder(FirebaseFoodViewHolder viewHolder, Food model, int position) {
                viewHolder.bindRestaurant(model);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }

//    private void getFoods() {
////        String[] ingredients = {"salmon", "chicken", "oats", "peas", "lamb", "brown rice", "turtle flesh", "pea fiber", "egg", "salmon meal", "canola oil", "cranberries", "vitamins", "minerals"};
////        Food a = new Food("Chicken and Rice", "Fromm", ingredients);
////        Food b = new Food("Venison and Sweet Potato", "Stella & Chewy's", ingredients);
////        Food c = new Food("Hundenflockken", "Solid Gold", ingredients);
////        Food d = new Food("Indigo Moon", "Solid Gold", ingredients);
////        Food e = new Food("Corn, Giblets and Rice", "Purina", ingredients);
////        mFoods.add(a);
////        mFoods.add(b);
////        mFoods.add(c);
////        mFoods.add(d);
////        mFoods.add(e);
//
//        FoodListActivity.this.runOnUiThread(new Runnable() {
//
//            @Override
//            public void run() {
//                mAdapter = new FoodListAdapter(getApplicationContext(), mFoods);
//                mRecyclerView.setAdapter(mAdapter);
//                RecyclerView.LayoutManager layoutManager =
//                        new LinearLayoutManager(FoodListActivity.this);
//                mRecyclerView.setLayoutManager(layoutManager);
//                mRecyclerView.setHasFixedSize(true);
//            }
//        });
//    }
}
