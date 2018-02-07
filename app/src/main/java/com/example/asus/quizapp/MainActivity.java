package com.example.asus.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    List<Integer> listAnswer = new ArrayList<Integer>();

    public void clickAnswer(View view) {
        if (view.getId() == R.id.button1) {

        } else if (view.getId() == R.id.button2) {

        } else if (view.getId() == R.id.button3) {

        } else {

        }
    }

    Button button;

    public void clickStartQuiz(View view) {
        button.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.startQuizButton);
        TextView sumTextView = (TextView) findViewById(R.id.sumTextView);

        Random random = new Random();

        int nilai1 = random.nextInt(50);
        int nilai2 = random.nextInt(50);

        sumTextView.setText(nilai1 + " + "+ nilai2);


        int shuffABC = random.nextInt(3);

        for(int i=0;i<4;i++){
            int acak = random.nextInt(100);
            if(shuffABC==i){
                listAnswer.add(nilai1+nilai2);
            }
            else{
                while(acak==nilai1+nilai2){
                    acak = random.nextInt(100);
                }
                listAnswer.add(acak);
            }
        }

    }
}
