package com.example.guest.grubbery.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.grubbery.Constants;
import com.example.guest.grubbery.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DogActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.searchButton) Button mSearchButton;
    @Bind(R.id.brandSelect) EditText mBrandSelect;
    @Bind(R.id.typeSelect) EditText mTypeSelect;
    @Bind(R.id.withSelect) EditText mWithSelect;
    @Bind(R.id.withoutSelect) EditText mWithoutSelect;
    @Bind(R.id.ageSelect) EditText mAgeSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);
        ButterKnife.bind(this);

        mSearchButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mSearchButton) {
            String mBrand = mBrandSelect.getText().toString().trim();
            String mType = mTypeSelect.getText().toString().trim();
            String mWith = mWithSelect.getText().toString().trim();
            String mWithout = mWithoutSelect.getText().toString().trim();
            String mAge = mAgeSelect.getText().toString().trim();

            Intent intent = new Intent(DogActivity.this, FoodListActivity.class);
            intent.putExtra("dogOrCat", Constants.FIREBASE_CHILD_DOG_FOODS);
            intent.putExtra("brand", mBrand);
            intent.putExtra("type", mType);
            intent.putExtra("with", mWith);
            intent.putExtra("without", mWithout);
            intent.putExtra("age", mAge);
            startActivity(intent);
        }
    }
}
