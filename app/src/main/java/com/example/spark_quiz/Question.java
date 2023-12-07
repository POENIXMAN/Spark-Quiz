package com.example.spark_quiz;

import java.util.List;

public class Question {
    private String text;
    private String category;
    private String correctOption;
    private List<String> options; // Use List instead of an array

    // Required public no-argument constructor for Firestore
    public Question() {
    }

    public Question(String text, String category, String correctOption, List<String> options) {
        this.text = text;
        this.category = category;
        this.correctOption = correctOption;
        this.options = options;
    }

    public String getText() {
        return text;
    }

    public String getCategory() {
        return category;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public List<String> getOptions() {
        return options;
    }
}

