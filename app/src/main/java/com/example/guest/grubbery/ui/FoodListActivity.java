package com.example.guest.grubbery.ui;

import android.content.Intent;
import android.provider.ContactsContract;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayDeque;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FoodListActivity extends AppCompatActivity {
    private DatabaseReference mFoodReference;
    private Query mFoodQuery;
    private FirebaseRecyclerAdapter mFirebaseAdapter;
    private String dogOrCat;
    private String mBrand;
    private String mType;
    private String mWith;
    private String mWithout;
    private String mAge;



    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    ArrayList<Food> mFoods = new ArrayList<>();
    ArrayList<Food> queryFoods = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_results);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        dogOrCat = intent.getStringExtra("dogOrCat");
        mBrand = intent.getStringExtra("brand");
        mType = intent.getStringExtra("type");
        mWith = intent.getStringExtra("with");
        mWithout = intent.getStringExtra("without");
        mAge = intent.getStringExtra("age");

        mFoodReference = FirebaseDatabase.getInstance().getReference(dogOrCat);

        mFoodReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Food newFood = ds.getValue(Food.class);
                    mFoods.add(newFood);
                    queryFoods.add(newFood);
                    Log.d("CUBONE", "brand: " + newFood.getBrand());
                    Log.d("CUBONE", "name: " + newFood.getName());
                    Log.d("CUBONE", "ingredients: " + newFood.getIngredients());

                    if (!mBrand.isEmpty()) {
                        Log.d("CUBONE", "got into brand");
                        if (!(newFood.getName().equals(mBrand))) {
                            queryFoods.remove(newFood);
                        }
                    }

                    if (!mWith.isEmpty()) {
                        Log.d("CUBONE", "got into with");
                        if (!(newFood.getIngredients().contains(mWith))) {
                            queryFoods.remove(newFood);
                        }
                    }

                    if (!mWithout.isEmpty()) {
                        Log.d("CUBONE", "got into without");
                        if (newFood.getIngredients().contains(mWithout)) {
                            queryFoods.remove(newFood);
                        }
                    }
                }
                Log.d("CUBONE", queryFoods.size() + "");
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //Log.d("CUBONE", "queryFoods: " + queryFoods.size());
    }


//    public void setUpFirebaseAdapter() {
//        mFirebaseAdapter = new FirebaseRecyclerAdapter<Food, FirebaseFoodViewHolder>
//                (Food.class, R.layout.food_list_item, FirebaseFoodViewHolder.class, mFoodReference) {
//
//
//
//            @Override
//            protected void populateViewHolder(FirebaseFoodViewHolder viewHolder, Food model, int position) {
//                viewHolder.bindFood(model);
//
//            }
//        };
//        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setAdapter(mFirebaseAdapter);
//    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mFirebaseAdapter.cleanup();
//    }
}
