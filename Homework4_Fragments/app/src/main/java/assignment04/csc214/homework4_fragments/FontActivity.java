package assignment04.csc214.homework4_fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class FontActivity extends AppCompatActivity {

    private static final String KEY_BOLD = "assignment04.csc214.fragments.bold";
    private static final String KEY_ITALIC = "assignment04.csc214.fragments.italic";
    private static final String KEY_UNDERLINE = "assignment04.csc214.fragments.underline";
    private static final String KEY_COLOR = "assignment04.csc214.fragments.color";
    private static final String KEY_SIZE = "assignment04.csc214.fragments.size";
    private static final String KEY_MESSAGE = "assignment04.csc214.fragments.message";

    private static boolean mIsBold = false;
    private static boolean mIsItalic = false;
    private static boolean mIsUnderlined = false;
    private static String mColor = "Black";
    private static int mSize = 15;
    private static String mMessage = "This is my homework assignment.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font);
        if (savedInstanceState != null) {
            mIsBold = savedInstanceState.getBoolean(KEY_BOLD);
            mIsItalic = savedInstanceState.getBoolean(KEY_ITALIC);
            mIsUnderlined = savedInstanceState.getBoolean(KEY_UNDERLINE);
            mColor = savedInstanceState.getString(KEY_COLOR);
            mSize = savedInstanceState.getInt(KEY_SIZE);
        }
        CheckBox mBoldBox = (CheckBox) findViewById(R.id.bold_checkbox);
        mBoldBox.setChecked(mIsBold);
        CheckBox mItalicBox = (CheckBox) findViewById(R.id.italic_checkbox);
        mItalicBox.setChecked(mIsItalic);
        CheckBox mUnderlineBox = (CheckBox) findViewById(R.id.underline_checkbox);
        mUnderlineBox.setChecked(mIsUnderlined);
        Spinner mColorSpinner = (Spinner) findViewById(R.id.color_spinner);
        int mColorChoice = 0;
        switch (mColor) {
            case "Black":
                mColorChoice = 0;
                break;
            case "Blue":
                mColorChoice = 1;
                break;
            case "Red":
                mColorChoice = 2;
                break;
            case "Green":
                mColorChoice = 3;
                break;
            case "Orange":
                mColorChoice = 4;
                break;
            case "Purple":
                mColorChoice = 5;
                break;

            default:
                mColorChoice = 1;
                break;
        }
        mColorSpinner.setSelection(mColorChoice);
        EditText mSizeEditText = (EditText) findViewById(R.id.size_selector);
        mSizeEditText.setText(String.valueOf(mSize));
    }

    public void getValues() {
        mIsBold = ((CheckBox) findViewById(R.id.bold_checkbox)).isChecked();
        mIsItalic = ((CheckBox) findViewById(R.id.italic_checkbox)).isChecked();
        mIsUnderlined = ((CheckBox) findViewById(R.id.underline_checkbox)).isChecked();
        mColor = ((Spinner) findViewById(R.id.color_spinner)).getSelectedItem().toString();
        mSize = Integer.valueOf(((EditText) findViewById(R.id.size_selector)).getText().toString());
    }

    public void acceptChanges(View view) {
        Intent intent = new Intent(FontActivity.this, MainActivity.class);
        getValues();
        intent.putExtra(KEY_BOLD, mIsBold);
        intent.putExtra(KEY_ITALIC, mIsItalic);
        intent.putExtra(KEY_UNDERLINE, mIsUnderlined);
        intent.putExtra(KEY_COLOR, mColor);
        intent.putExtra(KEY_SIZE, mSize);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void cancel(View view) {
        Intent intent = new Intent(FontActivity.this, MainActivity.class);
        setResult(RESULT_CANCELED, intent);
        finish();
    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        state.putBoolean(KEY_BOLD, mIsBold);
        state.putBoolean(KEY_ITALIC, mIsItalic);
        state.putBoolean(KEY_UNDERLINE, mIsUnderlined);
        state.putString(KEY_COLOR, mColor);
        state.putInt(KEY_SIZE, mSize);
        state.putString(KEY_MESSAGE, mMessage);
    }
}
