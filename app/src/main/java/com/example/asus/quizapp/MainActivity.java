package com.example.asus.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    List<Integer> listAnswer = new ArrayList<Integer>();
    Button button;
    Button answerButton1;
    Button answerButton2;
    Button answerButton3;
    Button answerButton4;
    TextView answerTextView;
    TextView rightOrFalseTextView;
    TextView sumTextView;
    int shuffABC;
    int score=0;
    int numberOfQuestion=0;

    public void clickAnswer(View view) {
        if (view.getTag().toString().equals(Integer.toString(shuffABC + 1))) {
            answerTextView.setText("CORRECT!!");
            answerTextView.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
            score++;
        } else {
            answerTextView.setText("INCORECT!!");
            answerTextView.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        }
        numberOfQuestion++;
        rightOrFalseTextView.setText(score+"/"+numberOfQuestion);
        answerTextView.setVisibility(View.VISIBLE);
        newQuestion();
    }

    public void newQuestion(){
        listAnswer.clear();
        Random random = new Random();

        int nilai1 = random.nextInt(50);
        int nilai2 = random.nextInt(50);

        sumTextView.setText(nilai1 + " + " + nilai2);

        shuffABC = random.nextInt(3);

        for (int i = 0; i < 4; i++) {
            int acak = random.nextInt(100);
            if (shuffABC == i) {
                listAnswer.add(nilai1 + nilai2);
            } else {
                while (acak == nilai1 + nilai2) {
                    acak = random.nextInt(100);
                }
                listAnswer.add(acak);
            }
        }
        answerButton1.setText(Integer.toString(listAnswer.get(0)));
        answerButton2.setText(Integer.toString(listAnswer.get(1)));
        answerButton3.setText(Integer.toString(listAnswer.get(2)));
        answerButton4.setText(Integer.toString(listAnswer.get(3)));
    }

    public void clickStartQuiz(View view) {
        button.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.startQuizButton);
        answerTextView = findViewById(R.id.answerTextView);
        rightOrFalseTextView = findViewById(R.id.rightFalseTextView);
        answerButton1 = (Button) findViewById(R.id.button1);
        answerButton2 = (Button) findViewById(R.id.button2);
        answerButton3 = (Button) findViewById(R.id.button3);
        answerButton4 = (Button) findViewById(R.id.button4);
        sumTextView = (TextView) findViewById(R.id.sumTextView);

        answerTextView.setVisibility(View.INVISIBLE);

        newQuestion();
    }
}
