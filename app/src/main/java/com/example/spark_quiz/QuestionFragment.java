package com.example.spark_quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class QuestionFragment extends Fragment {

    private static final String ARG_QUESTION_TEXT = "questionText";
    private static final String ARG_OPTION_1 = "option1";
    private static final String ARG_OPTION_2 = "option2";
    private static final String ARG_OPTION_3 = "option3";

    private String questionText;
    private String option1;
    private String option2;
    private String option3;

    public QuestionFragment() {
        // Required empty public constructor
    }

    public static QuestionFragment newInstance(String questionText, String option1, String option2, String option3) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_QUESTION_TEXT, questionText);
        args.putString(ARG_OPTION_1, option1);
        args.putString(ARG_OPTION_2, option2);
        args.putString(ARG_OPTION_3, option3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            questionText = getArguments().getString(ARG_QUESTION_TEXT);
            option1 = getArguments().getString(ARG_OPTION_1);
            option2 = getArguments().getString(ARG_OPTION_2);
            option3 = getArguments().getString(ARG_OPTION_3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question, container, false);

        TextView questionTextView = view.findViewById(R.id.questionTextView);
        questionTextView.setText(questionText);

        RadioGroup radioGroup = view.findViewById(R.id.radioGroup);
        addRadioButton(radioGroup, option1);
        addRadioButton(radioGroup, option2);
        addRadioButton(radioGroup, option3);

        return view;
    }

    private void addRadioButton(RadioGroup radioGroup, String optionText) {
        RadioButton radioButton = new RadioButton(getContext());
        radioButton.setText(optionText);
        radioGroup.addView(radioButton);
    }
}