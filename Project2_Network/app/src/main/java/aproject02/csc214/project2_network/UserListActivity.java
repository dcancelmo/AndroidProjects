package aproject02.csc214.project2_network;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import aproject02.csc214.project2_network.database.NetworkDb;
import aproject02.csc214.project2_network.model.User;
import aproject02.csc214.project2_network.recyclerView.UserListFragment;

public class UserListActivity extends AppCompatActivity implements HeaderFragment.HeaderButtonListener {

    private static final String TAG = "cancelmo_network_test";

    NetworkDb mDatabase;
    HeaderFragment mHeaderFragment;
    UserListFragment mUserListFragment;
    private FragmentTransaction mFragTransaction;

    private static final String KEY_EMAIL = "aproject02.csc214.project2_network.email";

    private String sEmail;
    private User sThisUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        mDatabase = NetworkDb.get(getApplicationContext());
        mFragTransaction = getSupportFragmentManager().beginTransaction();
        Bundle extras = getIntent().getExtras();
        mHeaderFragment = new HeaderFragment();
        mHeaderFragment.setArguments(extras);
        mUserListFragment = new UserListFragment();
        mUserListFragment.setArguments(extras);

        mFragTransaction.add(R.id.header_frame_layout, mHeaderFragment, null).add(R.id.user_list_frame_layout, mUserListFragment, null).commit();
        if (getIntent() != null) {
            Intent mIntent = getIntent();
            sEmail = mIntent.getStringExtra(KEY_EMAIL);
            sThisUser = mDatabase.getUser(sEmail);
        }
        if (savedInstanceState != null) {
            sEmail = savedInstanceState.getString(KEY_EMAIL);
            sThisUser = mDatabase.getUserByName(sEmail);
        }
    }

    @Override
    public void homeButtonPressed() {
        Intent intent = new Intent(UserListActivity.this, NetworkFeed.class);
        intent.putExtra(KEY_EMAIL, sEmail);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    @Override
    public void selfPostButtonPressed(View v) {
        Intent intent = new Intent(UserListActivity.this, WritePostActivity.class);
        intent.putExtra(KEY_EMAIL, sEmail);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    @Override
    public void ownProfileButtonPressed() {
        //TODO
        Intent intent = new Intent(UserListActivity.this, OwnProfileActivity.class);
        intent.putExtra(KEY_EMAIL, sEmail);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    @Override
    public void userListButtonPressed() {
        Intent intent = new Intent(UserListActivity.this, UserListActivity.class);
        intent.putExtra(KEY_EMAIL, sEmail);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu mMenu) {
        Log.d(TAG, "onCreateOptionsMenu MainActivity called");
        getMenuInflater().inflate(R.menu.user_menu, mMenu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mItem) {
        Log.i(TAG, "onOptionsItemSelected MainActivity called");
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
}
