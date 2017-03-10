package project01.csc214.project01_simplegames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
    private static final String KEY_FEEDBACK = "project01.csc214.project01_simplegames.feedback";
    private static final String KEY_WORD = "project01.csc214.project01_simplegames.word";
    private static final String KEY_CURR_GUESS = "project01.csc214.project01_simplegames.currGuess";
    private static final String KEY_CURR_DISPLAY_WORD = "project01.csc214.project01_simplegames.currentDisplay";

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
        setContentView(R.layout.activity_hangman);
    }

    public void returnHome(View view) {
    }
}
