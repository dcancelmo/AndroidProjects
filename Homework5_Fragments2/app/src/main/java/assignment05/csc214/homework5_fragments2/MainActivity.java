package assignment05.csc214.homework5_fragments2;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TopFragment.MessageChangedListener {

    private static final String KEY_MESSAGE = "assignment05.csc214.homework5_fragments2.message";
    private BottomFragment mBottomFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction mFragTransaction = getFragmentManager().beginTransaction();

        mBottomFragment = new BottomFragment();
        mFragTransaction.add(R.id.bottom_third_section, mBottomFragment);

        TopFragment mTopFrag = new TopFragment();
        mTopFrag.setArguments(getIntent().getExtras());
        mFragTransaction.add(R.id.top_third_section, mTopFrag).commit();

    }

    public void sendMessage(View view) {
        EditText mEditText = (EditText) findViewById(R.id.main_edittext);
        if (mEditText.getText() != null) {
            Intent intent = new Intent(MainActivity.this, MessageSendActivity.class);
            intent.putExtra(KEY_MESSAGE, mEditText.getText().toString());
            startActivityForResult(intent, 0);
        }
    }

    public void sendBack(View view) {
        EditText mEditText = (EditText) findViewById(R.id.fragment_edittext);
        messageChanged(mEditText.getText());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        CharSequence mMessage = intent.getCharSequenceExtra(KEY_MESSAGE);
        TextView mTopDisplay = (TextView) findViewById(R.id.top_message_display);
        mTopDisplay.setText(mMessage);
    }

    @Override
    public void messageChanged(CharSequence message) {
        mBottomFragment.messageSentBack(message);
    }

}
