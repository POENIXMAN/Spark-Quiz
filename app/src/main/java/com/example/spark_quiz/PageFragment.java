package com.example.spark_quiz;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PageFragment extends Fragment {

    private int pageNumber;
    private ArrayList<Question> questions;
    private String[] fields = {"Geography" , "History" , "Science" , "Pop Culture"};

    public PageFragment() {

    }

    public static PageFragment newInstance(int pageNumber , List<Question> questions) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt("pageNumber", pageNumber);
        ArrayList<Question> questions_Al = new ArrayList<>(questions);
        args.putParcelableArrayList("questions", questions_Al);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            pageNumber = getArguments().getInt("pageNumber");
            questions = getArguments().getParcelableArrayList("questions");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        TextView field = view.findViewById(R.id.field);
        field.setText(fields[pageNumber - 1]);
        LinearLayout questionContainer = view.findViewById(R.id.questionContainer);

        if (getChildFragmentManager().findFragmentByTag("QuestionFragment") == null) {
            for (int i = (pageNumber - 1) * 5 ; i < (pageNumber - 1) * 5 + 5; i++) {

                String questionText = questions.get(i).getText();
                String option1 = questions.get(i).getOptions().get(0);
                String option2 = questions.get(i).getOptions().get(1);
                String option3 = questions.get(i).getOptions().get(2);

                QuestionFragment questionFragment = QuestionFragment.newInstance(questionText, option1, option2, option3 , i);

                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.add(questionContainer.getId(), questionFragment, "QuestionFragment");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        }

        return view;
    }
}
