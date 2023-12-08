package com.example.spark_quiz;

import java.util.List;

/**public class Question {
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
}**/
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class Question implements Parcelable {
    private String text;

    private String id;
    private String category;
    private String correctOption;
    private List<String> options;
    private int correctCount;
    private int askedCount;

    // Required public no-argument constructor for Parcelable
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

    // Parcelable implementation
    protected Question(Parcel in) {
        text = in.readString();
        category = in.readString();
        correctOption = in.readString();
        options = in.createStringArrayList();
        correctCount = in.readInt();
        askedCount = in.readInt();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
        dest.writeString(category);
        dest.writeString(correctOption);
        dest.writeStringList(options);
        dest.writeInt(correctCount);
        dest.writeInt(askedCount);
    }

    // Rest of your existing methods...

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public int getCorrectCount() {
        return correctCount;
    }


    public int getAskedCount() {
        return askedCount;
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



    public void setCorrectCount(int i) {
        this.correctCount = i;
    }

    public void setAskedCount(int i) {
        this.askedCount = i;
    }
}

