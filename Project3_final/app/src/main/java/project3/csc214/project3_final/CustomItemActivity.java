package project3.csc214.project3_final;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

import project3.csc214.project3_final.database.CustomEntryDb;
import project3.csc214.project3_final.model.InfoItem;

public class CustomItemActivity extends AppCompatActivity {

    private static  final String TAG = "Cancelmo_Debug_3";

    private static final String NAME = "project3.csc214.project3_final.infoitem.name";
    private static final String ADDRESS = "project3.csc214.project3_final.infoitem.address";
    private static final String PHONE_NUMBER = "project3.csc214.project3_final.infoitem.phone_number";
    private static final String WEBSITE = "project3.csc214.project3_final.infoitem.website";
    private static final String HOURS = "project3.csc214.project3_final.infoitem.hours";
    private static final String DESCRIPTION = "project3.csc214.project3_final.infoitem.description";

    private CustomEntryDb mDatabase;
    CustomItemFragment mFragment;
    FragmentManager mFragManager;

    public String mName;
    public String mAddress;
    public String mPhone;
    public String mWebsiteString;
    public String mHours;
    public String mDescription;

    static EditText sNameEdit;
    static EditText sAddressEdit;
    static EditText sPhoneEdit;
    static EditText sWebsiteEdit;
    static EditText sHoursEdit;
    static EditText sDescriptionEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate CustomItemActivity called");
        mDatabase = CustomEntryDb.get(getApplicationContext());
        setContentView(R.layout.activity_custom_item);
        if (savedInstanceState == null) {
            mFragManager = getSupportFragmentManager();
            mFragment = new CustomItemFragment();
            mFragManager.beginTransaction().add(R.id.custom_item_frame_layout, mFragment).commit();
        }
        sNameEdit = (EditText) findViewById(R.id.name_enter);
        sAddressEdit = (EditText) findViewById(R.id.address_enter);
        sPhoneEdit = (EditText) findViewById(R.id.phone_enter);
        sWebsiteEdit = (EditText) findViewById(R.id.website_enter);
        sHoursEdit = (EditText) findViewById(R.id.hours_enter);
        sDescriptionEdit = (EditText) findViewById(R.id.description_enter);

//        if (savedInstanceState != null) {
//            mName = savedInstanceState.getString(NAME);
//            mAddress = savedInstanceState.getString(ADDRESS);
//            mPhone = savedInstanceState.getString(PHONE_NUMBER);
//            mWebsiteString = savedInstanceState.getString(WEBSITE);
//            mHours = savedInstanceState.getString(HOURS);
//            mDescription = savedInstanceState.getString(DESCRIPTION);
//            sNameEdit.setText(mName);
//            sAddressEdit.setText(mAddress);
//            sPhoneEdit.setText(mPhone);
//            sWebsiteEdit.setText(mWebsiteString);
//            sHoursEdit.setText(mHours);
//            sDescriptionEdit.setText(mDescription);
//        }
    }

    public static Intent newIntent(Context mContext) {
        Intent intent = new Intent(mContext, CustomItemActivity.class);
        return intent;
    }


    public void acceptNewEntry(View view) {
        InfoItem mNewItem;
        sNameEdit = (EditText) findViewById(R.id.name_enter);
        sAddressEdit = (EditText) findViewById(R.id.address_enter);
        sPhoneEdit = (EditText) findViewById(R.id.phone_enter);
        sWebsiteEdit = (EditText) findViewById(R.id.website_enter);
        sHoursEdit = (EditText) findViewById(R.id.hours_enter);
        sDescriptionEdit = (EditText) findViewById(R.id.description_enter);
        try {
            String mURLString = sWebsiteEdit.getText().toString();
            //Prevents a blank website field from becoming "http://"
            if (mURLString.equals("")) {
                new URL(mURLString);
            }
            if (!mURLString.startsWith("http://")) {
                String mNewString = "http://";
                mNewString += mURLString;
                mURLString = mNewString;
            }
            URL mWebsiteURL = new URL(mURLString);
            mNewItem = new InfoItem(sNameEdit.getText().toString(), sAddressEdit.getText().toString(), sPhoneEdit.getText().toString(), mWebsiteURL, sHoursEdit.getText().toString(), sDescriptionEdit.getText().toString());
            mDatabase.insertInfoItem(mNewItem);
        } catch (MalformedURLException e) {
            Log.d(TAG, "Malformed or blank URL");
            e.printStackTrace();
            Toast.makeText(this, R.string.malformed_url, Toast.LENGTH_LONG).show();
            mNewItem = new InfoItem(sNameEdit.getText().toString(), sAddressEdit.getText().toString(), sPhoneEdit.getText().toString(), sHoursEdit.getText().toString(), sDescriptionEdit.getText().toString());
            mDatabase.insertInfoItem(mNewItem);
        }

        Toast.makeText(this, R.string.custom_entry_successfully_created, Toast.LENGTH_LONG).show();
        finish();
    }

    public void cancelNewEntry(View view) {
        Toast.makeText(this, getString(R.string.custom_entry_not_created), Toast.LENGTH_LONG).show();
        finish();
    }

//    @Override
//    protected void onSaveInstanceState(Bundle state) {
//        state.putString(NAME, mName);
//        state.putString(ADDRESS, mAddress);
//        state.putString(PHONE_NUMBER, mPhone);
//        state.putString(WEBSITE, mWebsiteString);
//        state.putString(HOURS, mHours);
//        state.putString(DESCRIPTION, mDescription);
//    }
}
