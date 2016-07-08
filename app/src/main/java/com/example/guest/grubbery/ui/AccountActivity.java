package com.example.guest.grubbery.ui;

import android.accounts.Account;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.grubbery.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.createButton) Button mCreateButton;
    @Bind(R.id.inputUsername) EditText mInputUsername;
    @Bind(R.id.inputPassword) EditText mInputPassword;
    @Bind(R.id.inputPassword2) EditText mInputPassword2;
    @Bind(R.id.inputPetName) EditText mInputPetName;
    @Bind(R.id.inputBreed) EditText mInputBreed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        ButterKnife.bind(this);

        mCreateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mCreateButton) {
            String username = mInputUsername.getText().toString();
            String password = mInputPassword.getText().toString();
            String password2 = mInputPassword2.getText().toString();
            String petname = mInputPetName.getText().toString();
            String breed = mInputBreed.getText().toString();

            Intent intent = new Intent(AccountActivity.this, ThankActivity.class);

            intent.putExtra("username", username);
            intent.putExtra("password", password);
            intent.putExtra("pasword2", password2);
            intent.putExtra("petname", petname);
            intent.putExtra("breed", breed);
            startActivity(intent);
        }
    }
}
