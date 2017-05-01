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

    private CustomEntryDb mDatabase;
    CustomItemFragment mFragment;
    FragmentManager mFragManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate CustomItemActivity called");
        mDatabase = CustomEntryDb.get(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_item);
        mFragManager = getSupportFragmentManager();
        mFragment = new CustomItemFragment();
        mFragManager.beginTransaction().add(R.id.custom_item_frame_layout, mFragment).commit();
    }

    public static Intent newIntent(Context mContext) {
        Intent intent = new Intent(mContext, CustomItemActivity.class);
        return intent;
    }


    public void acceptNewEntry(View view) {
        EditText mNameEdit = (EditText) findViewById(R.id.name_enter);
        EditText mAddressEdit = (EditText) findViewById(R.id.address_enter);
        EditText mPhoneEdit = (EditText) findViewById(R.id.phone_enter);
        EditText mWebsiteEdit = (EditText) findViewById(R.id.website_enter);
        EditText mHoursEdit = (EditText) findViewById(R.id.hours_enter);
        EditText mDescriptionEdit = (EditText) findViewById(R.id.description_enter);
        InfoItem mNewItem;
        try {
            String mURLString = mWebsiteEdit.getText().toString();
            if (!mURLString.startsWith("http://")) {
                String mNewString = "http://";
                mNewString += mURLString;
                mURLString = mNewString;
            }
            URL mWebsiteURL = new URL(mURLString);
            mNewItem = new InfoItem(mNameEdit.getText().toString(), mAddressEdit.getText().toString(), mPhoneEdit.getText().toString(), mWebsiteURL, mHoursEdit.getText().toString(), mDescriptionEdit.getText().toString());
            mDatabase.insertInfoItem(mNewItem);
        } catch (MalformedURLException e) {
            Log.d(TAG, "Malformed URL");
            e.printStackTrace();
            Toast.makeText(this, R.string.malformed_url, Toast.LENGTH_LONG).show();
            mNewItem = new InfoItem(mNameEdit.getText().toString(), mAddressEdit.getText().toString(), mPhoneEdit.getText().toString(), mHoursEdit.getText().toString(), mDescriptionEdit.getText().toString());
            mDatabase.insertInfoItem(mNewItem);
        }

        Toast.makeText(this, R.string.custom_entry_successfully_created, Toast.LENGTH_LONG).show();
        finish();
    }

    public void cancelNewEntry(View view) {
        Toast.makeText(this, getString(R.string.custom_entry_not_created), Toast.LENGTH_LONG).show();
        finish();
    }
}
