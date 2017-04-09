package aproject02.csc214.project2_network;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import aproject02.csc214.project2_network.database.NetworkDb;
import aproject02.csc214.project2_network.database.NetworkDbSchema;
import aproject02.csc214.project2_network.model.User;

public class UpdateAccountActivity extends AppCompatActivity {

    private NetworkDb mDatabase;
    private static final String TAG = "cancelmo_network_test";

    private static final String KEY_EMAIL = "aproject02.csc214.project2_network.email";
    private static final String KEY_USERNAME = "aproject02.csc214.project2_network.username";
    private static final String KEY_PASSWORD = "aproject02.csc214.project2_network.password";
    private static final String KEY_FIRST_NAME = "aproject02.csc214.project2_network.firstname";
    private static final String KEY_LAST_NAME = "aproject02.csc214.project2_network.lastname";
    private static final String KEY_BIRTHDATE = "aproject02.csc214.project2_network.birthdate";
    private static final String KEY_PROFILE_PIC = "aproject02.csc214.project2_network.profile_pic";

    private static String sEmail;
    private static String sUsername;
    private static String sPassword;
    private static String sFirstName;
    private static String sLastName;
    private static String sBirthDate;
    private static String sProfilePic;

    private TextView mEmailText;
    private TextView mUsernameText;
    private EditText mFirstNameEdit;
    private EditText mLastNameEdit;
    private EditText mBirthdayEdit;
    private ImageView mProfilePicImage;

    private static final DateFormat FORMAT = new SimpleDateFormat("mm/dd/yyyy");


    private File mPhotoFile;
    private List<File> mPhotoFiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_account);
        mDatabase = NetworkDb.get(getApplicationContext());
        mEmailText = (TextView) findViewById(R.id.email_text);
        mUsernameText = (TextView) findViewById(R.id.username_text);
        mFirstNameEdit = (EditText) findViewById(R.id.first_name_enter);
        mLastNameEdit = (EditText) findViewById(R.id.last_name_enter);
        mBirthdayEdit = (EditText) findViewById(R.id.birthday_enter);
        mProfilePicImage = (ImageView) findViewById(R.id.profile_pic_view);
        mProfilePicImage.setImageResource(R.mipmap.ic_default_picture);
        mPhotoFiles = new ArrayList<>();
        Intent mIntent = getIntent();
        restoreValues(savedInstanceState);
        updateValues(mIntent);
    }

    public void restoreValues(Bundle mBundle) {
        if (mBundle != null) {
            sEmail = mBundle.getString(KEY_EMAIL);
            sUsername = mBundle.getString(KEY_USERNAME);
            sPassword = mBundle.getString(KEY_PASSWORD);
            sFirstName = mBundle.getString(KEY_FIRST_NAME);
            sLastName = mBundle.getString(KEY_LAST_NAME);
            sBirthDate = mBundle.getString(KEY_BIRTHDATE);
            sProfilePic = mBundle.getString(KEY_PROFILE_PIC);
            mEmailText.setText(getResources().getString(R.string.email) + " " + sEmail);
            mUsernameText.setText(getResources().getString(R.string.username) + " " + sUsername);
            mFirstNameEdit.setText(sFirstName);
            mLastNameEdit.setText(sLastName);
            mBirthdayEdit.setText(sBirthDate);
        }
    }

    public void updateValues(Intent mIntent) {
        sEmail = mIntent.getStringExtra(KEY_EMAIL);
        sUsername = mIntent.getStringExtra(KEY_USERNAME);
        sPassword = mIntent.getStringExtra(KEY_PASSWORD);
        mEmailText.setText(getResources().getString(R.string.email) + " " + sEmail);
        mUsernameText.setText(getResources().getString(R.string.username) + " " + sUsername);
        User mThisUser = mDatabase.getUser(sEmail);
        sFirstName = mThisUser.getFirstName();
        sLastName = mThisUser.getLastName();
        sBirthDate = FORMAT.format(mThisUser.getBirthDate());
        sProfilePic = mThisUser.getProfilePic();
        mFirstNameEdit.setText(sFirstName);
        mLastNameEdit.setText(sLastName);
        mBirthdayEdit.setText(sBirthDate);
    }

    public void takePicture(View view) {
        Log.d(TAG, "takePicture(View) called");
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "Has permission to capture");
            Intent intent = new Intent();
            intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

            String filename = "IMG_" + UUID.randomUUID().toString() + ".jpg";
            File picturesDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            mPhotoFile = new File(picturesDir, filename);

            //Uri photoUri = Uri.fromFile(mPhotoFile);
            Uri photoUri = FileProvider.getUriForFile(getApplicationContext(), getApplicationContext().getPackageName() + ".provider", mPhotoFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
            Log.d(TAG, "photo location: " + mPhotoFile.toString());
            startActivityForResult(intent, 0);
        } else {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                takePicture(view);
                return;
            } else {
                Toast.makeText(UpdateAccountActivity.this, R.string.must_grant_camera, Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult()");
        if(resultCode == Activity.RESULT_OK) {
            mPhotoFiles.add(mPhotoFile);
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle state) {
        state.putString(KEY_EMAIL, sEmail);
        state.putString(KEY_USERNAME, sUsername);
        state.putString(KEY_PASSWORD, sPassword);
        state.putString(KEY_FIRST_NAME, sFirstName);
        state.putString(KEY_LAST_NAME, sLastName);
        state.putString(KEY_BIRTHDATE, sBirthDate);
        state.putString(KEY_PROFILE_PIC, sProfilePic);
    }

    public void updateAccount(View view) throws ParseException {
        ContentValues mNewData = new ContentValues();
        mNewData.put("first_name", mFirstNameEdit.getText().toString());
        mNewData.put("last_name", mLastNameEdit.getText().toString());
        mNewData.put("birth_date", mBirthdayEdit.getText().toString());
        mNewData.put("profile_pic", sProfilePic);
        mDatabase.update(mNewData, sEmail);
        finish();
    }
}
