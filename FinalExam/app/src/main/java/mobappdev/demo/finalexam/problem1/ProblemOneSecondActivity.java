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

public class ProblemOneSecondActivity extends AppCompatActivity {

    private static final String TAG = "LogLifeProb1Activ2";

    private static final String ET_OP1 = "mobappdev.demo.finalexam.problem1.et_op1";
    private static final String ET_OP2 = "mobappdev.demo.finalexam.problem1.et_op2";
    private static final String PROB1_RESULT = "mobappdev.demo.finalexam.problem1.problem1_result";

    private double mResultInitialNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_one_second);
        Log.i(TAG, "onCreate(Bundle) called");
        TextView mDecNumberTextView = (TextView) findViewById(R.id.tv_op1);
        TextView mExpNumberTextView = (TextView) findViewById(R.id.tv_op2);
        TextView mResultTextView = (TextView) findViewById(R.id.tv_result);
        Intent mIntent = getIntent();
        if (mIntent != null) {
            String mDecNum = mIntent.getStringExtra(ET_OP1);
            String mExpNum = mIntent.getStringExtra(ET_OP2);
            mDecNumberTextView.setText(mDecNum);
            mExpNumberTextView.setText(mExpNum);
            mResultInitialNum = Math.pow(Integer.parseInt(mDecNum), Integer.parseInt(mExpNum));
            mResultTextView.setText(Double.toString(mResultInitialNum));
        }

    }

    public void subtractClicked(View view) {
        EditText mSubtractEditText = (EditText) findViewById(R.id.et_subtract);
        String mSubtractString = mSubtractEditText.getText().toString();
        double mSubtractNum = Double.parseDouble(mSubtractString);
        double mResult = mResultInitialNum - mSubtractNum;
        String mResultString = Double.toString(mResult);
        Intent mIntent = getIntent();
        mIntent.putExtra(PROB1_RESULT, mResultString);
        setResult(Activity.RESULT_OK, mIntent);
        finish();
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
