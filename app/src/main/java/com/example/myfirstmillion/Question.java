package com.example.myfirstmillion;

import java.util.ArrayList;

public class Question {

    private String mQuestion;
    private ArrayList<Option> mOptions;
    private int mCorrectIndex;

    public Question(String question, int correctIndex, ArrayList<Option> options) {
        mQuestion = question;
        mOptions = options;
        mCorrectIndex = correctIndex;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public ArrayList<Option> getOptions() {
        return mOptions;
    }

    public int getCorrectIndex() {
        return mCorrectIndex;
    }
}
