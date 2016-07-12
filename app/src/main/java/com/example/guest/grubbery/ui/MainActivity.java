package com.example.guest.grubbery.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.BinderThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.guest.grubbery.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;
    @Bind(R.id.dogButton) Button mDogButton;
    @Bind(R.id.catButton) Button mCatButton;
    @Bind(R.id.accountButton) Button mAccountButton;

    @Bind(R.id.definitionButton) Button mDefinitionButton;
    @Bind(R.id.definitionText) EditText mDefinitionText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);
        Typeface comfortaaFont = Typeface.createFromAsset(getAssets(), "fonts/comfortaa.ttf");
        mAppNameTextView.setTypeface(comfortaaFont);

        mDogButton.setOnClickListener(this);
        mCatButton.setOnClickListener(this);
        mAccountButton.setOnClickListener(this);
        mDefinitionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mDogButton) {
            Intent intent = new Intent(MainActivity.this, DogActivity.class);
            startActivity(intent);
        }
        if(view == mCatButton) {
            Intent intent = new Intent(MainActivity.this, CatActivity.class);
            startActivity(intent);
        }
        if(view == mAccountButton) {
            Intent intent = new Intent(MainActivity.this, AccountActivity.class);
            startActivity(intent);
        }
    }
}
