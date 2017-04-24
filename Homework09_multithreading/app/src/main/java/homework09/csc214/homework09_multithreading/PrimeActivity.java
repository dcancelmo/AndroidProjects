package homework09.csc214.homework09_multithreading;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PrimeActivity extends AppCompatActivity {

    public long mUserNum;
    EditText mLongEntry;
    TextView mAnswerDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime);
        mLongEntry = (EditText) findViewById(R.id.long_entry);
        mAnswerDisplay = (TextView) findViewById(R.id.answer_display);
    }

    public void startFindSquareRoot(View view) {
        if (!checkValid(view)) {
            new CalculateRootTask().execute(Long.getLong(mLongEntry.getText().toString()));
        }
    }

    public void startFindLargePrime(View view) {
        if (!checkValid(view)) {
            //Method
        }
    }

    private class CalculateRootTask extends AsyncTask<Long,Void,Double> {

        @Override
        protected Double doInBackground(Long... params) {
            Double mResult = Math.sqrt(params[0]);
            return mResult;
        }

        @Override
        protected void onPostExecute(Double mResult) {
            mAnswerDisplay.setText(String.valueOf(mResult));
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
            mUserNum = mTemp;
            return true;
        } else {
            Toast.makeText(this, R.string.value_greater_than_equal_2, Toast.LENGTH_LONG).show();
            return false;
        }
    }
}
