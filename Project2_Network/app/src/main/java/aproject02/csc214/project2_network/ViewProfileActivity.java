package aproject02.csc214.project2_network;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import aproject02.csc214.project2_network.R;
import aproject02.csc214.project2_network.database.NetworkDb;
import aproject02.csc214.project2_network.model.User;

public class ViewProfileActivity extends AppCompatActivity implements HeaderFragment.HeaderButtonListener {

    private static final String TAG = "cancelmo_network_test";
    private static final String KEY_EMAIL = "aproject02.csc214.project2_network.email";

    private NetworkDb mDatabase;
    private FragmentTransaction mFragTransaction;
    private HeaderFragment mHeaderFragment;
    private String sEmail;
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
            sEmail = mIntent.getStringExtra(KEY_EMAIL);
            sThisUser = mDatabase.getUser(sEmail);
        }
        if (savedInstanceState != null) {
            sEmail = savedInstanceState.getString(KEY_EMAIL);
            sThisUser = mDatabase.getUserByName(sEmail);
        }
        TextView mNameText = (TextView) findViewById(R.id.profile_name_display);
        TextView mUserText = (TextView) findViewById(R.id.profile_username_display);
        TextView mEmailText = (TextView) findViewById(R.id.profile_email_display);
        TextView mBirthdayText = (TextView) findViewById(R.id.profile_birthday_display);
        TextView mHometownText = (TextView) findViewById(R.id.profile_hometown_display);
        TextView mBioText = (TextView) findViewById(R.id.profile_bio_display);

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
        //TODO
        Intent intent = new Intent(ViewProfileActivity.this, OwnProfileActivity.class);
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
    }
}
