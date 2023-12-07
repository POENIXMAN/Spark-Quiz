package com.example.spark_quiz;


import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class FirebaseQuestionRepository {

    private final FirebaseFirestore db = FirebaseFirestore.getInstance();

    // Replace "questions" with your Firestore collection name
    private final CollectionReference questionsCollection = db.collection("questions");

    public void getQuestions(final FirebaseCallback<List<Question>> callback) {
        final List<Question> allQuestions = new ArrayList<>();

        // Retrieve all questions from Firestore
        questionsCollection.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (DocumentSnapshot document : task.getResult()) {
                    Question question = document.toObject(Question.class);
                    allQuestions.add(question);
                }

                // Filter questions by category
                List<Question> selectedQuestions = selectQuestionsByCategory(allQuestions);

                // Shuffle the selected questions
                Collections.shuffle(selectedQuestions);

                // Pick the first 20 questions
                List<Question> finalQuestions = selectedQuestions.subList(0, 20);

                callback.onSuccess(finalQuestions);
            } else {
                // Handle errors
                callback.onFailure(task.getException());
            }
        });
    }

    private List<Question> selectQuestionsByCategory(List<Question> allQuestions) {
        List<Question> selectedQuestions = new ArrayList<>();

        // Shuffle questions within each category
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
