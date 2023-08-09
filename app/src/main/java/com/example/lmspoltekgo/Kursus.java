package com.example.lmspoltekgo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class Kursus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kursus);

        Intent intent = getIntent();
        String token = intent.getStringExtra("token");
        String username = intent.getStringExtra("username");

        Log.d("KursusActivity", "Token: " + token);
        Log.d("KursusActivity", "Username: " + username);
    }
}