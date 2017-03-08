package project01.csc214.project01_simplegames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DANIEL_TAG";
    private static final String KEY_USER1 = "project01.csc214.project01_simplegames.username1";
    private static final String KEY_USER2 = "project01.csc214.project01_simplegames.username2";

    private static final int RC_HOT = 2;
    private static final int RC_HANG = 3;
    private static final int RC_CONNECT = 4;

    private static String sUser1;
    private static String sUser2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate() called[main]");

        if (savedInstanceState != null) {
            sUser1 = savedInstanceState.getString(KEY_USER1);
            sUser2 = savedInstanceState.getString(KEY_USER2);
            EditText editTextUser1 = (EditText) findViewById(R.id.user1_edittext);
            TextView displayUser1 = (TextView) findViewById(R.id.user1Display);
            editTextUser1.setText(sUser1);
            displayUser1.setText(sUser1);
            EditText editTextUser2 = (EditText) findViewById(R.id.user2_edittext);
            TextView displayUser2 = (TextView) findViewById(R.id.user2Display);
            editTextUser2.setText(sUser2);
            displayUser2.setText(sUser2);
        }
    }

    public void startHotCold(View view) {
        Log.i(TAG, "startHotCold called");
        Intent intent = new Intent(MainActivity.this, GamesActivity.class);
        intent.putExtra(KEY_USER1, sUser1);
        intent.putExtra(KEY_USER2, sUser2);
        startActivityForResult(intent, RC_HOT);
    }

    public void startHangman(View view) {
        Log.i(TAG, "startHotCold called");
        Intent intent = new Intent(MainActivity.this, GamesActivity.class);
        intent.putExtra(KEY_USER1, sUser1);
        intent.putExtra(KEY_USER2, sUser2);
        startActivityForResult(intent, RC_HOT);
    }

    public void startConnect4(View view) {
        Log.i(TAG, "startHotCold called");
        Intent intent = new Intent(MainActivity.this, GamesActivity.class);
        intent.putExtra(KEY_USER1, sUser1);
        intent.putExtra(KEY_USER2, sUser2);
        startActivityForResult(intent, RC_HOT);
    }

    public void acceptNames(View view) {
        Log.i(TAG, "startHotCold called");
        Intent intent = new Intent(MainActivity.this, GamesActivity.class);
        intent.putExtra(KEY_USER1, sUser1);
        intent.putExtra(KEY_USER2, sUser2);
        startActivityForResult(intent, RC_HOT);
    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        state.putString(KEY_USER1, sUser1);
        state.putString(KEY_USER2, sUser2);
    }
}
