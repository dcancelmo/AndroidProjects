package project3.csc214.project3_final.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import project3.csc214.project3_final.model.InfoItem;

/**
 * Created by Dan on 4/29/17.
 */

public class CustomEntryDb {

    private static  final String TAG = "Cancelmo_Debug_3";

    private static CustomEntryDb SINGLETON;

    private final SQLiteDatabase mDatabase;

    private CustomEntryDb(Context mContext) {
        mDatabase = new CustomEntryHelper(mContext).getWritableDatabase();
    }

    public static CustomEntryDb get(Context context) {
        if(SINGLETON == null) {
            Log.i(TAG, "CustomEntryDb get(Context) called\nNew CustomEntryDb created and returned");
            SINGLETON = new CustomEntryDb(context);
        }
        return SINGLETON;
    }

    public void update(ContentValues mNewData, String mName) {
        mDatabase.update(CustomEntryDbSchema.CustomEntries.NAME, mNewData, "name = ?", new String[]{mName});
    }


    public InfoItem getItem(String mLocationName) {
        Cursor mCursor = mDatabase.query(
                CustomEntryDbSchema.CustomEntries.NAME,
                null,
                "name = ?",
                new String[] {mLocationName},
                null,
                null,
                null
        );
        CustomEntryCursorWrapper mWrapper = new CustomEntryCursorWrapper(mCursor);
        InfoItem mInfoItem;
        if(mWrapper.getCount() > 0) {
            mWrapper.moveToFirst();
            mInfoItem = mWrapper.getInfoItem();
        }
        else {
            mInfoItem = null;
        }
        mWrapper.close();

        return mInfoItem;
    }

    public ArrayList<InfoItem> getInfoItemList() {
        Cursor mCursor = mDatabase.query(
                CustomEntryDbSchema.CustomEntries.NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
        CustomEntryCursorWrapper mWrapper = new CustomEntryCursorWrapper(mCursor);
        ArrayList<InfoItem> mUserList = new ArrayList<>();
        if(mWrapper.getCount() > 0) {
            try{
                mWrapper.moveToFirst();
                mUserList.add(mWrapper.getInfoItem());
                do {
                    mWrapper.moveToNext();
                    mUserList.add(mWrapper.getInfoItem());
                } while (!mWrapper.isLast());
            } catch (CursorIndexOutOfBoundsException mException) {
            }
        }

        mWrapper.close();

        return mUserList;
    }


    public void insertInfoItem(InfoItem mItem) {
        ContentValues values = getUserContentValues(mItem);
        mDatabase.insert(CustomEntryDbSchema.CustomEntries.NAME, null, values);
    }
    private static ContentValues getUserContentValues(InfoItem item) {
        ContentValues values = new ContentValues();
        values.put(CustomEntryDbSchema.CustomEntries.Cols.NAME, item.getName());
        values.put(CustomEntryDbSchema.CustomEntries.Cols.ADDRESS, item.getAddress());
        values.put(CustomEntryDbSchema.CustomEntries.Cols.PHONE_NUMBER, item.getPhoneNumber());
        try {
            values.put(CustomEntryDbSchema.CustomEntries.Cols.WEBSITE, item.getWebsite().toString());
        } catch (NullPointerException e) {
            e.printStackTrace();
            values.put(CustomEntryDbSchema.CustomEntries.Cols.WEBSITE, "");
        }
        values.put(CustomEntryDbSchema.CustomEntries.Cols.HOURS, item.getHours());
        values.put(CustomEntryDbSchema.CustomEntries.Cols.DESCRIPTION, item.getDescription());
        return values;
    }
}
