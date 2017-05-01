package project3.csc214.project3_final;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import project3.csc214.project3_final.model.InfoItem;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemDialogFragment extends DialogFragment {

    private static final String TAG = "Cancelmo_Debug_3";

    private static final String NAME = "project3.csc214.project3_final.infoitem.name";
    private static final String ADDRESS = "project3.csc214.project3_final.infoitem.address";
    private static final String PHONE_NUMBER = "project3.csc214.project3_final.infoitem.phone_number";
    private static final String WEBSITE = "project3.csc214.project3_final.infoitem.website";
    private static final String HOURS = "project3.csc214.project3_final.infoitem.hours";
    private static final String DESCRIPTION = "project3.csc214.project3_final.infoitem.description";




    public ItemDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setRetainInstance(true);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_dialog, container, false);
    }

    public static ItemDialogFragment newInstance(InfoItem mItem) {
        ItemDialogFragment mDialog = new ItemDialogFragment();
        Bundle mArgs = new Bundle();
        mArgs.putString(NAME, mItem.getName());
        mArgs.putString(ADDRESS, mItem.getAddress());
        mArgs.putString(PHONE_NUMBER, mItem.getPhoneNumber());
        if (mItem.getWebsite() != null) {
            mArgs.putString(WEBSITE, mItem.getWebsite().toString());
        }
        mArgs.putString(HOURS, mItem.getHours());
        mArgs.putString(DESCRIPTION, mItem.getDescription());
        mDialog.setArguments(mArgs);
        return mDialog;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View mView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_item_dialog, null);
        final Bundle mArgs = getArguments();
        TextView mPhoneView = (TextView) mView.findViewById(R.id.dialog_phone_text_view);
        mPhoneView.setText(mArgs.getString(PHONE_NUMBER));
        TextView mAddressView = (TextView) mView.findViewById(R.id.dialog_address_text_view);
        mAddressView.setText(mArgs.getString(ADDRESS));
        if (mArgs.getString(WEBSITE) != null) {
            TextView mWebView = (TextView) mView.findViewById(R.id.dialog_website_text_view);
            mWebView.setText(mArgs.getString(WEBSITE));
            Log.i(TAG, mArgs.getString(WEBSITE));
        }
        return new AlertDialog.Builder(getActivity()).setView(mView).setTitle(mArgs.getString(NAME))
                .setPositiveButton(getString(R.string.details), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent mIntent = new Intent(getContext(), ItemDetailsActivity.class);
                        //mArgs is final
                        mIntent.putExtra(NAME, mArgs.getString(NAME));
                        mIntent.putExtra(ADDRESS, mArgs.getString(ADDRESS));
                        mIntent.putExtra(PHONE_NUMBER, mArgs.getString(PHONE_NUMBER));
                        mIntent.putExtra(WEBSITE, mArgs.getString(WEBSITE));
                        mIntent.putExtra(HOURS, mArgs.getString(HOURS));
                        mIntent.putExtra(DESCRIPTION, mArgs.getString(DESCRIPTION));
                        startActivity(mIntent);
                    }
                })
                .setNeutralButton(getString(R.string.close), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dismiss();
                    }
                }).create();

    }

}
