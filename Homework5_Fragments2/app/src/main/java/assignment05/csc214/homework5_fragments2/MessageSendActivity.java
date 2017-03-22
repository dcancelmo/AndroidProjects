package assignment05.csc214.homework5_fragments2;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MessageSendActivity extends AppCompatActivity {

    private static final String KEY_MESSAGE = "assignment05.csc214.homework5_fragments2.message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_send);

        TopFragment mTopFrag = new TopFragment();
        mTopFrag.setArguments(getIntent().getExtras());

        Intent intent = new Intent(MessageSendActivity.this, MainActivity.class);
        intent.putExtra(KEY_MESSAGE, mTopFrag.getArguments().getString(KEY_MESSAGE));
        setResult(RESULT_OK, intent);
        finish();
    }


}
