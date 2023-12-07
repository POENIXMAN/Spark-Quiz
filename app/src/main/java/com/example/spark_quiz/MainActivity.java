package com.example.spark_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseQuestionRepository questionRepository = new FirebaseQuestionRepository();
        questionRepository.getQuestions(new FirebaseQuestionRepository.FirebaseCallback<List<Question>>() {
            public void onSuccess(List<Question> result) {
                // Now 'result' contains 20 random questions with 5 from each category
                // Pass this list to your ViewPager adapter or wherever you need it
                // Example: viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), result));

                // Display success message (for example, with a Toast)
                Toast.makeText(MainActivity.this, "Questions loaded successfully!", Toast.LENGTH_SHORT).show();

                // Log the loaded questions for debugging (optional)
                for (Question question : result) {
                    Log.d("Question", "Category: " + question.getCategory() + ", Text: " + question.getText());
                }
            }

            @Override
            public void onFailure(Exception e) {
                // Handle failure

                // Display error message (for example, with a Toast)
                Toast.makeText(MainActivity.this, "Failed to load questions. Please check your internet connection.", Toast.LENGTH_SHORT).show();

                // Log the error for debugging (optional)
                Log.e("FirebaseError", "Failed to load questions", e);
            }
        });

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            if (position < 4) {
                return PageFragment.newInstance(position + 1);
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