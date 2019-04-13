package com.example.myfirstmillion;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvQuestion;
    private Button mBtnA;
    private Button mBtnB;
    private Button mBtnC;
    private Button mBtnD;
    private Button mStartAgain;
    private Button mBtnTip;
    private ArrayList<Question> mQuestions;
    private Random mRandom = new Random();
    private int mCurrentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvQuestion = findViewById(R.id.tvQuestion);
        mBtnA = findViewById(R.id.btn_a);
        mBtnB = findViewById(R.id.btn_b);
        mBtnC = findViewById(R.id.btn_c);
        mBtnD = findViewById(R.id.btn_d);
        mStartAgain = findViewById(R.id.startAgain);
        mBtnTip = findViewById(R.id.btnTip);

        mBtnA.setOnClickListener(this);
        mBtnB.setOnClickListener(this);
        mBtnC.setOnClickListener(this);
        mBtnD.setOnClickListener(this);
        mStartAgain.setOnClickListener(this);
        mBtnTip.setOnClickListener(this);

        mQuestions = Utils.setQuestionsBlock(1);
        updateQuestionUI();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_a:
            case R.id.btn_b:
            case R.id.btn_c:
            case R.id.btn_d:
                View view = null;
                int index = -1;
                switch (v.getId()) {
                    case R.id.btn_a:
                        view = mBtnA;
                        index = 0;
                        break;
                    case R.id.btn_b:
                        view = mBtnB;
                        index = 1;
                        break;
                    case R.id.btn_c:
                        view = mBtnC;
                        index = 2;
                        break;
                    case R.id.btn_d:
                        view = mBtnD;
                        index = 3;
                        break;
                }
                if (view == null) {
                    return;
                }
                final View selectedView = view;
                final int currentIndex = index;
                final Drawable background = view.getBackground();

                selectedView.setBackgroundColor(Color.YELLOW);
                selectedView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        final boolean correct = currentIndex == mQuestions.get(mCurrentQuestionIndex).getCorrectIndex();
                        selectedView.setBackgroundColor(correct ? Color.GREEN : Color.RED);
                        selectedView.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (correct) {
                                    if (mQuestions.size() == 1) {
                                        mBtnA.setVisibility(View.GONE);
                                        mBtnB.setVisibility(View.GONE);
                                        mBtnC.setVisibility(View.GONE);
                                        mBtnD.setVisibility(View.GONE);
                                        mBtnTip.setVisibility(View.GONE);
                                        mStartAgain.setVisibility(View.VISIBLE);
                                        mTvQuestion.setText("Flawless victory");
                                    } else {
                                        mQuestions.remove(mCurrentQuestionIndex);
                                        updateQuestionUI();
                                    }
                                }
                                selectedView.setBackground(background);
                            }
                        }, 1000);
                    }
                }, 2000);
                break;

            case R.id.startAgain:
                mQuestions = Utils.setQuestionsBlock(0);
                updateQuestionUI();
                break;

            case R.id.btnTip:
                Question currentQuestion = mQuestions.get(mCurrentQuestionIndex);
                ArrayList<Option> tipOptions = (ArrayList<Option>) currentQuestion.getOptions().clone();
                tipOptions.remove(currentQuestion.getCorrectIndex());

                int firstTipIndex = mRandom.nextInt(3);
                Option firstOption = tipOptions.get(firstTipIndex);
                tipOptions.remove(firstTipIndex);
                int secondTipIndex = mRandom.nextInt(2);
                Option secondOption = tipOptions.get(secondTipIndex);

                ArrayList<Option> options = currentQuestion.getOptions();
                int[] tipIndexes = {options.indexOf(firstOption), options.indexOf(secondOption)};
                for (int tipIndex : tipIndexes) {
                    if (tipIndex == 0) {
                        mBtnA.setEnabled(false);
                    } else if (tipIndex == 1) {
                        mBtnB.setEnabled(false);
                    } else if (tipIndex == 2) {
                        mBtnC.setEnabled(false);
                    } else {
                        mBtnD.setEnabled(false);
                    }
                }
                break;

            default:
                break;
        }
    }

    private void updateQuestionUI() {
        Question currentQuestion = getRandomQuestion();
        ArrayList<Option> options = currentQuestion.getOptions();

        mBtnA.setVisibility(View.VISIBLE);
        mBtnB.setVisibility(View.VISIBLE);
        mBtnC.setVisibility(View.VISIBLE);
        mBtnD.setVisibility(View.VISIBLE);
        mBtnTip.setVisibility(View.VISIBLE);
        mBtnA.setEnabled(true);
        mBtnB.setEnabled(true);
        mBtnC.setEnabled(true);
        mBtnD.setEnabled(true);
        mStartAgain.setVisibility(View.GONE);

        mTvQuestion.setText(currentQuestion.getQuestion());
        mBtnA.setText(options.get(0).getText());
        mBtnB.setText(options.get(1).getText());
        mBtnC.setText(options.get(2).getText());
        mBtnD.setText(options.get(3).getText());
    }

    private Question getRandomQuestion() {
        mCurrentQuestionIndex = mRandom.nextInt(mQuestions.size());
        return mQuestions.get(mCurrentQuestionIndex);
    }
}
