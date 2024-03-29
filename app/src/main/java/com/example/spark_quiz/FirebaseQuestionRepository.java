package com.example.spark_quiz;


import android.util.Log;


import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class FirebaseQuestionRepository {

    private final FirebaseFirestore db = FirebaseFirestore.getInstance();


    private final CollectionReference questionsCollection = db.collection("questions");

    public void getQuestions(final FirebaseCallback<List<Question>> callback) {
        final List<Question> allQuestions = new ArrayList<>();
        questionsCollection.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (DocumentSnapshot document : task.getResult()) {
                    Question question = document.toObject(Question.class);
                    if (question != null) {
                        question.setId(document.getId());
                    }
                    allQuestions.add(question);
                }
                List<Question> selectedQuestions = selectQuestionsByCategory(allQuestions);
                updateAskedCount(selectedQuestions);
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

    public void updateAskedCount(List<Question> selectedQuestions) {
        for (Question question : selectedQuestions) {
            question.setAskedCount(question.getAskedCount() + 1);
            updateAskedCountInDB(question);
        }
    }

    public void updateCorrectCount(List<Question> selectedQuestions) {
        for (Question question : selectedQuestions) {
            question.setCorrectCount(question.getCorrectCount());
            updateCorrectCountInDB(question);
        }
    }

    private void updateCorrectCountInDB(Question question){
        DocumentReference questionRef = questionsCollection.document(question.getId());
        questionRef.update("correctCount", question.getCorrectCount())
                .addOnSuccessListener(aVoid -> Log.d("Firestore", "askedCount updated successfully"))
                .addOnFailureListener(e -> Log.e("Firestore", "Error updating askedCount", e));

    }

    private void updateAskedCountInDB(Question question) {
        DocumentReference questionRef = questionsCollection.document(question.getId());
        questionRef.update("askedCount", question.getAskedCount())
                .addOnSuccessListener(aVoid -> Log.d("Firestore", "askedCount updated successfully"))
                .addOnFailureListener(e -> Log.e("Firestore", "Error updating askedCount", e));
    }

    private void ZERO(List<Question> selectedQuestions){
        for (Question question : selectedQuestions) {

            question.setCorrectCount(0);
            question.setAskedCount(0);

            updateCorrectCountInDB(question);
            updateAskedCountInDB(question);
        }
    }

}
