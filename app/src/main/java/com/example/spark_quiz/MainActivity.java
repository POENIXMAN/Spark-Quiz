package com.example.spark_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseQuestionRepository questionRepository = new FirebaseQuestionRepository();
        questionRepository.getQuestions(new FirebaseQuestionRepository.FirebaseCallback<List<Question>>() {
            public void onSuccess(List<Question> result) {
                questions = result;
                Toast.makeText(MainActivity.this, "Questions loaded successfully!", Toast.LENGTH_SHORT).show();
                for (Question question : result) {
                    Log.d("Question", "Category: " + question.getCategory() + ", Text: " + question.getText());
                }
                questions.sort(Comparator.comparing(Question::getCategory));
                for (Question q: questions){
                    Log.d("sorted", q.getCategory());
                }
                ViewPager viewPager = findViewById(R.id.viewPager);
                viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(MainActivity.this, "Failed to load questions. Please check your internet connection.", Toast.LENGTH_SHORT).show();
                Log.e("FirebaseError", "Failed to load questions", e);
            }
        });
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        MyPagerAdapter(FragmentManager fragmentManager ) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            if (position < 4) {
                return PageFragment.newInstance(position + 1 , questions);
            } else {
                return SubmitFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return 5;
        }


    }




}