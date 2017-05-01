package project3.csc214.project3_final;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import project3.csc214.project3_final.recyclerViews.BarsRecyclerFragment;
import project3.csc214.project3_final.recyclerViews.DiningRecyclerFragment;
import project3.csc214.project3_final.recyclerViews.MiscRecyclerFragment;
import project3.csc214.project3_final.recyclerViews.TaxiRecyclerFragment;
import project3.csc214.project3_final.recyclerViews.TravelRecyclerFragment;
import project3.csc214.project3_final.recyclerViews.URRecyclerFragment;

public class ListDisplayActivity extends AppCompatActivity {

    private static final String TAG = "Cancelmo_Debug_3";

    private static final String REQUEST_CODE = "request_code";
    private static final int RC_UR = 2;
    private static final int RC_TAXI = 3;
    private static final int RC_DINING = 4;
    private static final int RC_MISC = 5;
    private static final int RC_TRAVEL = 6;
    private static final int RC_BAR = 7;

    Fragment mFragment;
    FragmentManager mFragManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_display);
        mFragManager = getSupportFragmentManager();
        Intent mIntent = getIntent();
        if (mIntent != null) {
            int reqCode = mIntent.getIntExtra(REQUEST_CODE, 2);
            switch (reqCode) {
                case RC_UR:
                    mFragment = new URRecyclerFragment();
                    break;
                case RC_TAXI:
                    mFragment = new TaxiRecyclerFragment();
                    break;
                case RC_DINING:
                    mFragment = new DiningRecyclerFragment();
                    break;
                case RC_MISC:
                    mFragment = new MiscRecyclerFragment();
                    break;
                case RC_TRAVEL:
                    mFragment = new TravelRecyclerFragment();
                    break;
                case RC_BAR:
                    mFragment = new BarsRecyclerFragment();
                    break;
            }
            mFragManager.beginTransaction().add(R.id.list_display_frame, mFragment).commit();
        } else {
            Toast.makeText(this, R.string.an_error_has_occurred, Toast.LENGTH_LONG).show();
            Log.e(TAG, "No intent passed in, could not create list");
        }
    }
}
