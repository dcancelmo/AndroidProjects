package assignment04.csc214.homework4_fragments;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static android.graphics.Typeface.BOLD;
import static android.graphics.Typeface.BOLD_ITALIC;
import static android.graphics.Typeface.ITALIC;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DANIEL_TAG";
    private static final String KEY_BOLD = "assignment04.csc214.fragments.bold";
    private static final String KEY_ITALIC = "assignment04.csc214.fragments.italic";
    private static final String KEY_UNDERLINE = "assignment04.csc214.fragments.underline";
    private static final String KEY_COLOR = "assignment04.csc214.fragments.color";
    private static final String KEY_SIZE = "assignment04.csc214.fragments.size";
    private static final String KEY_MESSAGE = "assignment04.csc214.fragments.message";

    private static final int RC_FONT = 1;
    private static final int RC_MESSAGE = 2;

    private static boolean mIsBold = false;
    private static boolean mIsItalic = false;
    private static boolean mIsUnderlined = false;
    private static String mColor = "Black";
    private static int mSize = 15;
    private static String mMessage = "This is my homework assignment.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onRCreate() called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mIsBold = savedInstanceState.getBoolean(KEY_BOLD);
            mIsItalic = savedInstanceState.getBoolean(KEY_ITALIC);
            mIsUnderlined = savedInstanceState.getBoolean(KEY_UNDERLINE);
            mColor = savedInstanceState.getString(KEY_COLOR);
            mSize = savedInstanceState.getInt(KEY_SIZE);
        }
        setTextValues();

    }

    public void setTextValues () {
        TextView mDisplayMessage = (TextView) findViewById(R.id.message);
        if (mIsBold) mDisplayMessage.setTypeface(mDisplayMessage.getTypeface(), BOLD);
        if (mIsItalic) mDisplayMessage.setTypeface(mDisplayMessage.getTypeface(), ITALIC);
        if (mIsBold && mIsItalic) mDisplayMessage.setTypeface(mDisplayMessage.getTypeface(), BOLD_ITALIC);
        if (mIsUnderlined) {
            //TODO: Underlined
        }
        switch (mColor) {
            case "Black":
                mDisplayMessage.setTextColor(Color.BLACK);
                break;
            case "Blue":
                mDisplayMessage.setTextColor(Color.BLUE);
                break;
            case "Red":
                mDisplayMessage.setTextColor(Color.RED);
                break;
            case "Green":
                mDisplayMessage.setTextColor(Color.GREEN);
                break;
            case "Orange":
                mDisplayMessage.setTextColor(getResources().getColor(R.color.orange));
                break;
            case "Purple":
                mDisplayMessage.setTextColor(getResources().getColor(R.color.purple));
                break;

            default:
                mDisplayMessage.setTextColor(Color.BLACK);
                break;
        }
        mDisplayMessage.setTextSize(mSize);
        mDisplayMessage.setText(mMessage);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == RC_FONT) {
            if (resultCode == RESULT_OK) {
                if (intent != null) {
                    mIsBold = intent.getBooleanExtra(KEY_BOLD, false);
                    mIsItalic = intent.getBooleanExtra(KEY_ITALIC, false);
                    mIsUnderlined = intent.getBooleanExtra(KEY_UNDERLINE, false);
                    mColor = intent.getStringExtra(KEY_COLOR);
                    mSize = intent.getIntExtra(KEY_SIZE, 15);
                    setTextValues();
                }
            } else if (resultCode == RESULT_CANCELED) {
                //Do nothing
            }
        } else if (requestCode == RC_MESSAGE) {
            if (resultCode == RESULT_OK) {
                if (intent != null) {
                    mMessage = intent.getStringExtra(KEY_MESSAGE);
                    setTextValues();
                }
            } else if (resultCode == RESULT_CANCELED) {
                //Do nothing
            }
        }
    }

    public void changeFontActivity(View view) {
        Intent intent = new Intent(MainActivity.this, FontActivity.class);
        intent.putExtra(KEY_BOLD, mIsBold);
        intent.putExtra(KEY_ITALIC, mIsItalic);
        intent.putExtra(KEY_UNDERLINE, mIsUnderlined);
        intent.putExtra(KEY_COLOR, mColor);
        intent.putExtra(KEY_SIZE, mSize);
        intent.putExtra(KEY_MESSAGE, mMessage);
        startActivityForResult(intent, 1);
    }

    public void changeMessageActivity(View view) {
        Intent intent = new Intent(MainActivity.this, MessageActivity.class);
        intent.putExtra(KEY_BOLD, mIsBold);
        intent.putExtra(KEY_ITALIC, mIsItalic);
        intent.putExtra(KEY_UNDERLINE, mIsUnderlined);
        intent.putExtra(KEY_COLOR, mColor);
        intent.putExtra(KEY_SIZE, mSize);
        intent.putExtra(KEY_MESSAGE, mMessage);
        startActivityForResult(intent, 2);
    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        state.putBoolean(KEY_BOLD, mIsBold);
        state.putBoolean(KEY_ITALIC, mIsItalic);
        state.putBoolean(KEY_UNDERLINE, mIsUnderlined);
        state.putString(KEY_COLOR, mColor);
        state.putInt(KEY_SIZE, mSize);
    }
}
