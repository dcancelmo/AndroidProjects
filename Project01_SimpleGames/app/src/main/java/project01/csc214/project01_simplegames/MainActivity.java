package project01.csc214.project01_simplegames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DANIEL_TAG";
    private static final String KEY_USER1 = "project01.csc214.project01_simplegames.username1";
    private static final String KEY_USER1_SCORE = "project01.csc214.project01_simplegames.user1Score";
    private static final String KEY_USER2 = "project01.csc214.project01_simplegames.username2";
    private static final String KEY_USER2_SCORE = "project01.csc214.project01_simplegames.user2Score";

    private static final int RC_HOT = 2;
    private static final int RC_HANG = 3;
    private static final int RC_CONNECT = 4;

    private static String sUser1 = "Player 1";
    private static int sUser1Score = 0;
    private static String sUser2 = "Player 2";
    private static int sUser2Score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate() called[main]");

        if (savedInstanceState != null) {
            sUser1 = savedInstanceState.getString(KEY_USER1);
            sUser2 = savedInstanceState.getString(KEY_USER2);
            EditText mEditTextUser1 = (EditText) findViewById(R.id.user1_edittext);
            TextView mDisplayUser1 = (TextView) findViewById(R.id.user1Display);

            mEditTextUser1.setText(sUser1);
            mDisplayUser1.setText(sUser1);
            EditText mEditTextUser2 = (EditText) findViewById(R.id.user2_edittext);
            TextView mDisplayUser2 = (TextView) findViewById(R.id.user2Display);
            mEditTextUser2.setText(sUser2);
            mDisplayUser2.setText(sUser2);

            TextView mDisplayUserScore1 = (TextView) findViewById(R.id.user1ScoreDisplay);
            mDisplayUserScore1.setText(Integer.toString(sUser1Score));
            TextView mDisplayUserScore2 = (TextView) findViewById(R.id.user2ScoreDisplay);
            mDisplayUserScore2.setText(Integer.toString(sUser2Score));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        TextView mDisplayUserScore1 = (TextView) findViewById(R.id.user1ScoreDisplay);
        mDisplayUserScore1.setText(Integer.toString(sUser1Score));
        TextView mDisplayUserScore2 = (TextView) findViewById(R.id.user2ScoreDisplay);
        mDisplayUserScore2.setText(Integer.toString(sUser2Score));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Log.i(TAG, "onActivityResultCalled");
        TextView mDisplayUserScore1 = (TextView) findViewById(R.id.user1ScoreDisplay);
        TextView mDisplayUserScore2 = (TextView) findViewById(R.id.user2ScoreDisplay);
        sUser1Score = intent.getIntExtra(KEY_USER1_SCORE, sUser1Score);
        sUser2Score = intent.getIntExtra(KEY_USER2_SCORE, sUser2Score);
        mDisplayUserScore1.setText(Integer.toString(sUser1Score));
        mDisplayUserScore2.setText(Integer.toString(sUser2Score));
    }

    public void startHotCold(View view) {
        Log.i(TAG, "startHotCold called");
        Intent intent = new Intent(MainActivity.this, HotColdActivity.class);
        intent.putExtra(KEY_USER1, sUser1);
        intent.putExtra(KEY_USER2, sUser2);
        intent.putExtra(KEY_USER1_SCORE, sUser1Score);
        intent.putExtra(KEY_USER2_SCORE, sUser2Score);
        startActivityForResult(intent, RC_HOT);
    }

    public void startHangman(View view) {
        Log.i(TAG, "startHangman called");
        Intent intent = new Intent(MainActivity.this, HangmanActivity.class);
        intent.putExtra(KEY_USER1, sUser1);
        intent.putExtra(KEY_USER2, sUser2);
        intent.putExtra(KEY_USER1_SCORE, sUser1Score);
        intent.putExtra(KEY_USER2_SCORE, sUser2Score);
        startActivityForResult(intent, RC_HANG);
    }

    public void startConnect4(View view) {
        Log.i(TAG, "startConnect4 called");
        Intent intent = new Intent(MainActivity.this, Connect4Activity.class);
        intent.putExtra(KEY_USER1, sUser1);
        intent.putExtra(KEY_USER2, sUser2);
        intent.putExtra(KEY_USER1_SCORE, sUser1Score);
        intent.putExtra(KEY_USER2_SCORE, sUser2Score);
        startActivityForResult(intent, RC_CONNECT);
    }

    public void acceptNames(View view) {
        Log.i(TAG, "acceptNames called");
        EditText mEditTextUser1 = (EditText) findViewById(R.id.user1_edittext);
        TextView mDisplayUser1 = (TextView) findViewById(R.id.user1Display);
        if (mEditTextUser1.getText().toString().length() > 0) {
            sUser1 = mEditTextUser1.getText().toString();
            mDisplayUser1.setText(sUser1);
        } else {
            sUser1 = getResources().getString(R.string.player_1);
            mDisplayUser1.setText(sUser1);
        }
        EditText mEditTextUser2 = (EditText) findViewById(R.id.user2_edittext);
        TextView mDisplayUser2 = (TextView) findViewById(R.id.user2Display);
        if (mEditTextUser2.getText().toString().length() > 0) {
            sUser2 = mEditTextUser2.getText().toString();
            mDisplayUser2.setText(sUser2);
        } else {
            sUser2 = getResources().getString(R.string.player_2);
            mDisplayUser2.setText(sUser2);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        state.putString(KEY_USER1, sUser1);
        state.putString(KEY_USER2, sUser2);
        state.putInt(KEY_USER1_SCORE, sUser1Score);
        state.putInt(KEY_USER2_SCORE, sUser2Score);
    }
}
