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
    private SApp application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        application = (SApp) getApplication();
        FirebaseQuestionRepository questionRepository = new FirebaseQuestionRepository();
        if (!application.isFetched()) {
            questionRepository.getQuestions(new FirebaseQuestionRepository.FirebaseCallback<List<Question>>() {
                @Override
                public void onSuccess(List<Question> result) {
                    questions = result;
                    application.setFetched(true);
                    application.setQuestions(result);
                    ViewPager viewPager = findViewById(R.id.viewPager);
                    viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
                    Log.e("ZOBBI", "fetched");
                }

                @Override
                public void onFailure(Exception exception) {
                    Log.e("MainActivity", "Error getting questions: ", exception);
                }
            });
        }
        else {
            Log.e("ZOBBI", "not fetched");
            this.questions = application.getQuestions();
            ViewPager viewPager = findViewById(R.id.viewPager);
            viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        }
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