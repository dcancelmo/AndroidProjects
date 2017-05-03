package project3.csc214.project3_final;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import project3.csc214.project3_final.model.InfoItem;


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
        View mView = inflater.inflate(R.layout.fragment_item_details, container, false);

        TextView mNameText = (TextView) mView.findViewById(R.id.details_name_text);
        TextView mAddressText = (TextView) mView.findViewById(R.id.details_address_text);
        TextView mPhoneText = (TextView) mView.findViewById(R.id.details_phone_text);
        TextView mWebsiteText = (TextView) mView.findViewById(R.id.details_website_text);
        TextView mHoursText = (TextView) mView.findViewById(R.id.details_hours_text);
        TextView mDescriptionText = (TextView) mView.findViewById(R.id.details_description_text);

        mNameText.setText(mName);
        mAddressText.setText(mAddress);
        mPhoneText.setText(mPhone);
        mWebsiteText.setText(mWebsiteString);
        mHoursText.setText(mHours);
        mDescriptionText.setText(mDescription);

        return mView;
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

    public static ItemDetailsFragment newInstance(InfoItem mItem) {
        ItemDetailsFragment mFrag = new ItemDetailsFragment();
        Bundle mArgs = new Bundle();
        mArgs.putString(NAME, mItem.getName());
        mArgs.putString(ADDRESS, mItem.getAddress());
        mArgs.putString(PHONE_NUMBER, mItem.getPhoneNumber());
        if (mItem.getWebsite() != null) {
            mArgs.putString(WEBSITE, mItem.getWebsite().toString());
        }
        mArgs.putString(HOURS, mItem.getHours());
        mArgs.putString(DESCRIPTION, mItem.getDescription());
        mFrag.setArguments(mArgs);
        return mFrag;
    }

}
