package com.example.android.quizzapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // submitting answers button
    public void submitAnswers(View view) {
        //name
        EditText nameField = (EditText) findViewById(R.id.name_view);
        String nameText = nameField.getText().toString();
        boolean nameBlank = nameField.length() == 0;
        if (nameBlank) {
            Toast.makeText(this, "Please fill in your name!", Toast.LENGTH_SHORT).show();
            return;
        }
        //first question
        CheckBox checkBoxFirst = (CheckBox) findViewById(R.id.checkbox_first);
        CheckBox checkBoxSecond = (CheckBox) findViewById(R.id.checkbox_second);
        boolean isCorrect1 = checkBoxFirst.isChecked() && checkBoxSecond.isChecked();
        if (isCorrect1) {
            score = score + 1;
        }

        boolean isCorrect1B = checkBoxFirst.isChecked();
        //second question
        RadioButton radioButtonSecond = (RadioButton) findViewById(R.id.radio_second);
        boolean isCorrect2 = radioButtonSecond.isChecked();
        if (isCorrect2 == true) {
            score = score + 1;
        }
        //thid question
        RadioButton radioButtonThird = (RadioButton) findViewById(R.id.radio_third);
        boolean isCorrect3 = radioButtonThird.isChecked();
        if (isCorrect3 == true) {
            score = score + 1;
        }
        //fourth question
        RadioButton radioButtonFourth = (RadioButton) findViewById(R.id.radio_fourth);
        boolean isCorrect4 = radioButtonFourth.isChecked();
        if (isCorrect4 == true) {
            score = score + 1;
        }
        //fifth question
        EditText textFifth = (EditText) findViewById(R.id.name_view_river);
        String question5 = textFifth.getText().toString();
        boolean isCorrect5 = question5.contains("Nile");
        if (isCorrect5 == true) {
            score = score + 1;
        }
        //feedback for score
        boolean feedBack = score == 5;
        if (feedBack) {
            Toast.makeText(this, "Wow! Nice work!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You still got a few things to learn, keep trying! :)", Toast.LENGTH_SHORT).show();
        }

        //display message
        String answersMessage = createAnswers(nameText, isCorrect1, isCorrect2, isCorrect3, isCorrect4, isCorrect5);
        displayMessage(answersMessage);

    }


    private String createAnswers(String nameText, boolean question1, boolean question2, boolean question3, boolean question4, boolean question5) {
        String answersSummary = "\nName: " + nameText;
        answersSummary = answersSummary + "\nQuestion 1 correct? " + question1;
        answersSummary = answersSummary + "\nQuestion 2 correct? " + question2;
        answersSummary = answersSummary + "\nQuestion 3 correct? " + question3;
        answersSummary = answersSummary + "\nQuestion 4 correct? " + question4;
        answersSummary = answersSummary + "\nQuestion 5 correct? " + question5;
        answersSummary = answersSummary + "\nYour score is: " + score + "/5";
        return answersSummary;
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.submit);
        orderSummaryTextView.setText(message);

    }


}
