package com.example.spark_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DisplayActivity extends AppCompatActivity {

    SApp application;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        application = (SApp) getApplication();
        ScoreChart sc = findViewById(R.id.scorechart);
        sc = new ScoreChart(this , null , application.getScore());


    }
}