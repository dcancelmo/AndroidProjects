package aproject02.csc214.project2_network;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class NetworkFeed extends AppCompatActivity {

    private static final String TAG = "cancelmo_network_test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_feed);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu mMenu) {
        Log.d(TAG, "onCreateOptionsMenu MainActivity called");
        getMenuInflater().inflate(R.menu.user_menu, mMenu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mItem) {
        Log.d(TAG, "onOptionsItemSelected MainActivity called");
        boolean handled;
        switch(mItem.getItemId()) {
            case R.id.menu_item_logout:
                Intent mIntent = MainActivity.newIntent(this);
                startActivityForResult(mIntent, 0);
                handled = true;
                break;
            default:
                handled = super.onOptionsItemSelected(mItem);
                break;
        }
        return handled;
    }
}
