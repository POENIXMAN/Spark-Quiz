package com.example.spark_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class SubmitFragment extends Fragment {

    private SApp application;

    List<Question> ques;

    int allAsked;


    public SubmitFragment() {

    }

    public static SubmitFragment newInstance() {
        return new SubmitFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (SApp) getActivity().getApplication();
        ques = new ArrayList<>();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_submit, container, false);

        Button submitButton = view.findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] score = new int[4];
                for (int i = 0; i < 20 ; i++) {
                    Question question = application.getQuestions().get(i);
                    String correctanswer = question.getCorrectOption();
                    String useranswer;
                    if (application.getAnswers()[i] != 0) {
                        useranswer = question.getOptions().get(application.getAnswers()[i] - 1);
                    }
                    else {
                        useranswer = "XXXXXXXXXXXXXXXXXXXXXXX";
                    }
                    if (correctanswer.equals(useranswer)) {
                        score[i / 5]++;
                        //question.setCorrectCount(question.getCorrectCount()+1);
                        //ques.add(question);
                    }
                }
                application.setScore(score);
                Intent intent = new Intent(getActivity() , DisplayActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}

