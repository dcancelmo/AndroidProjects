package aproject02.csc214.project2_network;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import aproject02.csc214.project2_network.R;
import aproject02.csc214.project2_network.database.NetworkDb;
import aproject02.csc214.project2_network.model.User;

public class ViewProfileActivity extends AppCompatActivity implements HeaderFragment.HeaderButtonListener {

    private static final String TAG = "cancelmo_network_test";
    private static final String KEY_VIEW_EMAIL = "aproject02.csc214.project2_network.view_email";
    private static final String KEY_EMAIL = "aproject02.csc214.project2_network.email";
    private static final String KEY_USERNAME = "aproject02.csc214.project2_network.username";
    private static final DateFormat FORMAT = new SimpleDateFormat("mm/dd/yyyy");

    private NetworkDb mDatabase;
    private FragmentTransaction mFragTransaction;
    private HeaderFragment mHeaderFragment;
    private String sViewEmail;
    private String sEmail;
    private static String sUsername;
    private static String sPhotoPath;
    private User sThisUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        mDatabase = NetworkDb.get(getApplicationContext());
        mFragTransaction = getSupportFragmentManager().beginTransaction();
        Bundle extras = getIntent().getExtras();
        mHeaderFragment = new HeaderFragment();
        mHeaderFragment.setArguments(extras);
        mFragTransaction.add(R.id.header_frame_layout, mHeaderFragment, null).commit();

        if (getIntent() != null) {
            Intent mIntent = getIntent();
            sViewEmail = mIntent.getStringExtra(KEY_VIEW_EMAIL);
            sEmail = mIntent.getStringExtra(KEY_EMAIL);
            sThisUser = mDatabase.getUser(sViewEmail);
            sUsername = sThisUser.getUsername();
            sPhotoPath = sThisUser.getProfilePic();
        }
        if (savedInstanceState != null) {
            sViewEmail = savedInstanceState.getString(KEY_VIEW_EMAIL);
            sEmail = savedInstanceState.getString(KEY_EMAIL);
            sThisUser = mDatabase.getUserByName(sViewEmail);
            sUsername = sThisUser.getUsername();
            sPhotoPath = sThisUser.getProfilePic();
        }
        TextView mNameText = (TextView) findViewById(R.id.profile_name_display);
        TextView mUserText = (TextView) findViewById(R.id.profile_username_display);
        TextView mEmailText = (TextView) findViewById(R.id.profile_email_display);
        TextView mBirthdayText = (TextView) findViewById(R.id.profile_birthday_display);
        TextView mHometownText = (TextView) findViewById(R.id.profile_hometown_display);
        TextView mBioText = (TextView) findViewById(R.id.profile_bio_display);
        ImageView mProfilePicImage = (ImageView) findViewById(R.id.profile_image_display);
        mProfilePicImage.setImageResource(R.mipmap.ic_default_picture);

        if (sPhotoPath != null) {
            Bitmap mNewPhoto = getScaledBitmap(sPhotoPath, mProfilePicImage.getWidth(), mProfilePicImage.getHeight());
            mProfilePicImage.setImageBitmap(mNewPhoto);
            mProfilePicImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        mNameText.setText(sThisUser.getFirstName() + " " + sThisUser.getLastName());
        mUserText.setText(sThisUser.getUsername());
        mEmailText.setText(sViewEmail);
        mBirthdayText.setText(getString(R.string.birthday_) + " " + FORMAT.format(sThisUser.getBirthDate()));
        mHometownText.setText(getString(R.string.hometown) + " " + sThisUser.getHometown());
        mBioText.setText(sThisUser.getBio());
    }

    public void favoritePerson(View view) {

    }

    @Override
    public void homeButtonPressed() {
        Intent intent = new Intent(ViewProfileActivity.this, NetworkFeed.class);
        intent.putExtra(KEY_EMAIL, sEmail);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    @Override
    public void selfPostButtonPressed(View v) {
        Intent intent = new Intent(ViewProfileActivity.this, WritePostActivity.class);
        intent.putExtra(KEY_EMAIL, sEmail);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    @Override
    public void ownProfileButtonPressed() {
        Intent intent = new Intent(ViewProfileActivity.this, UpdateAccountActivity.class);
        intent.putExtra(KEY_EMAIL, sEmail);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    @Override
    public void userListButtonPressed() {
        Intent intent = new Intent(ViewProfileActivity.this, UserListActivity.class);
        intent.putExtra(KEY_EMAIL, sEmail);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        state.putString(KEY_EMAIL, sEmail);
        state.putString(KEY_USERNAME, sUsername);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu mMenu) {
        Log.d(TAG, "onCreateOptionsMenu ViewProfileActivity called");
        getMenuInflater().inflate(R.menu.user_menu, mMenu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mItem) {
        Log.i(TAG, "onOptionsItemSelected ViewProfileActivity called");
        boolean handled;
        switch(mItem.getItemId()) {
            case R.id.menu_item_logout:
                Intent mIntent = MainActivity.newIntent(this);
                startActivityForResult(mIntent, 0);
                handled = true;
                Log.i(TAG, "Logging out " + sThisUser.getUsername());
                break;
            default:
                handled = super.onOptionsItemSelected(mItem);
                break;
        }
        return handled;
    }

    public static Bitmap getScaledBitmap(String path, int width, int height) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);
        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;
        int sampleSize = 1;
        if (srcHeight > height || srcWidth > width) {
            if (srcWidth > srcHeight) {
                sampleSize = Math.round(srcHeight / height);
            } else {
                sampleSize = Math.round(srcWidth / width);
            }
        }
        BitmapFactory.Options scaledOptions = new BitmapFactory.Options();
        scaledOptions.inSampleSize = sampleSize;
        return BitmapFactory.decodeFile(path, scaledOptions);
    }
}
