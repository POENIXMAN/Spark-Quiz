package com.example.spark_quiz;

import java.util.List;

public class Question {
    private String text;
    private String category;
    private String correctOption;
    private List<String> options;
    private int correctCount;
    private int askedCount;

    // Required public no-argument constructor for Firestore
    public Question() {
    }

    public Question(String text, String category, String correctOption, List<String> options) {
        this.text = text;
        this.category = category;
        this.correctOption = correctOption;
        this.options = options;
        this.correctCount = 0;
        this.askedCount = 0;
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

    public int getCorrectCount() {
        return correctCount;
    }

    public void incrementCorrectCount() {
        this.correctCount++;
    }

    public int getAskedCount() {
        return askedCount;
    }

    public void incrementAskedCount() {
        this.askedCount++;
    }

    public void setCorrectCount(int i) {
    }

    public void setAskedCount(int i) {
    }
}
