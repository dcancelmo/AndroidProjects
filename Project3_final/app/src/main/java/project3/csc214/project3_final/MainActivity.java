package project3.csc214.project3_final;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import project3.csc214.project3_final.sounds.Radio;
import project3.csc214.project3_final.sounds.Track;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Cancelmo_Debug_3";

    private static final String REQUEST_CODE = "request_code";
    private static final int RC_UR = 2;
    private static final int RC_TAXI = 3;
    private static final int RC_DINING = 4;
    private static final int RC_MISC = 5;
    private static final int RC_TRAVEL = 6;
    private static final int RC_BAR = 7;

    private Radio mRadio;
    MainFragment mFragment;
    FragmentManager mFragManager;
    File mPhotoFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate MainActivity called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRadio = new Radio(getApplicationContext());
        mFragManager = getSupportFragmentManager();
        mFragment = new MainFragment();
        mFragManager.beginTransaction().add(R.id.main_frame_layout, mFragment).commit();
    }

    public void openURList(View view) {
        Log.i(TAG, "open UR list button pressed");
        mRadio.play(mRadio.getTracks().get(0));
        Intent mIntent = new Intent(MainActivity.this, ListDisplayActivity.class);
        mIntent.putExtra(REQUEST_CODE, RC_UR);
        startActivityForResult(mIntent, RC_UR);
    }

    public void openTaxiList(View view) {
        Log.i(TAG, "open taxi list button pressed");
        mRadio.play(mRadio.getTracks().get(0));
        Intent mIntent = new Intent(MainActivity.this, ListDisplayActivity.class);
        mIntent.putExtra(REQUEST_CODE, RC_TAXI);
        startActivityForResult(mIntent, RC_TAXI);
    }

    public void openDiningList(View view) {
        Log.i(TAG, "open dining list button pressed");
        mRadio.play(mRadio.getTracks().get(0));
        Intent mIntent = new Intent(MainActivity.this, ListDisplayActivity.class);
        mIntent.putExtra(REQUEST_CODE, RC_DINING);
        startActivityForResult(mIntent, RC_DINING);
    }

    public void openMiscList(View view) {
        Log.i(TAG, "open misc list button pressed");
        mRadio.play(mRadio.getTracks().get(0));
        Intent mIntent = new Intent(MainActivity.this, ListDisplayActivity.class);
        mIntent.putExtra(REQUEST_CODE, RC_MISC);
        startActivityForResult(mIntent, RC_MISC);
    }

    public void openTravelList(View view) {
        Log.i(TAG, "open travel list button pressed");
        mRadio.play(mRadio.getTracks().get(0));
        Intent mIntent = new Intent(MainActivity.this, ListDisplayActivity.class);
        mIntent.putExtra(REQUEST_CODE, RC_TRAVEL);
        startActivityForResult(mIntent, RC_TRAVEL);
    }

    public void openBarList(View view) {
        Log.i(TAG, "open bar list button pressed");
        mRadio.play(mRadio.getTracks().get(0));
        Intent mIntent = new Intent(MainActivity.this, ListDisplayActivity.class);
        mIntent.putExtra(REQUEST_CODE, RC_BAR);
        startActivityForResult(mIntent, RC_BAR);
    }

    public void takePicture() {
        Log.d(TAG, "takePicture() called");
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
            Log.i(TAG, "Photo location: " + mPhotoFile.toString());
            startActivityForResult(intent, 0);
        } else {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                takePicture();
                return;
            } else {
                Toast.makeText(MainActivity.this, getString(R.string.must_grant_camera), Toast.LENGTH_LONG).show();
            }
        }
   }

   //From the Android Developer docs suggested way to record video
    private void takeVideo() {
        Intent mVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (mVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(mVideoIntent, 1);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu mMenu) {
        Log.i(TAG, "onCreateOptionsMenu MainActivity called");
        getMenuInflater().inflate(R.menu.video_menu, mMenu);
        getMenuInflater().inflate(R.menu.photo_menu, mMenu);
        getMenuInflater().inflate(R.menu.custom_menu, mMenu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mItem) {
        Log.i(TAG, "onOptionsItemSelected MainActivity called");
        boolean handled;
        switch(mItem.getItemId()) {
            case R.id.menu_item_course_entry:
                Intent mIntent = CustomItemActivity.newIntent(this);
                startActivity(mIntent);
                handled = true;
                break;
            case R.id.menu_item_camera:
                takePicture();
                handled = true;
                break;
            case R.id.menu_item_video:
                takeVideo();
                handled = true;
                break;
            default:
                handled = super.onOptionsItemSelected(mItem);
                break;
        }
        return handled;
    }

}
