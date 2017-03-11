package project01.csc214.project01_simplegames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class HotColdActivity extends AppCompatActivity {

    private static final String TAG = "DANIEL_TAG";
    private static final String KEY_USER1 = "project01.csc214.project01_simplegames.username1";
    private static final String KEY_USER1_SCORE = "project01.csc214.project01_simplegames.user1Score";
    private static final String KEY_USER1_GUESS = "project01.csc214.project01_simplegames.user1Guess";
    private static final String KEY_USER2 = "project01.csc214.project01_simplegames.username2";
    private static final String KEY_USER2_SCORE = "project01.csc214.project01_simplegames.user2Score";
    private static final String KEY_USER2_GUESS = "project01.csc214.project01_simplegames.user2Guess";
    private static final String KEY_TURN_NAME = "project01.csc214.project01_simplegames.turnName";
    private static final String KEY_TURN = "project01.csc214.project01_simplegames.turn";
    private static final String KEY_FEEDBACK = "project01.csc214.project01_simplegames.feedback";
    private static final String KEY_RANDNUM = "project01.csc214.project01_simplegames.randNum";
    private static final String KEY_CURR_GUESS = "project01.csc214.project01_simplegames.currGuess";

    private static Random sRand = new Random();

    private static String sUser1;
    private static int sUser1Score = 0;
    private static int sUser1Guesses = 0;
    private static String sUser2;
    private static int sUser2Score = 0;
    private static int sUser2Guesses = 0;
    private static String sTurnName = "Player 1";
    private static int sUserTurn = 1;
    private static String sFeedback = "Enter your guess...";
    private static int sRandNum = -1;
    private static int sCurrGuess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_cold);
        Log.i(TAG, "onCreate() called[Hot Cold]");

        TextView mDisplayUser1 = (TextView) findViewById(R.id.user1Display);
        TextView mGuessDisplayUser1 = (TextView) findViewById(R.id.user1_guess_name);
        TextView mUser1Score = (TextView) findViewById(R.id.user1ScoreDisplay);
        TextView mDisplayUser2 = (TextView) findViewById(R.id.user2Display);
        TextView mGuessDisplayUser2 = (TextView) findViewById(R.id.user2_guess_name);
        TextView mUser2Score = (TextView) findViewById(R.id.user2ScoreDisplay);
        TextView mTurnName = (TextView) findViewById(R.id.turn_notifier_name);
        TextView mFeedback = (TextView) findViewById(R.id.hotColdFeedback);
        TextView mGuessCountUser1 = (TextView) findViewById(R.id.user1_guess_count);
        TextView mGuessCountUser2 = (TextView) findViewById(R.id.user2_guess_count);

        Intent intent = getIntent();

        if (savedInstanceState != null) {
            sUser1 = savedInstanceState.getString(KEY_USER1);
            sUser2 = savedInstanceState.getString(KEY_USER2);
            sUser1Score = savedInstanceState.getInt(KEY_USER1_SCORE, 0);
            sUser2Score = savedInstanceState.getInt(KEY_USER2_SCORE, 0);
            sUser1Guesses = savedInstanceState.getInt(KEY_USER1_GUESS);
            sUser2Guesses = savedInstanceState.getInt(KEY_USER2_GUESS);
            sTurnName = savedInstanceState.getString(KEY_TURN_NAME);
            sUserTurn = savedInstanceState.getInt(KEY_TURN, 0);
            sFeedback = savedInstanceState.getString(KEY_FEEDBACK);
            sRandNum = savedInstanceState.getInt(KEY_RANDNUM, -1);
            sCurrGuess = savedInstanceState.getInt(KEY_CURR_GUESS, 0);

            mDisplayUser1.setText(sUser1);
            mDisplayUser2.setText(sUser2);

            mUser1Score.setText(Integer.toString(sUser1Score));
            mUser2Score.setText(Integer.toString(sUser2Score));

            mGuessDisplayUser1.setText(sUser1);
            mGuessDisplayUser2.setText(sUser2);

            mGuessCountUser1.setText(Integer.toString(sUser1Guesses));
            mGuessCountUser2.setText(Integer.toString(sUser2Guesses));

            mTurnName.setText(sTurnName);
            mFeedback.setText(sFeedback);
        } else if (intent != null) {
            sUser1 = intent.getStringExtra(KEY_USER1);
            mDisplayUser1.setText(sUser1);
            mGuessDisplayUser1.setText(sUser1);
            mTurnName.setText(sUser1);
            sUser2 = intent.getStringExtra(KEY_USER2);
            mDisplayUser2.setText(sUser2);
            mGuessDisplayUser2.setText(sUser2);
            sUser1Score = intent.getIntExtra(KEY_USER1_SCORE, 0);
            mUser1Score.setText(Integer.toString(sUser1Score));
            sUser2Score = intent.getIntExtra(KEY_USER2_SCORE, 0);
            mUser2Score.setText(Integer.toString(sUser2Score));
        }

        if (sRandNum == -1) {
            sRandNum = sRand.nextInt(21);
        }

    }

    public void confirmGuess(View view) {

        EditText mUserGuessText = (EditText) findViewById(R.id.hotColdGuessBox);
        sCurrGuess = Integer.parseInt(mUserGuessText.getText().toString());
        TextView mFeedbackBox = (TextView) findViewById(R.id.hotColdFeedback);
        TextView mGuessCountUser1 = (TextView) findViewById(R.id.user1_guess_count);
        TextView mGuessCountUser2 = (TextView) findViewById(R.id.user2_guess_count);
        TextView mUser1Score = (TextView) findViewById(R.id.user1ScoreDisplay);
        TextView mUser2Score = (TextView) findViewById(R.id.user2ScoreDisplay);
        if (sUserTurn % 2 != 0) {
            sUser1Guesses++;
            mGuessCountUser1.setText(Integer.toString(sUser1Guesses));
        } else {
            sUser2Guesses++;
            mGuessCountUser2.setText(Integer.toString(sUser2Guesses));
        }
        if (sCurrGuess == sRandNum) {
            mFeedbackBox.setText(getResources().getString(R.string.correct));
            if (sUserTurn % 2 == 0) {
                int mScoreDiff = sUser1Guesses - sUser2Guesses;
                if (mScoreDiff < 0) {
                    sUser1Score += Math.abs(mScoreDiff*100);
                    mUser1Score.setText(Integer.toString(sUser1Score));
                } else {
                    sUser2Score += Math.abs(mScoreDiff)*100;
                    mUser2Score.setText(Integer.toString(sUser2Score));
                }
                sUser1Guesses = 0;
                sUser2Guesses = 0;
                mGuessCountUser1.setText(Integer.toString(sUser1Guesses));
                mGuessCountUser2.setText(Integer.toString(sUser2Guesses));
                sRandNum = sRand.nextInt(21);
                sTurnName = sUser1;
            } else {
                sRandNum = sRand.nextInt(21);
                sTurnName = sUser2;
            }
            sUserTurn++;
            TextView mTurnName = (TextView) findViewById(R.id.turn_notifier_name);
            mTurnName.setText(sTurnName);
        } else {
            int mGuessDiff = Math.abs(sRandNum - sCurrGuess);
            if (mGuessDiff > 17) {
                mFeedbackBox.setText(getResources().getString(R.string.absolute_zero));
            } else if (mGuessDiff > 15) {
                mFeedbackBox.setText(getResources().getString(R.string.freezing));
            } else if (mGuessDiff > 12) {
                mFeedbackBox.setText(getResources().getString(R.string.colder));
            } else if (mGuessDiff > 9) {
                mFeedbackBox.setText(getResources().getString(R.string.cold));
            } else if (mGuessDiff > 5) {
                mFeedbackBox.setText(getResources().getString(R.string.warm));
            } else if (mGuessDiff > 3) {
                mFeedbackBox.setText(getResources().getString(R.string.warmer));
            } else if (mGuessDiff > 1) {
                mFeedbackBox.setText(getResources().getString(R.string.hot));
            } else if (mGuessDiff == 1) {
                mFeedbackBox.setText(getResources().getString(R.string.on_fire));
            }

        }

    }

    public void returnHome(View view) {
        Intent intent = new Intent(HotColdActivity.this, MainActivity.class);
        intent.putExtra(KEY_USER1, sUser1);
        intent.putExtra(KEY_USER2, sUser2);
        intent.putExtra(KEY_USER1_SCORE, sUser1Score);
        intent.putExtra(KEY_USER2_SCORE, sUser2Score);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        state.putString(KEY_USER1, sUser1);
        state.putString(KEY_USER2, sUser2);
        state.putInt(KEY_USER1_SCORE, sUser1Score);
        state.putInt(KEY_USER2_SCORE, sUser2Score);
        state.putInt(KEY_USER1_GUESS, sUser1Guesses);
        state.putInt(KEY_USER2_GUESS, sUser2Guesses);
        state.putString(KEY_TURN_NAME, sTurnName);
        state.putInt(KEY_TURN, sUserTurn);
        state.putString(KEY_FEEDBACK, sFeedback);
        state.putInt(KEY_RANDNUM, sRandNum);
        state.putInt(KEY_CURR_GUESS, sCurrGuess);
    }
}
