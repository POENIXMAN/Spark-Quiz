package com.example.spark_quiz;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;

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

            finish();
        }
        );

        Button try_again = findViewById(R.id.again_btn);
        try_again.setOnClickListener(v->{
            Intent intent = new Intent(DisplayActivity.this, MainActivity.class);
            application.setAnswers(new byte[20]);
            startActivity(intent);

            finish();
        });


        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Toast.makeText(DisplayActivity.this, "You can't go back from here", Toast.LENGTH_SHORT).show();
            }
        });



    }



}