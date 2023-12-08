package com.example.spark_quiz;


import android.util.Log;

import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class FirebaseQuestionRepository {

    private final FirebaseFirestore db = FirebaseFirestore.getInstance();


    private final CollectionReference questionsCollection = db.collection("questions");

    public void getQuestions(final FirebaseCallback<List<Question>> callback) {
        final List<Question> allQuestions = new ArrayList<>();
        questionsCollection.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (DocumentSnapshot document : task.getResult()) {
                    Question question = document.toObject(Question.class);
                    allQuestions.add(question);
                }
                List<Question> selectedQuestions = selectQuestionsByCategory(allQuestions);
                callback.onSuccess(selectedQuestions);
            } else {
                callback.onFailure(task.getException());
            }
        });
    }



    private List<Question> selectQuestionsByCategory(List<Question> allQuestions) {
        List<Question> selectedQuestions = new ArrayList<>();
        for (String category : Arrays.asList("Geography", "History", "Science", "Pop-Culture")) {
            List<Question> categoryQuestions = getQuestionsByCategory(allQuestions, category);
            Collections.shuffle(categoryQuestions);
            selectedQuestions.addAll(categoryQuestions.subList(0, 5));
        }

        return selectedQuestions;
    }

    private List<Question> getQuestionsByCategory(List<Question> allQuestions, String category) {
        List<Question> categoryQuestions = new ArrayList<>();
        for (Question question : allQuestions) {
            if (question.getCategory().equals(category)) {
                categoryQuestions.add(question);
            }
        }
        return categoryQuestions;
    }

    public interface FirebaseCallback<T> {
        void onSuccess(T result);

        void onFailure(Exception e);
    }
}
