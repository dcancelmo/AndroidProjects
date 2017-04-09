package aproject02.csc214.project2_network;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.Date;
import java.util.UUID;

import aproject02.csc214.project2_network.database.NetworkDb;
import aproject02.csc214.project2_network.model.Post;
import aproject02.csc214.project2_network.model.User;

public class WritePostActivity extends AppCompatActivity implements HeaderFragment.HeaderButtonListener {

    private static final String TAG = "cancelmo_network_test";

    private static final String KEY_EMAIL = "aproject02.csc214.project2_network.email";
    private static final String KEY_PICTURE_PATH = "aproject02.csc214.project2_network.picture_path";
    private static final String KEY_TEXT_CONTENT = "aproject02.csc214.project2_network.text_content";


    private static final String USER_EMAIL = "user_email";

    private String sEmail;
    private File mPhotoFile;
    private String mPicturePath;
    private ImageView mPostImageView;
    private FragmentTransaction mFragTransaction;
    private HeaderFragment mHeaderFragment;
    private EditText mContentEditText;

    private NetworkDb mDatabase;
    private static User sThisUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_post);
        mDatabase = NetworkDb.get(getApplicationContext());
        mPostImageView = (ImageView) findViewById(R.id.image_post_view);
        mPostImageView.setImageResource(R.mipmap.ic_blank_image);
        mFragTransaction = getSupportFragmentManager().beginTransaction();
        Bundle extras = getIntent().getExtras();
        mHeaderFragment = new HeaderFragment();
        mHeaderFragment.setArguments(extras);
        mHeaderFragment.setArguments(getIntent().getExtras());
        mFragTransaction.add(R.id.header_frame_layout, mHeaderFragment, null).commit();
        mContentEditText = (EditText) findViewById(R.id.new_post_text_content);
        if (getIntent() != null) {
            Intent mIntent = getIntent();
            sEmail = mIntent.getStringExtra(KEY_EMAIL);
            sThisUser = mDatabase.getUser(sEmail);
        }
        if (savedInstanceState != null) {
            sEmail = savedInstanceState.getString(KEY_EMAIL);
            mPicturePath = savedInstanceState.getString(KEY_PICTURE_PATH);
            sThisUser = mDatabase.getUserByName(sEmail);
            mContentEditText.setText(savedInstanceState.getString(KEY_TEXT_CONTENT));
        }
        if (mPicturePath != null) {
            Bitmap mNewPhoto = getScaledBitmap(mPicturePath, mPostImageView.getWidth(), mPostImageView.getHeight());
            mPostImageView.setImageBitmap(mNewPhoto);
            mPostImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

    }

    public void takePicture(View view) {
        Log.i(TAG, "takePicture(View) called (new post)");
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Has permission to capture");
            Intent intent = new Intent();
            intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

            String filename = "IMG_" + UUID.randomUUID().toString() + ".jpg";
            File picturesDir = this.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            mPhotoFile = new File(picturesDir, filename);

            //Uri photoUri = Uri.fromFile(mPhotoFile);
            Uri photoUri = FileProvider.getUriForFile(this, this.getPackageName() + ".provider", mPhotoFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
            Log.i(TAG, "photo location: " + mPhotoFile.toString());
            startActivityForResult(intent, 0);
        } else {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                takePicture(view);
                return;
            } else {
                Toast.makeText(WritePostActivity.this, R.string.must_grant_camera, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult()");
        if(resultCode == Activity.RESULT_OK) {
            mPicturePath = mPhotoFile.getPath();
            Bitmap mNewPhoto = getScaledBitmap(mPhotoFile.getPath(), mPostImageView.getWidth(), mPostImageView.getHeight());
            mPostImageView.setImageBitmap(mNewPhoto);
            mPostImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    public void addPost(View view) {
        Post mNewPost = new Post();
        mNewPost.setUsername(sThisUser.getUsername());
        mNewPost.setContent(mContentEditText.getText().toString());
        mNewPost.setPhotoPath(mPicturePath);
        mNewPost.setPostedDate(new Date());
        mDatabase.insertPost(mNewPost);
        Log.i(TAG, "Photo path saved to database: " + mPicturePath);
        finish();
    }

    @Override
    public void homeButtonPressed() {
        Intent intent = new Intent(WritePostActivity.this, NetworkFeed.class);
        intent.putExtra(KEY_EMAIL, sEmail);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    @Override
    public void selfPostButtonPressed(View v) {
        Intent intent = new Intent(WritePostActivity.this, WritePostActivity.class);
        intent.putExtra(KEY_EMAIL, sEmail);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    @Override
    public void ownProfileButtonPressed() {
        //TODO
        Intent intent = new Intent(WritePostActivity.this, OwnProfileActivity.class);
        intent.putExtra(KEY_EMAIL, sEmail);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    @Override
    public void userListButtonPressed() {
        Intent intent = new Intent(WritePostActivity.this, UserListActivity.class);
        intent.putExtra(KEY_EMAIL, sEmail);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    public void cancelPost(View view) {
        finish();
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

    @Override
    public boolean onCreateOptionsMenu(Menu mMenu) {
        Log.d(TAG, "onCreateOptionsMenu WritePostActivity called");
        getMenuInflater().inflate(R.menu.user_menu, mMenu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mItem) {
        Log.i(TAG, "onOptionsItemSelected WritePostActivity called");
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

    @Override
    protected void onSaveInstanceState(Bundle state) {
        state.putString(KEY_EMAIL, sEmail);
        state.putString(KEY_TEXT_CONTENT, mContentEditText.getText().toString());
        state.putString(KEY_PICTURE_PATH, mPicturePath);
    }
}
