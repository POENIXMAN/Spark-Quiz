package com.example.spark_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        CollectionReference questionsRef = firestore.collection("questions");
        TextView questionTextView = findViewById(R.id.textView);

        questionsRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    Question question = document.toObject(Question.class);
                    questionTextView.setText(question.getText());
                }
            } else {
                // Handle the error
                Log.w("FireBase", "Error getting documents.", task.getException());
            }
        });




//        getSupportFragmentManager().beginTransaction().
//                add(R.id.fragment_container_view,BlankFragment.class,null)
//                .addToBackStack(null).commit();
//        getSupportFragmentManager().beginTransaction().
//                add(R.id.fragment_container_view,BlankFragment.class,null)
//                .addToBackStack(null).commit();
//        getSupportFragmentManager().beginTransaction().
//                add(R.id.fragment_container_view,BlankFragment.class,null)
//                .addToBackStack(null).commit();
    }

}