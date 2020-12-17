package com.hayet.mybooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
Button btnLogin;
EditText email, password;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = (Button) findViewById(R.id.button_login);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailvalue = email.getText().toString();
                String passvalue = password.getText().toString();
                if (emailvalue.isEmpty() && passvalue.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "empty", Toast.LENGTH_SHORT).show();
                } else {
                    sharedPreferences = getSharedPreferences(Constants.MY_PREF, Context.MODE_PRIVATE);
                    final String emailshared = sharedPreferences.getString(Constants.KEY_EMAIL, null);
                    final String passshared = sharedPreferences.getString(Constants.KEY_PASSWORD, null);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(Constants.KEY_EMAIL, emailvalue);
                    editor.putString(Constants.KEY_PASSWORD, passvalue);
                    editor.apply();
                    ;
                    Toast.makeText(LoginActivity.this, "success", Toast.LENGTH_LONG).show();
                    openNextActivity();
                }
            }
                private void openNextActivity() {

                    Intent intent = new Intent(LoginActivity.this, ListBooksActivity.class);
                    startActivity(intent);
                }

        });
    }
}