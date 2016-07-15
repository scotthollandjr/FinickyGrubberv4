package com.example.guest.grubbery.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.BinderThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.guest.grubbery.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;
    @Bind(R.id.dogButton) Button mDogButton;
    @Bind(R.id.catButton) Button mCatButton;
    @Bind(R.id.accountButton) Button mAccountButton;

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        if (id == R.id.action_login) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_account) {
            Intent intent = new Intent(MainActivity.this, AccountActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
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
            Intent intent = new Intent(MainActivity.this, UserAccountActivity.class);
            startActivity(intent);
        }
    }
}
