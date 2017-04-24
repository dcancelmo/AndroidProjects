package homework09.csc214.homework09_multithreading;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PrimeActivity extends AppCompatActivity {

    public long mUserNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime);
    }

    public void startFindSquareRoot(View view) {
        if (!checkValid(view)) {
            //Method
        }
    }

    public void startFindLargePrime(View view) {
        if (!checkValid(view)) {
            //Method
        }
    }

    public static Intent newIntent(Context c) {
        return new Intent(c, PrimeActivity.class);
    }

    public AsyncFragment createFragment() {
        return AsyncFragment.newInstance();
    }

    public boolean checkValid(View view) {
        EditText mLongEntry = (EditText) findViewById(R.id.long_entry);
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
