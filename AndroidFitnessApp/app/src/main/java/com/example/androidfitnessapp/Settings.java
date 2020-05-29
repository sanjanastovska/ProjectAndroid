package com.example.androidfitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.androidfitnessapp.Databases.FitnessDB;

public class Settings extends AppCompatActivity {

    Button btnSave;
    RadioButton rdiEasy, rdiMedium,rdiHard;
    RadioGroup rdiGroup;
    FitnessDB fitnessDB;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        //Init view
        btnSave = (Button) findViewById(R.id.btnSave);

        rdiGroup = (RadioGroup) findViewById(R.id.rdiGroup);

        rdiEasy = (RadioButton) findViewById(R.id.rdiEasy);
        rdiMedium = (RadioButton) findViewById(R.id.rdiMedium);
        rdiHard = (RadioButton) findViewById(R.id.rdiHard);




        fitnessDB = new FitnessDB(this);
        int mode = fitnessDB.getSettingMode();
        setRadioButton(mode);


        //Event
        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                saveWorkoutMode();
                Toast.makeText(Settings.this, "SAVED", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }



        private void saveWorkoutMode() {
                int selectID = rdiGroup.getCheckedRadioButtonId();
                if(selectID == rdiEasy.getId())
                    fitnessDB.saveSettingMode(0);

                else  if(selectID == rdiMedium.getId())
                    fitnessDB.saveSettingMode(1);

                else  if(selectID == rdiHard.getId())
                    fitnessDB.saveSettingMode(2);
        }


        public void setRadioButton(int mode) {

            if(mode == 0)
                rdiGroup.check(R.id.rdiEasy);

            else  if(mode == 1)
                rdiGroup.check(R.id.rdiMedium);

            else  if(mode == 2)
                rdiGroup.check(R.id.rdiHard);
        }


    }


