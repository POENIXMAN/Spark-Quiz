package com.example.spark_quiz;


import android.util.Log;

import com.google.firebase.firestore.CollectionReference;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class FirebaseQuestionUploader {

    private static final String TAG = "FirebaseQuestionUploader";

    public static void uploadQuestions() {
        // Initialize Firestore
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

        List<String> optionsQuestion60 = Arrays.asList("Marie Curie", "Niels Bohr", "Erwin Schrödinger");
        Question question60 = new Question("Who won the Nobel Prize in Physics for the discovery of the neutron?", "Science", "James Chadwick", optionsQuestion60);
        question60.setCorrectCount(0); // Initialize correctCount
        question60.setAskedCount(0);   // Initialize askedCount
        firebaseFirestore.collection("questions").add(question60);

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
