package com.example.androidfitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.androidfitnessapp.Adapter.RecyclerViewAdapter;
import com.example.androidfitnessapp.Model.Exercise;
import java.util.ArrayList;
import java.util.List;

public class ListExercises extends AppCompatActivity  {


    List<Exercise> exerciseList = new ArrayList<>();
    RecyclerView.LayoutManager LayoutManager;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initData();

        recyclerView = (RecyclerView) findViewById(R.id.list);
        adapter = new RecyclerViewAdapter(exerciseList, getBaseContext());
        LayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(LayoutManager);
        recyclerView.setAdapter(adapter);


    }

    private void initData() {

        exerciseList.add(new Exercise(R.drawable.exercise9, "Plank"));
        exerciseList.add(new Exercise(R.drawable.exercise12, "Mountain Climber"));
        exerciseList.add(new Exercise(R.drawable.exercise11, "Side-Lying Leg Lift"));
        exerciseList.add(new Exercise(R.drawable.exercise10, "Reverse Crunches"));
        exerciseList.add(new Exercise(R.drawable.exercise5, "Butt Bridge"));
        exerciseList.add(new Exercise(R.drawable.exercise7, "Backward Lunge"));
        exerciseList.add(new Exercise(R.drawable.exercise2, "Cobra Stretch"));
        exerciseList.add(new Exercise(R.drawable.exercise8, "Glute Stretch Left"));
        exerciseList.add(new Exercise(R.drawable.exercise6, "Donkey Kicks"));
        
    }



}
