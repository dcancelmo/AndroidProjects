package project3.csc214.project3_final.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dan on 4/29/17.
 */

public class CustomEntryHelper extends SQLiteOpenHelper {
    public CustomEntryHelper(Context context) {
        super(context, CustomEntryDbSchema.DATABASE_NAME, null, CustomEntryDbSchema.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + CustomEntryDbSchema.CustomEntries.NAME
                + "(_id integer primary key autoincrement, "
                + CustomEntryDbSchema.CustomEntries.Cols.NAME + ", "
                + CustomEntryDbSchema.CustomEntries.Cols.ADDRESS + ", "
                + CustomEntryDbSchema.CustomEntries.Cols.PHONE_NUMBER + ", "
                + CustomEntryDbSchema.CustomEntries.Cols.WEBSITE + ", "
                + CustomEntryDbSchema.CustomEntries.Cols.HOURS + ", "
                + CustomEntryDbSchema.CustomEntries.Cols.DESCRIPTION + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
