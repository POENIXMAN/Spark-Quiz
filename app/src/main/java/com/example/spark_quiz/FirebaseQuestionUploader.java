package com.example.spark_quiz;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.List;

public class FirebaseQuestionUploader {
    public static void uploadQuestions() {
        // Initialize Firestore
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();


        // Add question 2
        List<String> optionsQuestion2 = Arrays.asList("Jane Austen", "Harper Lee", "Charles Dickens");
        Question question2 = new Question("Who is the author of 'To Kill a Mockingbird'?", "Literature", "Harper Lee", optionsQuestion2);

        firebaseFirestore.collection("questions").add(question2).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e("Firebase", "Error adding question2: " + e.getMessage());
            }
        });

// Add question 3
        List<String> optionsQuestion3 = Arrays.asList("option1", "Mars", "option3");
        Question question3 = new Question("Which planet is known as the Red Planet?", "Science", "option2", optionsQuestion3);

        firebaseFirestore.collection("questions").add(question3).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("1", "onFailure: ");
            }
        });

// Add question 4
        List<String> optionsQuestion4 = Arrays.asList("option1", "option2", "Blue Whale");
        Question question4 = new Question("What is the largest mammal on Earth?", "Biology", "option3", optionsQuestion4);

        firebaseFirestore.collection("questions").add(question4).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("database", "onFailure: ");
            }


        });

// Add question 5
        List<String> optionsQuestion5 = Arrays.asList("option1", "Leonardo da Vinci", "option3");
        Question question5 = new Question("Who painted the Mona Lisa?", "Art", "option2", optionsQuestion5);

        firebaseFirestore.collection("questions").add(question5).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("1", "onFailure: ");
            }
        });

// Add question 6
        List<String> optionsQuestion6 = Arrays.asList("Yen", "option2", "option3");
        Question question6 = new Question("What is the currency of Japan?", "Geography", "option1", optionsQuestion6);

        firebaseFirestore.collection("questions").add(question6).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("1", "onFailure: ");
            }
        });
    }


}
