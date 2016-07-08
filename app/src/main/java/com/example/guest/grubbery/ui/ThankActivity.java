package com.example.guest.grubbery.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.guest.grubbery.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ThankActivity extends AppCompatActivity {
    @Bind(R.id.thanksText) TextView mThanksText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        mThanksText.setText("Thank you, " + username + ". Your account has been created.");
    }
}
