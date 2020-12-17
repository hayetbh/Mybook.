package com.hayet.mybooks.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.hayet.mybooks.Constants;
import com.hayet.mybooks.R;
import com.hayet.mybooks.recyclerview.ListBooksActivity;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    Runnable runnable;
    ImageView imageMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageMain = findViewById(R.id.imageMain);
        imageMain.animate().alpha(4000).setDuration(0);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                openNextScreen();
                finish();
            }
        }, Constants.SPLASH_DELAY);

    }
    private void openNextScreen(){
        SharedPreferences sharedPref = getSharedPreferences(Constants.MY_PREF, Context.MODE_PRIVATE);
        boolean is_connected= sharedPref.getBoolean(Constants.PREF_IS_CONNECT,false);
        if(is_connected){
            startActivity(new Intent(MainActivity.this, ListBooksActivity.class));
        }
        else{
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }

    }
}