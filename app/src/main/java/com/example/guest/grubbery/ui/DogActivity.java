package com.example.guest.grubbery.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.guest.grubbery.Constants;
import com.example.guest.grubbery.R;
import com.example.guest.grubbery.models.Food;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DogActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.searchButton) Button mSearchButton;
    @Bind(R.id.brandSelect) EditText mBrandSelect;
    @Bind(R.id.typeSelect) Spinner mTypeSelect;
    @Bind(R.id.withSelect) EditText mWithSelect;
    @Bind(R.id.withoutSelect) EditText mWithoutSelect;
    @Bind(R.id.ageSelect) Spinner mAgeSelect;
    @Bind(R.id.grainCheck) CheckBox mGrainCheck;
    @Bind(R.id.smallCheck) CheckBox mSmallCheck;
    @Bind(R.id.largeCheck) CheckBox mLargeCheck;
    private Spinner typeSelect;
    private Spinner ageSelect;
    ArrayList<Food> mFoods = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        ButterKnife.bind(this);

        mSearchButton.setOnClickListener(this);

        Spinner typeSpinner = (Spinner) findViewById(R.id.typeSelect);
        ArrayAdapter<CharSequence> typeAdapter = ArrayAdapter.createFromResource(this, R.array.types_array, android.R.layout.simple_spinner_item);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setPrompt("Type:");
        typeSpinner.setAdapter(typeAdapter);

        Spinner ageSpinner = (Spinner) findViewById(R.id.ageSelect);
        ArrayAdapter<CharSequence> ageAdapter = ArrayAdapter.createFromResource(this, R.array.dog_age_array, android.R.layout.simple_spinner_item);
        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ageSpinner.setPrompt("Age/Style:");
        ageSpinner.setAdapter(ageAdapter);
    }

    @Override
    public void onClick(View view) {
        if(view == mSearchButton) {
            boolean mGrain = mGrainCheck.isChecked();
            boolean mSmall = mSmallCheck.isChecked();
            boolean mLarge = mLargeCheck.isChecked();
            String mBrand = mBrandSelect.getText().toString().trim();
            String mType = mTypeSelect.getSelectedItem().toString();
            String mWith = mWithSelect.getText().toString().trim();
            String mWithout = mWithoutSelect.getText().toString().trim();
            String mAge = mAgeSelect.getSelectedItem().toString();

            Intent intent = new Intent(DogActivity.this, FoodListActivity.class);
            intent.putExtra("dogOrCat", Constants.FIREBASE_CHILD_DOG_FOODS);
            intent.putExtra("brand", mBrand);
            intent.putExtra("type", mType);
            intent.putExtra("with", mWith);
            intent.putExtra("without", mWithout);
            intent.putExtra("age", mAge);
            intent.putExtra("grain", mGrain);
            intent.putExtra("small", mSmall);
            intent.putExtra("large", mLarge);
            startActivity(intent);
        }
    }
}
