package homework09.csc214.homework09_multithreading;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PrimeActivity extends AppCompatActivity {

    public static final String TAG = "CANCELMOTESTING";

    public long mUserNum;
    EditText mLongEntry;
    TextView mAnswerDisplay;
    Long mOrigInput;
    Double mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime);
        mLongEntry = (EditText) findViewById(R.id.long_entry);
        mAnswerDisplay = (TextView) findViewById(R.id.answer_display);
    }

    public void startFindSquareRoot(View view) {
        Log.i(TAG, "startFindSquareRoot called w/ input " + Long.parseLong(mLongEntry.getText().toString()));
        if (checkValid(view)) {
            Log.i(TAG, "called w/ valid input " + Long.parseLong(mLongEntry.getText().toString()));
            //mOrigInput = Long.parseLong(mLongEntry.getText().toString());
            new CalculateRootTask().execute(Long.parseLong(mLongEntry.getText().toString()));
            Log.i(TAG, "FindSquareRoot done");
            Toast.makeText(this, getResources().getString(R.string.square_root), Toast.LENGTH_LONG).show();
        }
    }

    public void startFindLargePrime(View view) {
        Log.i(TAG, "startFindLargePrime called w/ input " + Long.parseLong(mLongEntry.getText().toString()));
        if (checkValid(view)) {
            Log.i(TAG, "called w/ valid input " + Long.parseLong(mLongEntry.getText().toString()));
            //mOrigInput = Long.parseLong(mLongEntry.getText().toString());
            new CalculatePrimeTask().execute(Long.parseLong(mLongEntry.getText().toString()));
            Toast.makeText(this, getResources().getString(R.string.largest_prime), Toast.LENGTH_LONG).show();
        }
    }

    private class CalculateRootTask extends AsyncTask<Long,Void,Double> {
        @Override
        protected Double doInBackground(Long... params) {
            Log.i(TAG, "rootTask created");
            Long mParam = params[0];
            Double mResultRoot = Math.sqrt(mParam);
            Log.i(TAG, "root: " + mResultRoot);
            return mResultRoot;
        }
        @Override
        protected void onPostExecute(Double mResult) {
            Log.i(TAG, "root: " + mResult);
            mAnswerDisplay.setText(mResult.toString());
        }
    }

    private class CalculatePrimeTask extends AsyncTask<Long,Void,Long> {
        @Override
        protected Long doInBackground(Long... params) {
            //check every odd below to see if divisibile by any number from 2 to sqrt of that number, int-- then repeat until reach 2
            Log.i(TAG, "rootTask created");
            for (Long i = params[0]; i > 2; i--){
                if (isPrime(i)) {
                    Log.i(TAG, "Result: " + i);
                    return i;
                }
            }
            Log.i(TAG, "Result: " + params[0]);
            return params[0];
        }
        @Override
        protected void onPostExecute(Long mResult1) {
            Log.i(TAG, "Result: " + mResult1);
            mAnswerDisplay.setText(Long.toString(mResult1));
        }

        public boolean isPrime(long mValue) {
            for (long i = 2; i < mValue; i++) {
                if (mValue % i == 0) {
                    Log.i(TAG, i + " not prime");
                    return false; //not prime
                }
            }
            return true; //prime
        }
    }

//    public static Intent newIntent(Context c) {
//        return new Intent(c, PrimeActivity.class);
//    }
//
//    public AsyncFragment createFragment() {
//        return AsyncFragment.newInstance();
//    }

    public boolean checkValid(View view) {
        long mTemp;
        try {
            mTemp = Long.valueOf(mLongEntry.getText().toString());
        } catch(NumberFormatException e) {
            Toast.makeText(this, R.string.not_a_valid_long, Toast.LENGTH_LONG).show();
            return false;
        }
        if (mTemp >= 2) {
            Log.i(TAG, ">= 2");
            mUserNum = mTemp;
            return true;
        } else {
            Log.i(TAG, "< 2");
            Toast.makeText(this, R.string.value_greater_than_equal_2, Toast.LENGTH_LONG).show();
            return false;
        }
    }
}
