package mobappdev.demo.finalexam.problem1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import mobappdev.demo.finalexam.R;

public class ProblemOneFirstActivity extends AppCompatActivity {

    private static final String TAG = "LogLifeProb1Activ1";

    private static final String ET_OP1 = "mobappdev.demo.finalexam.problem1.et_op1";
    private static final String ET_OP2 = "mobappdev.demo.finalexam.problem1.et_op2";
    private static final String PROB1_RESULT = "mobappdev.demo.finalexam.problem1.problem1_result";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_one_first);
        Log.i(TAG, "onCreate(Bundle) called");
    }

    public void powClicked(View view) {
        Intent mIntent = new Intent(ProblemOneFirstActivity.this, ProblemOneSecondActivity.class);
        EditText mOp1EditText = (EditText) findViewById(R.id.et_op1);
        EditText mOp2EditText = (EditText) findViewById(R.id.et_op2);
        mIntent.putExtra(ET_OP1, mOp1EditText.getText().toString());
        mIntent.putExtra(ET_OP2, mOp2EditText.getText().toString());
        startActivityForResult(mIntent, 0);
    }

    @Override
    protected void onActivityResult(int mRequestCode, int mResultCode, Intent mIntent) {
        if (mRequestCode == 0) {
            if (mResultCode == Activity.RESULT_OK) {
                TextView mFinalResult = (TextView) findViewById(R.id.tv_result);
                mFinalResult.setText(mIntent.getStringExtra(PROB1_RESULT));
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy() called");
    }
}
