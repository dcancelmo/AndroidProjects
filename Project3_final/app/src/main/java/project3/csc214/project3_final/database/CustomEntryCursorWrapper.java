package project3.csc214.project3_final.database;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import project3.csc214.project3_final.model.InfoItem;

/**
 * Created by Dan on 4/29/17.
 */

public class CustomEntryCursorWrapper extends CursorWrapper {

    private static  final String TAG = "Cancelmo_Debug_3";

    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public CustomEntryCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public InfoItem getInfoItem() {
        InfoItem mInfoItem = new InfoItem();
        mInfoItem.setName(getString(getColumnIndex(CustomEntryDbSchema.CustomEntries.Cols.NAME)));
        mInfoItem.setAddress(getString(getColumnIndex(CustomEntryDbSchema.CustomEntries.Cols.ADDRESS)));
        mInfoItem.setPhoneNumber(getString(getColumnIndex(CustomEntryDbSchema.CustomEntries.Cols.PHONE_NUMBER)));
        try {
            mInfoItem.setWebsite(new URL(getString(getColumnIndex(CustomEntryDbSchema.CustomEntries.Cols.WEBSITE))));
        } catch (MalformedURLException e) {
            Log.d(TAG, "\nMalformed URL:\n");
            e.printStackTrace();
        }
        mInfoItem.setHours(getString(getColumnIndex(CustomEntryDbSchema.CustomEntries.Cols.HOURS)));
        mInfoItem.setDescription(getString(getColumnIndex(CustomEntryDbSchema.CustomEntries.Cols.DESCRIPTION)));
        return mInfoItem;
    }
}
