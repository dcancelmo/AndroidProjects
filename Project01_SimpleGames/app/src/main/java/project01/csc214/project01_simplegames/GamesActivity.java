package project01.csc214.project01_simplegames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class GamesActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_games);
        Log.i(TAG, "onCreate() called[games]");

        if (savedInstanceState != null) {
            sUser1 = savedInstanceState.getString(KEY_USER1);
            sUser2 = savedInstanceState.getString(KEY_USER2);
        }
    }



    @Override
    protected void onSaveInstanceState(Bundle state) {
        state.putString(KEY_USER1, sUser1);
        state.putString(KEY_USER2, sUser2);
    }
}
