package aproject02.csc214.project2_network;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import aproject02.csc214.project2_network.database.NetworkDb;
import aproject02.csc214.project2_network.model.User;

public class NetworkFeed extends AppCompatActivity implements HeaderFragment.HeaderButtonListener {

    private static final String TAG = "cancelmo_network_test";

    private NetworkDb mDatabase;

    private static final String KEY_EMAIL = "aproject02.csc214.project2_network.email";
    private static final String KEY_USERNAME = "aproject02.csc214.project2_network.username";
    private static String sUsername;
    private static String sEmail;
    private static User sThisUser;

    HeaderFragment mHeaderFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_feed);
        mDatabase = NetworkDb.get(getApplicationContext());
        FragmentTransaction mFragTransaction = getFragmentManager().beginTransaction();
        mHeaderFragment = new HeaderFragment();
        mHeaderFragment.setArguments(getIntent().getExtras());
        mFragTransaction.add(R.id.header_frame_layout, mHeaderFragment).commit();
        Intent mIntent = getIntent();
        if (mIntent != null) {
            sUsername = mIntent.getStringExtra(KEY_USERNAME);
            sThisUser = mDatabase.getUserByName(sUsername);
            sEmail = sThisUser.getEmail();
        }

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

    @Override
    public void homeButtonPressed() {
        Intent intent = new Intent(NetworkFeed.this, NetworkFeed.class);
        intent.putExtra(KEY_EMAIL, sEmail);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    @Override
    public void selfPostButtonPressed() {
        //TODO
        Intent intent = new Intent(NetworkFeed.this, NetworkFeed.class);
        intent.putExtra(KEY_EMAIL, sEmail);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    @Override
    public void ownProfileButtonPressed() {
        //TODO
        Intent intent = new Intent(NetworkFeed.this, OwnProfileActivity.class);
        intent.putExtra(KEY_EMAIL, sEmail);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (resultCode == RESULT_OK) {
//
//        }
//    }
}
