package project3.csc214.project3_final;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemDetailsFragment extends Fragment {

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

    public ItemDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setRetainInstance(true);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_details, container, false);
    }

    public static ItemDetailsFragment createInstance(Intent mIntent) {
        ItemDetailsFragment mFragment = new ItemDetailsFragment();
        mFragment.init(mIntent);
        return mFragment;
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
