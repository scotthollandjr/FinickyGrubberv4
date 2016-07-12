package com.example.guest.grubbery.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.guest.grubbery.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DogActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.searchButton) Button mSearchButton;

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
            Intent intent = new Intent(DogActivity.this, FoodListActivity.class);
            startActivity(intent);
        }
    }
}
