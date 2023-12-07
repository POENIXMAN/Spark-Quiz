package com.example.spark_quiz;


import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.List;

public class FirebaseQuestionUploader {
    public static void uploadQuestions() {
        // Initialize Firestore
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();



        for (int i = 2; i <= 50; i++) {
            String documentId = "question" + i;
            updateQuestion(firebaseFirestore, documentId);
        }


    }

    private static void updateQuestion(FirebaseFirestore firestore, String documentId) {
        final String TAG = "FirebaseQuestionUploader";

        firestore.collection("questions").document(documentId).get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document != null && document.exists()) {
                            Log.d(TAG, "Document exists. Updating...");
                            // Retrieve existing question
                            Question existingQuestion = document.toObject(Question.class);

                            // Update the new variables
                            assert existingQuestion != null;
                            existingQuestion.setCorrectCount(0); // Initialize correctCount
                            existingQuestion.setAskedCount(0);   // Initialize askedCount

                            // Update the existing question in the database
                            firestore.collection("questions").document(documentId).set(existingQuestion);
                        }else Log.d(TAG, "Document does not exist.");

                    }else Log.e(TAG, "Error fetching document: " + task.getException());

                });
    }


}
