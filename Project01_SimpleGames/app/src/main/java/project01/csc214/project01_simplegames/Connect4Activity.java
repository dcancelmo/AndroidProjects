package project01.csc214.project01_simplegames;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Connect4Activity extends AppCompatActivity {

    private static final String TAG = "DANIEL_TAG";
    private static final String KEY_USER1 = "project01.csc214.project01_simplegames.username1";
    private static final String KEY_USER1_SCORE = "project01.csc214.project01_simplegames.user1Score";
    private static final String KEY_USER2 = "project01.csc214.project01_simplegames.username2";
    private static final String KEY_USER2_SCORE = "project01.csc214.project01_simplegames.user2Score";
    private static final String KEY_TURN_NAME = "project01.csc214.project01_simplegames.turnName";
    private static final String KEY_TURN = "project01.csc214.project01_simplegames.turn";


    private static String sUser1;
    private static int sUser1Score = 0;
    private static String sUser2;
    private static int sUser2Score = 0;
    private static String sTurnName = "Player 1";
    private static int sUserTurn = 0;
    private static boolean sQuitPress = false;
    private static boolean[][] sBoardArray = {
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect4);

        TextView mDisplayUser1 = (TextView) findViewById(R.id.user1Display);
        TextView mDisplayUser2 = (TextView) findViewById(R.id.user2Display);
        TextView mTurnName = (TextView) findViewById(R.id.turn_notifier_name);
        TextView mUser1Score = (TextView) findViewById(R.id.user1ScoreDisplay);
        TextView mUser2Score = (TextView) findViewById(R.id.user2ScoreDisplay);


        if (savedInstanceState != null) {
            sUser1 = savedInstanceState.getString(KEY_USER1);
            sUser2 = savedInstanceState.getString(KEY_USER2);
            sUser1Score = savedInstanceState.getInt(KEY_USER1_SCORE);
            sUser2Score = savedInstanceState.getInt(KEY_USER2_SCORE);
            sTurnName = savedInstanceState.getString(KEY_TURN_NAME);
            sUserTurn = savedInstanceState.getInt(KEY_TURN);

            mDisplayUser1.setText(sUser1);
            mDisplayUser2.setText(sUser2);
            mUser1Score.setText(Integer.toString(sUser1Score));
            mUser2Score.setText(Integer.toString(sUser2Score));
            mTurnName.setText(sTurnName);
        }

        Intent intent = getIntent();
        if (intent != null) {
            sUser1 = intent.getStringExtra(KEY_USER1);
            mDisplayUser1.setText(sUser1);
            mTurnName.setText(sUser1);
            sUser2 = intent.getStringExtra(KEY_USER2);
            mDisplayUser2.setText(sUser2);
            sUser1Score = intent.getIntExtra(KEY_USER1_SCORE, 0);
            sUser2Score = intent.getIntExtra(KEY_USER2_SCORE, 0);
            mUser1Score.setText(Integer.toString(sUser1Score));
            mUser2Score.setText(Integer.toString(sUser2Score));
        }

    }

    public void dropCol0(View view) {
        TextView mTurnName = (TextView) findViewById(R.id.turn_notifier_name);
        ImageView mCurrSlot = null;
        boolean mSlotFound = false;
        int row = 0;
        for (int i = 5; i >= 0; i--) {
            if (!sBoardArray[0][i]) {
                switch (i) {
                    case 0:
                        row = 0;
                        mCurrSlot = (ImageView) findViewById(R.id.slot00);
                        break;
                    case 1:
                        row = 1;
                        mCurrSlot = (ImageView) findViewById(R.id.slot01);
                        break;
                    case 2:
                        row = 2;
                        mCurrSlot = (ImageView) findViewById(R.id.slot02);
                        break;
                    case 3:
                        row = 3;
                        mCurrSlot = (ImageView) findViewById(R.id.slot03);
                        break;
                    case 4:
                        row = 4;
                        mCurrSlot = (ImageView) findViewById(R.id.slot04);
                        break;
                    case 5:
                        row = 5;
                        mCurrSlot = (ImageView) findViewById(R.id.slot05);
                        break;
                }
                sBoardArray[0][i] = true;
                mSlotFound = true;
                break;
            }
        }
        if (!mSlotFound) {
            Toast.makeText(Connect4Activity.this, R.string.column_full, Toast.LENGTH_LONG).show();
            return;
        }
        if (sUserTurn % 2 == 0) {
            mCurrSlot.setImageResource(R.mipmap.ic_black_checker);
            sTurnName = sUser2;
            mTurnName.setText(sUser2);
        } else {
            mCurrSlot.setImageResource(R.mipmap.ic_red_checker);
            sTurnName = sUser1;
            mTurnName.setText(sUser1);
        }
        sUserTurn++;
        checkWin(0, row);
    }

    public void dropCol1(View view) {
        TextView mTurnName = (TextView) findViewById(R.id.turn_notifier_name);
        ImageView mCurrSlot = null;
        boolean mSlotFound = false;
        int row = 0;
        for (int i = 5; i >= 0; i--) {
            if (!sBoardArray[1][i]) {
                switch (i) {
                    case 0:
                        row = 0;
                        mCurrSlot = (ImageView) findViewById(R.id.slot10);
                        break;
                    case 1:
                        row = 1;
                        mCurrSlot = (ImageView) findViewById(R.id.slot11);
                        break;
                    case 2:
                        row = 2;
                        mCurrSlot = (ImageView) findViewById(R.id.slot12);
                        break;
                    case 3:
                        row = 3;
                        mCurrSlot = (ImageView) findViewById(R.id.slot13);
                        break;
                    case 4:
                        row = 4;
                        mCurrSlot = (ImageView) findViewById(R.id.slot14);
                        break;
                    case 5:
                        row = 5;
                        mCurrSlot = (ImageView) findViewById(R.id.slot15);
                        break;
                }
                sBoardArray[1][i] = true;
                mSlotFound = true;
                break;
            }
        }
        if (!mSlotFound) {
            Toast.makeText(Connect4Activity.this, R.string.column_full, Toast.LENGTH_LONG).show();
            return;
        }
        if (sUserTurn % 2 == 0) {
            mCurrSlot.setImageResource(R.mipmap.ic_black_checker);
            sTurnName = sUser2;
            mTurnName.setText(sUser2);
        } else {
            mCurrSlot.setImageResource(R.mipmap.ic_red_checker);
            sTurnName = sUser1;
            mTurnName.setText(sUser1);
        }
        sUserTurn++;
        checkWin(1, row);
    }

    public void dropCol2(View view) {
        TextView mTurnName = (TextView) findViewById(R.id.turn_notifier_name);
        ImageView mCurrSlot = null;
        boolean mSlotFound = false;
        int row = 0;
        for (int i = 5; i >= 0; i--) {
            if (!sBoardArray[2][i]) {
                switch (i) {
                    case 0:
                        row = 0;
                        mCurrSlot = (ImageView) findViewById(R.id.slot20);
                        break;
                    case 1:
                        row = 1;
                        mCurrSlot = (ImageView) findViewById(R.id.slot21);
                        break;
                    case 2:
                        row = 2;
                        mCurrSlot = (ImageView) findViewById(R.id.slot22);
                        break;
                    case 3:
                        row = 3;
                        mCurrSlot = (ImageView) findViewById(R.id.slot23);
                        break;
                    case 4:
                        row = 4;
                        mCurrSlot = (ImageView) findViewById(R.id.slot24);
                        break;
                    case 5:
                        row = 5;
                        mCurrSlot = (ImageView) findViewById(R.id.slot25);
                        break;
                }
                sBoardArray[2][i] = true;
                mSlotFound = true;
                break;
            }
        }
        if (!mSlotFound) {
            Toast.makeText(Connect4Activity.this, R.string.column_full, Toast.LENGTH_LONG).show();
            return;
        }
        if (sUserTurn % 2 == 0) {
            mCurrSlot.setImageResource(R.mipmap.ic_black_checker);
            sTurnName = sUser2;
            mTurnName.setText(sUser2);
        } else {
            mCurrSlot.setImageResource(R.mipmap.ic_red_checker);
            sTurnName = sUser1;
            mTurnName.setText(sUser1);
        }
        sUserTurn++;
        checkWin(2, row);
    }

    public void dropCol3(View view) {
        TextView mTurnName = (TextView) findViewById(R.id.turn_notifier_name);
        ImageView mCurrSlot = null;
        boolean mSlotFound = false;
        int row = 0;
        for (int i = 5; i >= 0; i--) {
            if (!sBoardArray[3][i]) {
                switch (i) {
                    case 0:
                        row = 0;
                        mCurrSlot = (ImageView) findViewById(R.id.slot30);
                        break;
                    case 1:
                        row = 1;
                        mCurrSlot = (ImageView) findViewById(R.id.slot31);
                        break;
                    case 2:
                        row = 2;
                        mCurrSlot = (ImageView) findViewById(R.id.slot32);
                        break;
                    case 3:
                        row = 3;
                        mCurrSlot = (ImageView) findViewById(R.id.slot33);
                        break;
                    case 4:
                        row = 4;
                        mCurrSlot = (ImageView) findViewById(R.id.slot34);
                        break;
                    case 5:
                        row = 5;
                        mCurrSlot = (ImageView) findViewById(R.id.slot35);
                        break;
                }
                sBoardArray[3][i] = true;
                mSlotFound = true;
                break;
            }
        }
        if (!mSlotFound) {
            Toast.makeText(Connect4Activity.this, R.string.column_full, Toast.LENGTH_LONG).show();
            return;
        }
        if (sUserTurn % 2 == 0) {
            mCurrSlot.setImageResource(R.mipmap.ic_black_checker);
            sTurnName = sUser2;
            mTurnName.setText(sUser2);
        } else {
            mCurrSlot.setImageResource(R.mipmap.ic_red_checker);
            sTurnName = sUser1;
            mTurnName.setText(sUser1);
        }
        sUserTurn++;
        checkWin(3, row);
    }

    public void dropCol4(View view) {
        TextView mTurnName = (TextView) findViewById(R.id.turn_notifier_name);
        ImageView mCurrSlot = null;
        boolean mSlotFound = false;
        int row = 0;
        for (int i = 5; i >= 0; i--) {
            if (!sBoardArray[4][i]) {
                switch (i) {
                    case 0:
                        row = 0;
                        mCurrSlot = (ImageView) findViewById(R.id.slot40);
                        break;
                    case 1:
                         row = 1;
                        mCurrSlot = (ImageView) findViewById(R.id.slot41);
                        break;
                    case 2:
                        row = 2;
                        mCurrSlot = (ImageView) findViewById(R.id.slot42);
                        break;
                    case 3:
                        row = 3;
                        mCurrSlot = (ImageView) findViewById(R.id.slot43);
                        break;
                    case 4:
                        row = 4;
                        mCurrSlot = (ImageView) findViewById(R.id.slot44);
                        break;
                    case 5:
                        row = 5;
                        mCurrSlot = (ImageView) findViewById(R.id.slot45);
                        break;
                }
                sBoardArray[4][i] = true;
                mSlotFound = true;
                break;
            }
        }
        if (!mSlotFound) {
            Toast.makeText(Connect4Activity.this, R.string.column_full, Toast.LENGTH_LONG).show();
            return;
        }
        if (sUserTurn % 2 == 0) {
            mCurrSlot.setImageResource(R.mipmap.ic_black_checker);
            sTurnName = sUser2;
            mTurnName.setText(sUser2);
        } else {
            mCurrSlot.setImageResource(R.mipmap.ic_red_checker);
            sTurnName = sUser1;
            mTurnName.setText(sUser1);
        }
        sUserTurn++;
        checkWin(4, row);
    }

    public void dropCol5(View view) {
        TextView mTurnName = (TextView) findViewById(R.id.turn_notifier_name);
        ImageView mCurrSlot = null;
        boolean mSlotFound = false;
        int row = 0;
        for (int i = 5; i >= 0; i--) {
            if (!sBoardArray[5][i]) {
                switch (i) {
                    case 0:
                        row = 0;
                        mCurrSlot = (ImageView) findViewById(R.id.slot50);
                        break;
                    case 1:
                        row = 1;
                        mCurrSlot = (ImageView) findViewById(R.id.slot51);
                        break;
                    case 2:
                        row = 2;
                        mCurrSlot = (ImageView) findViewById(R.id.slot52);
                        break;
                    case 3:
                        row = 3;
                        mCurrSlot = (ImageView) findViewById(R.id.slot53);
                        break;
                    case 4:
                        row = 4;
                        mCurrSlot = (ImageView) findViewById(R.id.slot54);
                        break;
                    case 5:
                        row = 5;
                        mCurrSlot = (ImageView) findViewById(R.id.slot55);
                        break;
                }
                sBoardArray[5][i] = true;
                mSlotFound = true;
                break;
            }
        }
        if (!mSlotFound) {
            Toast.makeText(Connect4Activity.this, R.string.column_full, Toast.LENGTH_LONG).show();
            return;
        }
        if (sUserTurn % 2 == 0) {
            mCurrSlot.setImageResource(R.mipmap.ic_black_checker);
            sTurnName = sUser2;
            mTurnName.setText(sUser2);
        } else {
            mCurrSlot.setImageResource(R.mipmap.ic_red_checker);
            sTurnName = sUser1;
            mTurnName.setText(sUser1);
        }
        sUserTurn++;
        checkWin(5, row);
    }

    private void checkWin(int col, int row) {

        

        checkFull();
    }

    private void checkFull() {
        boolean mFull = true;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (!sBoardArray[i][j]) {
                    mFull = false;
                }
            }
        }
        if (mFull) {
            Toast.makeText(Connect4Activity.this, R.string.board_full, Toast.LENGTH_LONG).show();
            mFull = false;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    sBoardArray[i][j] = false;
                }
            }
            ImageView mCurrSlot = null;
            mCurrSlot = (ImageView) findViewById(R.id.slot00);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot01);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot02);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot03);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot04);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot05);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);

            mCurrSlot = (ImageView) findViewById(R.id.slot10);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot11);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot12);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot13);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot14);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot15);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);

            mCurrSlot = (ImageView) findViewById(R.id.slot20);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot21);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot22);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot23);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot24);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot25);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);

            mCurrSlot = (ImageView) findViewById(R.id.slot30);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot31);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot32);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot33);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot34);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot35);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);

            mCurrSlot = (ImageView) findViewById(R.id.slot40);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot41);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot42);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot43);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot44);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot45);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);

            mCurrSlot = (ImageView) findViewById(R.id.slot50);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot51);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot52);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot53);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot54);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);
            mCurrSlot = (ImageView) findViewById(R.id.slot55);
            mCurrSlot.setImageResource(R.mipmap.ic_null_checker);

        }
    }

    public void returnHome(View view) {
        if (!sQuitPress) {
            sQuitPress = true;
            Toast.makeText(Connect4Activity.this, R.string.confirm_quit, Toast.LENGTH_LONG).show();
        } else if (sQuitPress) {
            Intent intent = new Intent(Connect4Activity.this, MainActivity.class);
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
        state.putString(KEY_TURN_NAME, sTurnName);
        state.putInt(KEY_TURN, sUserTurn);
    }
}
