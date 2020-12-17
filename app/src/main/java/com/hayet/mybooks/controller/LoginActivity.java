package com.hayet.mybooks.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        initView();




    }


    private void  initView(){
        btnLogin = (Button) findViewById(R.id.button_login);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginUser();
            }
        });

    }



    private void LoginUser(){
        SharedPreferences sharedPref = getSharedPreferences(Constants.MY_PREF,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(Constants.PREF_IS_CONNECT,true);
        editor.apply();
        startActivity(new Intent(LoginActivity.this, ListBooksActivity.class));
        finish();
    }
}