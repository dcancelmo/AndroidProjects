package assignment04.csc214.homework4_fragments;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static android.graphics.Typeface.BOLD;
import static android.graphics.Typeface.BOLD_ITALIC;
import static android.graphics.Typeface.ITALIC;
import static android.graphics.Typeface.NORMAL;

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

    private static boolean sIsBold = false;
    private static boolean sIsItalic = false;
    private static boolean sIsUnderlined = false;
    private static String sColor = "Black";
    private static int sSize = 15;
    private static String sMessage = "This is test text.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate() called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            sIsBold = savedInstanceState.getBoolean(KEY_BOLD);
            sIsItalic = savedInstanceState.getBoolean(KEY_ITALIC);
            sIsUnderlined = savedInstanceState.getBoolean(KEY_UNDERLINE);
            sColor = savedInstanceState.getString(KEY_COLOR);
            sSize = savedInstanceState.getInt(KEY_SIZE);
        }
        setTextValues();
    }

    public void setTextValues() {
        TextView mDisplayMessage = (TextView) findViewById(R.id.message);
        mDisplayMessage.setTypeface(Typeface.DEFAULT);
        if (sIsBold && sIsItalic) mDisplayMessage.setTypeface(mDisplayMessage.getTypeface(), Typeface.BOLD_ITALIC);
        else if (sIsBold) mDisplayMessage.setTypeface(mDisplayMessage.getTypeface(), Typeface.BOLD);
        else if (sIsItalic) mDisplayMessage.setTypeface(mDisplayMessage.getTypeface(), Typeface.ITALIC);
        else mDisplayMessage.setTypeface(Typeface.DEFAULT);

        if (sIsUnderlined) {
            mDisplayMessage.setPaintFlags(mDisplayMessage.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        } else {
            mDisplayMessage.setPaintFlags(0);
        }

        switch (sColor) {
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
        mDisplayMessage.setTextSize(sSize);
        mDisplayMessage.setText(sMessage);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Log.i(TAG, "onActivityResultCalled");
        if (requestCode == RC_FONT) {
            if (resultCode == RESULT_OK) {
                Log.i(TAG, "Font Activity return, OK");
                if (intent != null) {
                    sIsBold = intent.getBooleanExtra(KEY_BOLD, false);
                    sIsItalic = intent.getBooleanExtra(KEY_ITALIC, false);
                    sIsUnderlined = intent.getBooleanExtra(KEY_UNDERLINE, false);
                    sColor = intent.getStringExtra(KEY_COLOR);
                    sSize = intent.getIntExtra(KEY_SIZE, 15);
                    setTextValues();
                }
            } else if (resultCode == RESULT_CANCELED) {
                Log.i(TAG, "Font Activity return, canceled");
                //Do nothing
            }
        } else if (requestCode == RC_MESSAGE) {
            Log.i(TAG, "Message Activity return, OK");
            if (resultCode == RESULT_OK) {
                if (intent != null) {
                    sMessage = intent.getStringExtra(KEY_MESSAGE);
                    setTextValues();
                }
            } else if (resultCode == RESULT_CANCELED) {
                Log.i(TAG, "Message Activity return, canceled");
                //Do nothing
            }
        }
    }

    public void changeFontActivity(View view) {
        Log.i(TAG, "Font Activity called");
        Intent intent = new Intent(MainActivity.this, FontActivity.class);
        intent.putExtra(KEY_BOLD, sIsBold);
        intent.putExtra(KEY_ITALIC, sIsItalic);
        intent.putExtra(KEY_UNDERLINE, sIsUnderlined);
        intent.putExtra(KEY_COLOR, sColor);
        intent.putExtra(KEY_SIZE, sSize);
        intent.putExtra(KEY_MESSAGE, sMessage);
        startActivityForResult(intent, RC_FONT);
    }

    public void changeMessageActivity(View view) {
        Log.i(TAG, "Message Activity called");
        Intent intent = new Intent(MainActivity.this, MessageActivity.class);
        intent.putExtra(KEY_BOLD, sIsBold);
        intent.putExtra(KEY_ITALIC, sIsItalic);
        intent.putExtra(KEY_UNDERLINE, sIsUnderlined);
        intent.putExtra(KEY_COLOR, sColor);
        intent.putExtra(KEY_SIZE, sSize);
        intent.putExtra(KEY_MESSAGE, sMessage);
        startActivityForResult(intent, RC_MESSAGE);
    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        state.putBoolean(KEY_BOLD, sIsBold);
        state.putBoolean(KEY_ITALIC, sIsItalic);
        state.putBoolean(KEY_UNDERLINE, sIsUnderlined);
        state.putString(KEY_COLOR, sColor);
        state.putInt(KEY_SIZE, sSize);
    }
}
