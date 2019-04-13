package com.example.myfirstmillion;

public class Option {
    private String mText;
    private boolean mIsActive;

    public Option(String text, boolean active) {
        mText = text;
        mIsActive = active;
    }

    public String getText() {
        return mText;
    }

    public boolean getActive() {
        return mIsActive;
    }
}
