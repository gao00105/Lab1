package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imgView;
    Switch sw;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
    String emailAddress = prefs.getString("LoginName", "");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginButton = findViewById(R.id.login);
        loginButton.setOnClickListener(clk -> {
            Intent nextPage = new Intent(MainActivity.this, SecondActivity.class);
            EditText email_address = findViewById(R.id.email_address);
            String message = email_address.getText().toString();
            nextPage.putExtra("EmailAddress", message);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("LoginName", message);
            editor.apply();
            startActivity(nextPage);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}