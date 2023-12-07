package com.example.spark_quiz;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PageFragment extends Fragment {

    private int pageNumber;
    private String[] fields = {"Geography" , "History" , "Science" , "Pop Culture"};

    public PageFragment() {

    }

    public static PageFragment newInstance(int pageNumber) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt("pageNumber", pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            pageNumber = getArguments().getInt("pageNumber");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        TextView field = view.findViewById(R.id.field);
        field.setText(fields[pageNumber - 1]);
        LinearLayout questionContainer = view.findViewById(R.id.questionContainer);

        if (getChildFragmentManager().findFragmentByTag("QuestionFragment") == null) {
            for (int i = 0; i < 5; i++) {
                String questionText = "Question " + (i + 1);
                String option1 = "Option A";
                String option2 = "Option B";
                String option3 = "Option C";

                QuestionFragment questionFragment = QuestionFragment.newInstance(questionText, option1, option2, option3);

                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.add(questionContainer.getId(), questionFragment, "QuestionFragment");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        }

        return view;
    }
}
