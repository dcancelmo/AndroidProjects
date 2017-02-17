package assignment04.csc214.homework4_fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MessageActivity extends AppCompatActivity {

    private static final String KEY_MESSAGE = "assignment04.csc214.fragments.message";
    private static String mMessage = "This is test text.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        if (savedInstanceState != null) {
            mMessage = savedInstanceState.getString(KEY_MESSAGE);
        }
        EditText mMessageEditText = (EditText) findViewById(R.id.message_edittext);
        mMessageEditText.setText(mMessage);
    }

    public void getValues() {
        mMessage = ((EditText) findViewById(R.id.message_edittext)).getText().toString();
    }

    public void acceptChanges(View view) {
        Intent intent = new Intent(MessageActivity.this, MainActivity.class);
        getValues();
        intent.putExtra(KEY_MESSAGE, mMessage);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void cancel(View view) {
        Intent intent = new Intent(MessageActivity.this, MainActivity.class);
        setResult(RESULT_CANCELED, intent);
        finish();
    }
}
