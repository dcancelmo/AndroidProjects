package aproject02.csc214.project2_network;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.UUID;

import aproject02.csc214.project2_network.database.NetworkDb;
import aproject02.csc214.project2_network.database.NetworkDbSchema;
import aproject02.csc214.project2_network.model.User;

public class MainActivity extends AppCompatActivity {

    private NetworkDb mDatabase;
    private static final String TAG = "cancelmo_network_test";

    private static final String KEY_EMAIL = "aproject02.csc214.project2_network.email";
    private static final String KEY_USERNAME = "aproject02.csc214.project2_network.username";
    private static final String KEY_PASSWORD = "aproject02.csc214.project2_network.password";
    private static final int RC_NEW_USER = 1;
    private static final int RC_LOGIN_USER = 2;




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
        startActivityForResult(intent, RC_LOGIN_USER);
    }

    public void createNewUser(View view) {
        EditText mCreateEmail = (EditText) findViewById(R.id.enter_new_email);
        EditText mCreateUser = (EditText) findViewById(R.id.enter_new_username);
        EditText mCreatePass = (EditText) findViewById(R.id.enter_new_password);
        Log.i(TAG, "CreateNewUser called");
        User mThisUser = mDatabase.getUserByName(mCreateUser.getText().toString());
        if (mThisUser != null) {
            Toast.makeText(MainActivity.this, R.string.user_already_exists, Toast.LENGTH_LONG).show();
            Log.i(TAG, "CreateNewUser failed (user already exists)");
            return;
        }
        mThisUser = mDatabase.getUser(mCreateEmail.getText().toString());
        if (mThisUser != null) {
            Toast.makeText(MainActivity.this, R.string.email_already_exists, Toast.LENGTH_LONG).show();
            Log.i(TAG, "CreateNewUser failed (user already exists)");
            return;
        }
        mThisUser = new User(mCreateEmail.getText().toString(), mCreateUser.getText().toString(), mCreatePass.getText().toString());
        mDatabase.insertUser(mThisUser);
        Intent intent = new Intent(MainActivity.this, UpdateAccountActivity.class);
        intent.putExtra(KEY_EMAIL, mCreateEmail.getText().toString());
        intent.putExtra(KEY_USERNAME, mCreateUser.getText().toString());
        startActivityForResult(intent, RC_NEW_USER);


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult()");
        EditText mCreateUser = (EditText) findViewById(R.id.enter_new_username);
        Intent newIntent = new Intent(MainActivity.this, NetworkFeed.class);
        newIntent.putExtra(KEY_USERNAME, mCreateUser.getText().toString());
        startActivityForResult(newIntent, RC_LOGIN_USER);
    }

    public static Intent newIntent(Context mContext) {
        Intent intent = new Intent(mContext, MainActivity.class);
        return intent;
    }
}
