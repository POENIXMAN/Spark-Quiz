package com.example.spark_quiz;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class QuestionFragment extends Fragment {

    private String questionText;
    private String option1;
    private String option2;
    private String option3;
    private int questionIndex;

    private SApp application;

    public QuestionFragment() {
    }

    public static QuestionFragment newInstance(String questionText, String option1, String option2, String option3 , int questionIndex) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putString("questionText", questionText);
        args.putString("option1", option1);
        args.putString("option2", option2);
        args.putString("option3", option3);
        args.putInt("questionIndex" , questionIndex);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            questionText = getArguments().getString("questionText");
            option1 = getArguments().getString("option1");
            option2 = getArguments().getString("option2");
            option3 = getArguments().getString("option3");
            questionIndex = getArguments().getInt("questionIndex");
            application = (SApp) getActivity().getApplication();
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
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);

                if (radioButton != null) {
                    int selectedIndex = group.indexOfChild(radioButton) + 1;
                    application.getAnswers()[questionIndex] = (byte) selectedIndex;
                }
            }
        });

        return view;
    }

    private void addRadioButton(RadioGroup radioGroup, String optionText) {
        RadioButton radioButton = new RadioButton(getContext());
        radioButton.setText(optionText);
        int index = radioGroup.getChildCount();
        if (application.getAnswers()[questionIndex] == index + 1) {
            radioButton.setChecked(true);
        }
        radioGroup.addView(radioButton);
    }
}