package com.example.spark_quiz;

import android.app.Application;
import android.graphics.Color;

import java.util.Dictionary;
import java.util.List;


public class SApp extends Application {

    private List<Question> questions;
    private byte[] answers;
    private boolean fetched;
    int percentage;
    private int[] score;



    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public boolean isFetched() {
        return fetched;
    }

    public void setFetched(boolean fetched) {
        this.fetched = fetched;
    }

    public byte[] getAnswers() {
        return answers;
    }

    public void setAnswers(byte[] answers) {
        this.answers = answers;
    }

    public int[] getScore() {
        return score;
    }

    public void setScore(int[] score) {
        this.score = score;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        fetched = false;
        answers = new byte[20];
    }

}
