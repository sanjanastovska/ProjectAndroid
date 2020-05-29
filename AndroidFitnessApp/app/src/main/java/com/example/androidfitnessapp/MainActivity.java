package com.example.androidfitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnExercises, btnSetting, btnWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnExercises = (Button) findViewById(R.id.btnExercises);
        btnSetting = (Button) findViewById(R.id.btnSettings);
        btnWeb = (Button) findViewById(R.id.btnWeb);

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(MainActivity.this, Settings.class);
                startActivity(startIntent);
            }
        });


        btnExercises.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(MainActivity.this, ListExercises.class);
                startActivity(startIntent);
            }

        });


        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fitnessSite = "https://www.fitnessblender.com/";
                Uri webAddress = Uri.parse(fitnessSite);

                Intent gotoWeb = new Intent(Intent.ACTION_VIEW, webAddress);
                if(gotoWeb.resolveActivity(getPackageManager()) != null){
                    startActivity(gotoWeb);
                }


            }

        });

    }
}

