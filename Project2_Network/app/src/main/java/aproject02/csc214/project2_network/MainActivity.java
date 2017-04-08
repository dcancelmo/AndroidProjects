package aproject02.csc214.project2_network;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import aproject02.csc214.project2_network.database.NetworkDb;
import aproject02.csc214.project2_network.database.NetworkDbSchema;
import aproject02.csc214.project2_network.model.User;

public class MainActivity extends AppCompatActivity {

    private NetworkDb mDatabase;
    private static final String TAG = "cancelmo_network_test";

    private static final String KEY_USERNAME = "aproject02.csc214.project2_network.username";
    private static final String KEY_PASSWORD = "aproject02.csc214.project2_network.password";
    private static final int RC_NEW_USER = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mDatabase = NetworkDb.get(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loginUser(View view) {
        Log.i(TAG, "loginUser called");
        EditText mLoginUser = (EditText) findViewById(R.id.enter_username);
        EditText mLoginPass = (EditText) findViewById(R.id.enter_password);
        User mThisUser = mDatabase.getUser(mLoginUser.getText().toString(), mLoginPass.getText().toString());
        if (mThisUser == null) {
            Toast.makeText(MainActivity.this, R.string.invalid_login, Toast.LENGTH_LONG).show();
            Log.i(TAG, "loginUser failed (invalid entry)");
            return;
        }
        Intent intent = new Intent(MainActivity.this, NetworkFeed.class);
        intent.putExtra(KEY_USERNAME, mLoginUser.getText().toString());
        startActivityForResult(intent, RC_NEW_USER);

    }

    public void createNewUser(View view) {
        EditText mCreateUser = (EditText) findViewById(R.id.enter_new_username);
        EditText mCreatePass = (EditText) findViewById(R.id.enter_new_password);
        Log.i(TAG, "CreateNewUser called");
        User mThisUser = mDatabase.getUser(mCreateUser.getText().toString());
        if (mThisUser == null) {
            Toast.makeText(MainActivity.this, R.string.user_already_exists, Toast.LENGTH_LONG).show();
            Log.i(TAG, "CreateNewUser failed (user already exists)");
            return;
        }
        Intent intent = new Intent(MainActivity.this, NewUserCreation.class);
        intent.putExtra(KEY_USERNAME, mCreateUser.getText().toString());
        intent.putExtra(KEY_PASSWORD, mCreatePass.getText().toString());
        startActivityForResult(intent, RC_NEW_USER);
    }
}
