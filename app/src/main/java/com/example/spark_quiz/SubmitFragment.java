package com.example.spark_quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import android.widget.Button;

public class SubmitFragment extends Fragment {

    public SubmitFragment() {
        // Required empty public constructor
    }

    public static SubmitFragment newInstance() {
        return new SubmitFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_submit, container, false);

        Button submitButton = view.findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the submit button click
            }
        });

        return view;
    }
}

