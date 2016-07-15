package com.example.guest.grubbery.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.grubbery.Constants;
import com.example.guest.grubbery.R;
import com.example.guest.grubbery.models.Food;
import com.example.guest.grubbery.ui.FoodDetailActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FirebaseFoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    View mView;
    Context mContext;

    public FirebaseFoodViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindFood(Food food) {
        TextView nameTextView = (TextView) mView.findViewById(R.id.foodNameTextView);
        TextView brandTextView = (TextView) mView.findViewById(R.id.brandTextView);
        TextView ingredientsTextView = (TextView) mView.findViewById(R.id.ingredientsTextView);

        nameTextView.setText(food.getName());
        brandTextView.setText(food.getBrand());
    }

    @Override
    public void onClick(View view) {
        final ArrayList<Food> foods = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_DOG_FOODS);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    foods.add(snapshot.getValue(Food.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, FoodDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("foods", Parcels.wrap(foods));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
