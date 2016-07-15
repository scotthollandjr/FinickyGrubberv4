package com.example.guest.grubbery.ui;

import android.accounts.Account;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guest.grubbery.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.createButton) Button mCreateButton;
    @Bind(R.id.inputEmail) EditText mInputEmail;
    @Bind(R.id.inputUsername) EditText mInputUsername;
    @Bind(R.id.inputPassword) EditText mInputPassword;
    @Bind(R.id.inputPassword2) EditText mInputPassword2;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        ButterKnife.bind(this);

        mCreateButton.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View view) {
        if (view == mCreateButton) {
            createNewUser();
        }
    }

    private void createNewUser() {
        final String email = mInputEmail.getText().toString().trim();
        final String password = mInputPassword.getText().toString().trim();
        String username = mInputUsername.getText().toString().trim();
        String password2 = mInputPassword2.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                   @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()) {
                           Log.d("CUBONE", "Authentication successful");
                       } else {
                           Toast.makeText(AccountActivity.this, "Authentication failed.",
                                   Toast.LENGTH_SHORT).show();
                       }
                   }
                });
    }
}


//
//    Intent intent = new Intent(AccountActivity.this, ThankActivity.class);
//
//intent.putExtra("username", username);
//        intent.putExtra("password", password);
//        intent.putExtra("pasword2", password2);
//        intent.putExtra("petname", petname);
//        intent.putExtra("breed", breed);
//        startActivity(intent);
