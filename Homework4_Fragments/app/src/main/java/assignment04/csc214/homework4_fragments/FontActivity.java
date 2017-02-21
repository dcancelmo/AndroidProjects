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

    private static boolean sIsBold = false;
    private static boolean sIsItalic = false;
    private static boolean sIsUnderlined = false;
    private static String sColor = "Black";
    private static int sSize = 15;
    private static String sMessage = "This is my homework assignment.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font);
        if (savedInstanceState != null) {
            sIsBold = savedInstanceState.getBoolean(KEY_BOLD);
            sIsItalic = savedInstanceState.getBoolean(KEY_ITALIC);
            sIsUnderlined = savedInstanceState.getBoolean(KEY_UNDERLINE);
            sColor = savedInstanceState.getString(KEY_COLOR);
            sSize = savedInstanceState.getInt(KEY_SIZE);
        }
        CheckBox mBoldBox = (CheckBox) findViewById(R.id.bold_checkbox);
        mBoldBox.setChecked(sIsBold);
        CheckBox mItalicBox = (CheckBox) findViewById(R.id.italic_checkbox);
        mItalicBox.setChecked(sIsItalic);
        CheckBox mUnderlineBox = (CheckBox) findViewById(R.id.underline_checkbox);
        mUnderlineBox.setChecked(sIsUnderlined);
        Spinner mColorSpinner = (Spinner) findViewById(R.id.color_spinner);
        int mColorChoice = 0;
        switch (sColor) {
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
        mSizeEditText.setText(String.valueOf(sSize));
    }

    public void getValues() {
        sIsBold = ((CheckBox) findViewById(R.id.bold_checkbox)).isChecked();
        sIsItalic = ((CheckBox) findViewById(R.id.italic_checkbox)).isChecked();
        sIsUnderlined = ((CheckBox) findViewById(R.id.underline_checkbox)).isChecked();
        sColor = ((Spinner) findViewById(R.id.color_spinner)).getSelectedItem().toString();
        sSize = Integer.valueOf(((EditText) findViewById(R.id.size_selector)).getText().toString());
    }

    public void acceptChanges(View view) {
        Intent intent = new Intent(FontActivity.this, MainActivity.class);
        getValues();
        intent.putExtra(KEY_BOLD, sIsBold);
        intent.putExtra(KEY_ITALIC, sIsItalic);
        intent.putExtra(KEY_UNDERLINE, sIsUnderlined);
        intent.putExtra(KEY_COLOR, sColor);
        intent.putExtra(KEY_SIZE, sSize);
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
        state.putBoolean(KEY_BOLD, sIsBold);
        state.putBoolean(KEY_ITALIC, sIsItalic);
        state.putBoolean(KEY_UNDERLINE, sIsUnderlined);
        state.putString(KEY_COLOR, sColor);
        state.putInt(KEY_SIZE, sSize);
        state.putString(KEY_MESSAGE, sMessage);
    }
}
