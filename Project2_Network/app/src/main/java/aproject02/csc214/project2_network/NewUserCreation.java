package aproject02.csc214.project2_network;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

import aproject02.csc214.project2_network.database.NetworkDb;

public class NewUserCreation extends AppCompatActivity {

    private NetworkDb mDatabase;
    private static final String TAG = "cancelmo_network_test";

    private static final String KEY_USERNAME = "aproject02.csc214.project2_network.username";
    private static final String KEY_PASSWORD = "aproject02.csc214.project2_network.password";
    private static final String KEY_FIRST_NAME = "aproject02.csc214.project2_network.firstname";
    private static final String KEY_LAST_NAME = "aproject02.csc214.project2_network.lastname";
    private static final String KEY_BIRTHDATE = "aproject02.csc214.project2_network.birthdate";
    private static final String KEY_PROFILE_PIC = "aproject02.csc214.project2_network.profile_pic";

    private static String sUsername;
    private static String sPassword;
    private static String sFirstName;
    private static String sLastName;
    private static Date sBirthDate;
    private static String sProfilePic;

    private TextView mUsernameText;
    private EditText mFirstNameEdit;
    private EditText mLastNameEdit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_creation);
        mDatabase = NetworkDb.get(getApplicationContext());
        mUsernameText = (TextView) findViewById(R.id.username_text);
        mFirstNameEdit = (EditText) findViewById(R.id.first_name_enter);
        mLastNameEdit = (EditText) findViewById(R.id.last_name_enter);
        Intent mIntent = getIntent();
        restoreValues(savedInstanceState);
        updateValues(mIntent);
    }

    public void restoreValues(Bundle mBundle) {
        sUsername = mBundle.getString(KEY_USERNAME);
        sPassword = mBundle.getString(KEY_PASSWORD);
        sFirstName = mBundle.getString(KEY_FIRST_NAME);
        sLastName = mBundle.getString(KEY_LAST_NAME);
        //TODO: sBirthDate = mBundle.get (KEY_BIRTHDATE);
        sProfilePic = mBundle.getString(KEY_PROFILE_PIC);
        mUsernameText.setText(R.string.username + sUsername);
        mFirstNameEdit.setText(sFirstName);
        mLastNameEdit.setText(sLastName);

    }

    public void updateValues(Intent mIntent) {
        sUsername = mIntent.getStringExtra(KEY_USERNAME);
        sPassword = mIntent.getStringExtra(KEY_PASSWORD);
        mUsernameText.setText(R.string.username + sUsername);
    }

    public void openDatePickerDialog(View view) {
        DatePickerDialog mDateDialog = new DatePickerDialog(getApplicationContext());
        mDateDialog.show();
    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        state.putString(KEY_USERNAME, sUsername);
        state.putString(KEY_PASSWORD, sPassword);
        state.putString(KEY_FIRST_NAME, sFirstName);
        state.putString(KEY_LAST_NAME, sLastName);
        //TODO: state.put (KEY_BIRTHDATE, sBirthDate);
        state.putString(KEY_PROFILE_PIC, sProfilePic);
    }
}
