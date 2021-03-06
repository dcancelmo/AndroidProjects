package project3.csc214.project3_final;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.SupportMapFragment;

import project3.csc214.project3_final.recyclerViews.URRecyclerFragment;

import static project3.csc214.project3_final.ItemDetailsFragment.createInstance;

public class ItemDetailsActivity extends AppCompatActivity {

    private static final String TAG = "Cancelmo_Debug_3";

    private static final String NAME = "project3.csc214.project3_final.infoitem.name";
    private static final String ADDRESS = "project3.csc214.project3_final.infoitem.address";
    private static final String PHONE_NUMBER = "project3.csc214.project3_final.infoitem.phone_number";
    private static final String WEBSITE = "project3.csc214.project3_final.infoitem.website";
    private static final String HOURS = "project3.csc214.project3_final.infoitem.hours";
    private static final String DESCRIPTION = "project3.csc214.project3_final.infoitem.description";

    public String mName;
    public String mAddress;
    public String mPhone;
    public String mWebsiteString;
    public String mHours;
    public String mDescription;
    Fragment mFragment;
    SupportMapFragment mMapFrag;
    FragmentManager mFragManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        mFragManager = getSupportFragmentManager();
        Intent mIntent = getIntent();
        init(mIntent);
        if (mIntent == null) {
            Toast.makeText(this, getString(R.string.an_error_has_occurred), Toast.LENGTH_LONG).show();
            finish();
        } else {
            mFragment = ItemDetailsFragment.createInstance(mIntent);
            if (mAddress != null && !mAddress.equals("")) {
                Log.i(TAG, "Address: " + mAddress);
                mMapFrag = (SupportMapFragment) mFragManager.findFragmentById(R.id.details_map_frame_layout);
                if(mMapFrag == null) {
                    mMapFrag = new MapFragment();
                    mFragManager.beginTransaction().add(R.id.details_map_frame_layout, mMapFrag).commit();
                }
            }
            mFragManager.beginTransaction().add(R.id.details_frame_layout, mFragment).commit();
          }
    }

    public void init(Intent mIntent){
        mName = mIntent.getStringExtra(NAME);
        mAddress = mIntent.getStringExtra(ADDRESS);
        mPhone = mIntent.getStringExtra(PHONE_NUMBER);
        mWebsiteString = mIntent.getStringExtra(WEBSITE);
        mHours = mIntent.getStringExtra(HOURS);
        mDescription = mIntent.getStringExtra(DESCRIPTION);
    }
}
