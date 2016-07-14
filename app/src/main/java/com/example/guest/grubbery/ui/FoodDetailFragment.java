package com.example.guest.grubbery.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.guest.grubbery.R;
import com.example.guest.grubbery.models.Food;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodDetailFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.foodNameTextView) TextView mFoodNameLabel;
    @Bind(R.id.brandTextView) TextView mBrandLabel;
    @Bind(R.id.lookUpText) EditText mLookUpLabel;
    @Bind(R.id.defineButton) Button mDefineButton;

    private Food mFood;

    public static FoodDetailFragment newInstance(Food food) {
        FoodDetailFragment foodDetailFragment = new FoodDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("food", Parcels.wrap(food));
        foodDetailFragment.setArguments(args);
        return foodDetailFragment;
    }

    public FoodDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFood = Parcels.unwrap(getArguments().getParcelable("food"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_detail, container, false);
        ButterKnife.bind(this, view);

        mDefineButton.setOnClickListener(this);

        mFoodNameLabel.setText(mFood.getName());
        mBrandLabel.setText(mFood.getBrand());

        return view;
    }

    @Override
    public void onClick(View view) {
        if(view == mDefineButton) {
            String word = mLookUpLabel.getText().toString();
            Intent intent = new Intent(getActivity(), DictionaryActivity.class);
            intent.putExtra("word", word);
            startActivity(intent);
        }
    }
}
