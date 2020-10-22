package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
        ImageView logo;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo = (ImageView)findViewById(R.id.logo);
        logo.animate().rotation(3600f).setDuration(3000);
        }

public void register(View view) {
        Intent intent = new Intent(getApplicationContext(),registerActivity.class);
        startActivity(intent);

        }

public void login(View view) {
        Intent intent = new Intent(getApplicationContext(),loginActivity.class);
        startActivity(intent);
        }
        }