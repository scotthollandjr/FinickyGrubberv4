package com.example.guest.grubbery.ui;

import android.accounts.Account;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
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
import com.google.firebase.auth.FirebaseUser;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.createButton) Button mCreateButton;
    @Bind(R.id.inputEmail) EditText mInputEmail;
    @Bind(R.id.inputUsername) EditText mInputUsername;
    @Bind(R.id.inputPassword) EditText mInputPassword;
    @Bind(R.id.inputPassword2) EditText mInputPassword2;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ProgressDialog mAuthProgressDialog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        ButterKnife.bind(this);

        mCreateButton.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();

        createAuthStateListener();
        createAuthProgressDialog();
    }

    private void createAuthProgressDialog() {
        mAuthProgressDialog = new ProgressDialog(this);
        mAuthProgressDialog.setTitle("Loading...");
        mAuthProgressDialog.setMessage("Authenticating with Firebase...");
        mAuthProgressDialog.setCancelable(false);
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

        boolean validEmail = isValidEmail(email);
        boolean validName = isValidName(username);
        boolean validPassword = isValidPassword(password, password2);
        if (!validEmail || !validName || !validPassword) return;

        mAuthProgressDialog.show();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                   @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                       mAuthProgressDialog.dismiss();

                       if (task.isSuccessful()) {

                       } else {
                           Toast.makeText(AccountActivity.this, "Authentication failed.",
                                   Toast.LENGTH_SHORT).show();
                       }
                   }
                });
    }

    private void createAuthStateListener() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(AccountActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private boolean isValidEmail(String email) {
        boolean isGoodEmail = (email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        if (!isGoodEmail) {
            mInputEmail.setError("Please ensuter a valid email address");
            return false;
        }
        return isGoodEmail;
    }

    private boolean isValidName(String name) {
        if (name.equals("")) {
            mInputUsername.setError("Please enter a username");
            return false;
        }
        return true;
    }

    private boolean isValidPassword(String password, String password2) {
        if (password.length() < 6) {
            mInputPassword.setError("Please create a password containing at least 6 characters");
            return false;
        } else if (!password.equals(password2)) {
            mInputPassword.setError("Passwords do not match");
            return false;
        }
        return true;
    }
}