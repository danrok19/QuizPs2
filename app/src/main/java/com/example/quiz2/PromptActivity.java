package com.example.quiz2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PromptActivity extends AppCompatActivity {

    private boolean correctAnswer;
    private TextView answerTextView;
    private Button showCorrectAnswerButton;
    private Button goBackButtton;
    public static final String KEY_EXTRA_ANSWER_SHOWN = "./quiz2.answerShown";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt);

        correctAnswer = getIntent().getBooleanExtra(MainActivity.KEY_EXTRA_ANSWER, true);
        showCorrectAnswerButton = findViewById(R.id.button);
        answerTextView = findViewById(R.id.answer_text_view);
        goBackButtton = findViewById(R.id.button2);

        showCorrectAnswerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int answer = correctAnswer ? R.string.button_true : R.string.button_false;
                answerTextView.setText(answer);
                setAnswerShownResult(true);
            }
        });
        goBackButtton.setOnClickListener((v) -> {
            finish();
        });

        }
    private void setAnswerShownResult(boolean answerWasShown){
        Intent resultIntent = new Intent();
        resultIntent.putExtra(KEY_EXTRA_ANSWER_SHOWN, answerWasShown);
        setResult(RESULT_OK, resultIntent);
    }



}