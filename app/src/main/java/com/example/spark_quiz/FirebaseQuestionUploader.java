package com.example.spark_quiz;


import android.util.Log;

import com.google.firebase.firestore.CollectionReference;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;



public class FirebaseQuestionUploader {

    private static final String TAG = "FirebaseQuestionUploader";

    public static void uploadQuestions() {
        // Initialize Firestore
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();


    }


    public static void getDocumentIds() {
        // Initialize Firestore
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        CollectionReference collectionReference = firebaseFirestore.collection("questions");

        collectionReference.get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            // document.getId() will give you the document ID
                            String documentId = document.getId();
                            Log.d(TAG, "Document ID: " + documentId);
                            Question existingQuestion = document.toObject(Question.class);

                            // Update the new variables
                            existingQuestion.setCorrectCount(0); // Initialize correctCount
                            existingQuestion.setAskedCount(0);   // Initialize askedCount

                            // Update the existing question in the database
                            firebaseFirestore.collection("questions").document(documentId).set(existingQuestion);
                        }
                    } else {
                        Log.e(TAG, "Error getting documents: " + task.getException());
                    }
                });
    }


}
