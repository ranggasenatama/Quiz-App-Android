package com.example.asus.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

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
    }
}
