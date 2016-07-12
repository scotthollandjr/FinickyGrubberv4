package com.example.guest.grubbery.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guest.grubbery.R;
import com.example.guest.grubbery.models.Food;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 7/11/16.
 */
public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodViewHolder> {
    private ArrayList<Food> mFoods = new ArrayList<>();
    private Context mContext;

    public FoodListAdapter(Context context, ArrayList<Food> foods) {
        mContext = context;
        mFoods = foods;
    }

    @Override
    public FoodListAdapter.FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_list_item, parent, false);
        FoodViewHolder viewHolder = new FoodViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FoodListAdapter.FoodViewHolder holder, int position) {
        holder.bindFood(mFoods.get(position));
    }

    @Override
    public int getItemCount() {
        return mFoods.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.foodNameTextView) TextView mFoodNameTextView;
        @Bind(R.id.brandTextView) TextView mBrandTextView;
        @Bind(R.id.ingredientsTextView) TextView mIngredientsTextView;

        private Context mContext;

        public FoodViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindFood(Food food) {
            mFoodNameTextView.setText(food.getName());
            mBrandTextView.setText(food.getName());
            //mIngredientsTextView.setText(food.getIngredients());
        }
    }
}
