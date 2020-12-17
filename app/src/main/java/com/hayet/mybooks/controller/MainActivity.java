package com.hayet.mybooks.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.hayet.mybooks.Constants;
import com.hayet.mybooks.R;

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
                startActivity(new Intent(MainActivity.this, LoginActivity.class));

                finish();
            }
        }, Constants.SPLASH_DELAY);

    }
}