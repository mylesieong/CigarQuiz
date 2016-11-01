package com.myles.udacity.cigarquiz;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View view) {
        boolean isQuestion1Correct = false;
        boolean isQuestion2Correct = false;
        boolean isQuestion3Correct = false;
        boolean isQuestion4Correct = false;
        String mSummaryMessage;

        //Look into question 1, the answer should be op1, op2 and op3
        if (((CheckBox) findViewById(R.id.q1_content1)).isChecked() &&
                ((CheckBox) findViewById(R.id.q1_content2)).isChecked() &&
                !((CheckBox) findViewById(R.id.q1_content3)).isChecked() &&
                ((CheckBox) findViewById(R.id.q1_content4)).isChecked()) {
            isQuestion1Correct = true;
        }

        //Look into question 2, the answer should be op4
        if (((RadioButton) findViewById(R.id.q2_content4)).isChecked()) {
            isQuestion2Correct = true;
        }

        //Look into question 3, the answer should be op2
        if (((RadioButton) findViewById(R.id.q3_content2)).isChecked()) {
            isQuestion3Correct = true;
        }

        //Look into question 4, the answer should contains the word montecristo
        if (((EditText) findViewById(R.id.q4_content)).getText().toString().matches("(.*)[m|M][o|O][n|N][t|T][e|E][c|C][r|R][i|I][s|S][t|T][o|O](.*)")) {
            isQuestion4Correct = true;
        }

        //Summary prompt dialog
        mSummaryMessage = getString(R.string.q1_summary_text, isQuestion1Correct) + "\n"
                + getString(R.string.q2_summary_text, isQuestion2Correct) + "\n"
                + getString(R.string.q3_summary_text, isQuestion3Correct) + "\n"
                + getString(R.string.q4_summary_text, isQuestion4Correct);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(mSummaryMessage)
                .setTitle(R.string.summary_title)
                .setPositiveButton(R.string.ok_text, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
