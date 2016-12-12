package com.example.android.quizzapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    double answer = 0;
    double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //This part of code will work when you pressed submit button
    public void submit(View view) {
        EditText textOne = (EditText) findViewById(R.id.firstedit);
        String firstAnswer = textOne.getText().toString();

        if (firstAnswer.equalsIgnoreCase("Tangent"))
            answer = answer + 1;
        EditText textTwo = (EditText) findViewById(R.id.third_edit);
        String third = textTwo.getText().toString();
        if (third.equalsIgnoreCase("Cone"))
            answer = answer + 1;

        CheckBox ch1 = (CheckBox) findViewById(R.id.a);
        CheckBox ch2 = (CheckBox) findViewById(R.id.b);
        CheckBox ch3 = (CheckBox) findViewById(R.id.c);
        CheckBox ch4 = (CheckBox) findViewById(R.id.d);

        if (!ch1.isChecked() && ch2.isChecked() && !ch3.isChecked() && ch4.isChecked()) {
            answer = answer + 1;
        }
        EditText textFour = (EditText) findViewById(R.id.fourthedit);
        String fourthAnswer = textFour.getText().toString();

        if (fourthAnswer.equalsIgnoreCase("Pythagoras"))
            answer = answer + 1;

        CheckBox ch5 = (CheckBox) findViewById(R.id.a5);
        CheckBox ch5b = (CheckBox) findViewById(R.id.b5);
        CheckBox ch5c = (CheckBox) findViewById(R.id.c5);
        CheckBox ch5d = (CheckBox) findViewById(R.id.d5);

        if (ch5.isChecked() && !ch5b.isChecked() && ch5c.isChecked() && !ch5d.isChecked()) {
            answer = answer + 1;
        }

        RadioGroup radiogroup = (RadioGroup) findViewById(R.id.radioG);
        RadioButton sel = (RadioButton) radiogroup.findViewById(R.id.RadioButton);
        boolean sixAnswer = sel.isChecked();
        if (sixAnswer)
            answer = answer + 1;

        if (answer == 6) {
            Toast toast = Toast.makeText(this, "Well done!!! You did great job! Your correct answer is out of 6 :  " + answer, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(this, "Try again! Your correct answer is out of 6 :  " + answer, Toast.LENGTH_SHORT);
            toast.show();
        }


        result = answer;
        answer = 0;
    }

    //To share result with Quiz taker
    public void share(View view) {
        EditText text = (EditText) findViewById(R.id.editText);
        String nameQtaker = text.getText().toString();
        //Students result will send by e-mail
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Quiz Result");
        intent.putExtra(Intent.EXTRA_TEXT, "Dear " + nameQtaker + "!\nWe kindly appreciate you for taking quiz. \nYour correct answer is out of 6 : " + result);

        startActivity(intent);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}










