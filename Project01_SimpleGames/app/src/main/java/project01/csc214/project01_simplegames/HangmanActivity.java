package project01.csc214.project01_simplegames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class HangmanActivity extends AppCompatActivity {

    private static final String TAG = "DANIEL_TAG";
    private static final String KEY_USER1 = "project01.csc214.project01_simplegames.username1";
    private static final String KEY_USER1_SCORE = "project01.csc214.project01_simplegames.user1Score";
    private static final String KEY_USER1_MISSES = "project01.csc214.project01_simplegames.user1Misses";
    private static final String KEY_USER2 = "project01.csc214.project01_simplegames.username2";
    private static final String KEY_USER2_SCORE = "project01.csc214.project01_simplegames.user2Score";
    private static final String KEY_USER2_MISSES = "project01.csc214.project01_simplegames.user2Misses";
    private static final String KEY_TURN_NAME = "project01.csc214.project01_simplegames.turnName";
    private static final String KEY_TURN = "project01.csc214.project01_simplegames.turn";
    private static final String KEY_WORD = "project01.csc214.project01_simplegames.word";
    private static final String KEY_CURR_GUESS = "project01.csc214.project01_simplegames.currGuess";
    private static final String KEY_FOUND_LETTERS = "project01.csc214.project01_simplegames.foundLetters";
    private static final String KEY_CURR_DISPLAY_WORD = "project01.csc214.project01_simplegames.displayWord";
    private static final String KEY_GRAVEYARD = "project01.csc214.project01_simplegames.graveyard";

    private static Random sRand = new Random();

    private static String sUser1;
    private static int sUser1Score = 0;
    private static int sUser1Misses = 0;
    private static String sUser2;
    private static int sUser2Score = 0;
    private static int sUser2Misses = 0;
    private static String sTurnName = "Player 1";
    private static int sUserTurn = 0;
    private static int sRandNum = -1;
    private static String sCurrGuess;
    private static String sWord;
    private static String sCurrDisplayWord = "";
    private static String sFoundLetters = "";
    private static boolean sQuitPress = false;
    private static String sGraveyardChar = "";
    private static String[] sWordBank = {"computer", "science", "android", "programming", "quadrangle", "java", "library", "assembly", "fraternity", "rochester"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);
        Log.i(TAG, "onCreate() called[hangman]");


        TextView mDisplayUser1 = (TextView) findViewById(R.id.user1Display);
        TextView mMissDisplayNameUser1 = (TextView) findViewById(R.id.user1_miss_name);
        TextView mDisplayUser2 = (TextView) findViewById(R.id.user2Display);
        TextView mMissDisplayNameUser2 = (TextView) findViewById(R.id.user2_miss_name);
        TextView mTurnName = (TextView) findViewById(R.id.turn_notifier_name);

        if (sRandNum == -1) {
            sRandNum = sRand.nextInt(10);
            sWord = sWordBank[sRandNum];
        }

        if (savedInstanceState != null) {
            sUser1 = savedInstanceState.getString(KEY_USER1);
            sUser2 = savedInstanceState.getString(KEY_USER2);
            sUser1Score = savedInstanceState.getInt(KEY_USER1_SCORE);
            sUser2Score = savedInstanceState.getInt(KEY_USER2_SCORE);
            sUser1Misses = savedInstanceState.getInt(KEY_USER1_MISSES);
            sUser2Misses = savedInstanceState.getInt(KEY_USER2_MISSES);
            sTurnName = savedInstanceState.getString(KEY_TURN_NAME);
            sUserTurn = savedInstanceState.getInt(KEY_TURN);
            sCurrGuess = savedInstanceState.getString(KEY_CURR_GUESS);
            sWord = savedInstanceState.getString(KEY_WORD);
            sCurrDisplayWord = savedInstanceState.getString(KEY_CURR_DISPLAY_WORD);
            sFoundLetters = savedInstanceState.getString(KEY_FOUND_LETTERS);
            sGraveyardChar = savedInstanceState.getString(KEY_GRAVEYARD);
        }

        Intent intent = getIntent();
        if (intent != null) {
            sUser1 = intent.getStringExtra(KEY_USER1);
            mDisplayUser1.setText(sUser1);
            mMissDisplayNameUser1.setText(sUser1);
            mTurnName.setText(sUser1);
            sUser2 = intent.getStringExtra(KEY_USER2);
            mDisplayUser2.setText(sUser2);
            mMissDisplayNameUser2.setText(sUser2);
            sUser1Score = intent.getIntExtra(KEY_USER1_SCORE, 0);
            sUser2Score = intent.getIntExtra(KEY_USER2_SCORE, 0);
        }
        updateDisplay();
    }

    public void updateDisplay() {
        TextView mMissCountUser1 = (TextView) findViewById(R.id.user1_miss_count);
        TextView mMissCountUser2 = (TextView) findViewById(R.id.user2_miss_count);
        TextView mUser1Score = (TextView) findViewById(R.id.user1ScoreDisplay);
        TextView mUser2Score = (TextView) findViewById(R.id.user2ScoreDisplay);
        TextView mTurnNotifier = (TextView) findViewById(R.id.turn_notifier_name);
        TextView mGraveyard = (TextView) findViewById(R.id.graveyard);
        ImageView mGallows = (ImageView) findViewById(R.id.gallows);
        TextView mCurrDisplayWord = (TextView) findViewById(R.id.curr_display_word);


        mMissCountUser1.setText(Integer.toString(sUser1Misses));
        mMissCountUser2.setText(Integer.toString(sUser2Misses));
        mUser1Score.setText(Integer.toString(sUser1Score));
        mUser2Score.setText(Integer.toString(sUser2Score));
        mTurnNotifier.setText(sTurnName);
        mGraveyard.setText(sGraveyardChar);
        int mCurrMisses = 0;
        if (sUserTurn % 2 == 0) {
            mCurrMisses = sUser1Misses;
        } else {
            mCurrMisses = sUser2Misses;
        }
        switch (mCurrMisses) {
            case 0:
                mGallows.setImageResource(R.drawable.blank);
                break;
            case 1:
                mGallows.setImageResource(R.drawable.gallows);
                break;
            case 2:
                mGallows.setImageResource(R.drawable.head);
                break;
            case 3:
                mGallows.setImageResource(R.drawable.body);
                break;
            case 4:
                mGallows.setImageResource(R.drawable.arm1);
                break;
            case 5:
                mGallows.setImageResource(R.drawable.arm2);
                break;
            case 6:
                mGallows.setImageResource(R.drawable.leg1);
                break;
            case 7:
                mGallows.setImageResource(R.drawable.leg2);
                break;
            case 8:
                mGallows.setImageResource(R.drawable.face);
                break;
        }
        sCurrDisplayWord = "";
        for (int j = 0; j < sWord.length(); j++) {
            if (sFoundLetters.contains(Character.toString(sWord.charAt(j)))) {
                sCurrDisplayWord += Character.toString(sWord.charAt(j));
            } else {
                sCurrDisplayWord += "_";
            }
        }
        mCurrDisplayWord.setText(sCurrDisplayWord);
    }

    public void confirmLetter(View view) {
        sQuitPress = false;
        boolean mFound = false;
        EditText mWordSubmit = (EditText) findViewById(R.id.word_submission);
        sCurrGuess = mWordSubmit.getText().toString();
        if (sCurrGuess.length() != 1) {
            Toast.makeText(HangmanActivity.this, R.string.invalid_word, Toast.LENGTH_SHORT).show();
            return;
        }
        for (int i = 0; i < sWord.length(); i++) {
            if (sWord.charAt(i) == sCurrGuess.toCharArray()[0]) {
                mFound = true;
                sFoundLetters += sCurrGuess;
            }
        }
        if (!mFound) {
            if (!sGraveyardChar.contains(sCurrGuess)) {
                if (sUserTurn % 2 == 0) sUser1Misses++;
                else sUser2Misses++;
                sGraveyardChar += sCurrGuess;
            } else {
                Toast.makeText(HangmanActivity.this, R.string.already_guess, Toast.LENGTH_SHORT).show();
            }
        }
        sCurrDisplayWord = "";
        for (int j = 0; j < sWord.length(); j++) {
            if (sFoundLetters.contains(Character.toString(sWord.charAt(j)))) {
                sCurrDisplayWord += Character.toString(sWord.charAt(j));
            } else {
                sCurrDisplayWord += "_";
            }
        }

        checkComplete();
        updateDisplay();

    }

    private void checkComplete() {
        int mCurrMisses = 0;
        if (sUserTurn % 2 == 0) {
            mCurrMisses = sUser1Misses;
        } else {
            mCurrMisses = sUser2Misses;
        }
        if (sCurrDisplayWord.equals(sWord)) {
            Toast.makeText(HangmanActivity.this, R.string.word_found, Toast.LENGTH_SHORT).show();
            if (sUserTurn % 2 == 0) {
                sTurnName = sUser1;
            } else {
                sTurnName = sUser2;
                checkWin();
            }
            sUserTurn++;
            sFoundLetters = "";
            sCurrDisplayWord = "";
            sGraveyardChar = "";
            EditText mCharSubmit = (EditText) findViewById(R.id.word_submission);
            mCharSubmit.setText("");
        } else if (mCurrMisses >= 8) {
            Toast.makeText(HangmanActivity.this, R.string.out_of_guesses, Toast.LENGTH_SHORT).show();
            sUserTurn++;
            checkWin();
        }
        if (sUserTurn % 2 == 0) {
            sTurnName = sUser1;
        } else {
            sTurnName = sUser2;
        }
    }

    private void checkWin() {
        Log.i(TAG, "checkWin called");
        int mScoreDiff = sUser1Misses - sUser2Misses;
        if (mScoreDiff < 0) {
            Toast.makeText(HangmanActivity.this, R.string.player1_win, Toast.LENGTH_LONG).show();
            sUser1Score += Math.abs(mScoreDiff * 100);
        } else if (mScoreDiff > 0) {
            Toast.makeText(HangmanActivity.this, R.string.player2_win, Toast.LENGTH_LONG).show();
            sUser2Score += Math.abs(mScoreDiff) * 100;
        } else {
            Toast.makeText(HangmanActivity.this, R.string.draw, Toast.LENGTH_LONG).show();
        }
        sUser1Misses = 0;
        sUser2Misses = 0;
        sRandNum = sRand.nextInt(10);
        sWord = sWordBank[sRandNum];
        sFoundLetters = "";
        sCurrDisplayWord = "";
        sGraveyardChar = "";
    }

    public void returnHome(View view) {
        if (!sQuitPress) {
            sQuitPress = true;
            Toast.makeText(HangmanActivity.this, R.string.confirm_quit, Toast.LENGTH_LONG).show();
        } else if (sQuitPress) {
            Intent intent = new Intent(HangmanActivity.this, MainActivity.class);
            intent.putExtra(KEY_USER1, sUser1);
            intent.putExtra(KEY_USER2, sUser2);
            intent.putExtra(KEY_USER1_SCORE, sUser1Score);
            intent.putExtra(KEY_USER2_SCORE, sUser2Score);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        state.putString(KEY_USER1, sUser1);
        state.putString(KEY_USER2, sUser2);
        state.putInt(KEY_USER1_SCORE, sUser1Score);
        state.putInt(KEY_USER2_SCORE, sUser2Score);
        state.putInt(KEY_USER1_MISSES, sUser1Misses);
        state.putInt(KEY_USER2_MISSES, sUser2Misses);
        state.putString(KEY_TURN_NAME, sTurnName);
        state.putInt(KEY_TURN, sUserTurn);
        state.putString(KEY_CURR_DISPLAY_WORD, sCurrDisplayWord);
        state.putString(KEY_CURR_GUESS, sCurrGuess);
        state.putString(KEY_WORD, sWord);
        state.putString(KEY_FOUND_LETTERS, sFoundLetters);
        state.putString(KEY_GRAVEYARD, sGraveyardChar);
    }

}
