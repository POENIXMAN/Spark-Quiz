package com.example.spark_quiz;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import android.widget.Button;

public class SubmitFragment extends Fragment {

    private SApp application;

    public SubmitFragment() {
        // Required empty public constructor
    }

    public static SubmitFragment newInstance() {
        return new SubmitFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (SApp) getActivity().getApplication();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_submit, container, false);

        Button submitButton = view.findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byte score = 0;
                for (int i = 0; i < 20 ; i++) {
                    Question question = application.getQuestions().get(i);
                    String correctanswer = question.getCorrectOption();
                    String useranswer = question.getOptions().get(application.getAnswers()[i] - 1);
                    if (correctanswer.equals(useranswer)) {
                        score++;
                    }
                }
                Log.e("SCOREBABY" , "" + score);
            }
        });

        return view;
    }
}

