package com.example.spark_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    SApp application;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        application = (SApp) getApplication();
        ScoreChart sc = findViewById(R.id.scorechart);
        sc.setScore(application.getScore());

        Button main_menu = findViewById(R.id.menu_btn);
        main_menu.setOnClickListener(v-> {
            Intent intent = new Intent(DisplayActivity.this, HomeActivity.class);
            application.setScore(new int[4]);
            application.setAnswers(new byte[20]);
            application.setFetched(false);
            application.setQuestions(new ArrayList<>());
            startActivity(intent);
        }
        );

        Button try_again = findViewById(R.id.again_btn);
        try_again.setOnClickListener(v->{
            Intent intent = new Intent(DisplayActivity.this, MainActivity.class);
            application.setAnswers(new byte[20]);
            startActivity(intent);
        });


    }
}