package com.example.spark_quiz;

import android.app.Application;


public class SApp extends Application {

    private Question[] geography;
    private Question[] history;
    private Question[] science;
    private Question[] pop_culture;

    public Question[] getGeography() {
        return geography;
    }

    public void setGeography(Question[] geography) {
        this.geography = geography;
    }

    public Question[] getHistory() {
        return history;
    }

    public void setHistory(Question[] history) {
        this.history = history;
    }

    public Question[] getScience() {
        return science;
    }

    public void setScience(Question[] science) {
        this.science = science;
    }

    public Question[] getPop_culture() {
        return pop_culture;
    }

    public void setPop_culture(Question[] pop_culture) {
        this.pop_culture = pop_culture;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    private String[] answers;
    @Override
    public void onCreate() {
        super.onCreate();
    }

}
