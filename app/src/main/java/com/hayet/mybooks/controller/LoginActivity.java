package com.hayet.mybooks.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hayet.mybooks.Constants;
import com.hayet.mybooks.R;
import com.hayet.mybooks.recyclerview.ListBooksActivity;

public class LoginActivity extends AppCompatActivity {

Button btnLogin;
EditText email, password;
    boolean  isEmailValid, isPasswordValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

    }

    private void  initView(){
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.button_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetValidation();
            }
        });

    }

    //validation Email and password
    public void SetValidation() {

        // Check for a valid email address.
        if (email.getText().toString().isEmpty()) {
            email.setError(getResources().getString(R.string.email_error));
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
            email.setError(getResources().getString(R.string.error_invalid_email));
            isEmailValid = false;
        } else {
            isEmailValid = true;
        }

        // Check for a valid password.
        if (password.getText().toString().isEmpty()) {
            password.setError(getResources().getString(R.string.password_error));
            isPasswordValid = false;
        } else if (password.getText().length() < 6) {
            password.setError(getResources().getString(R.string.error_invalid_password));
            isPasswordValid = false;
        } else {
            isPasswordValid = true;
        }

        if (isEmailValid && isPasswordValid) {
            LoginUser();
        }
    }
    //Shared prefrences
    private void LoginUser(){
        SharedPreferences sharedPref = getSharedPreferences(Constants.MY_PREF,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(Constants.PREF_IS_CONNECT,true);
        editor.apply();
        Toast.makeText(getApplicationContext(), "Successfull Login", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(LoginActivity.this, ListBooksActivity.class));
        finish();
    }
    }