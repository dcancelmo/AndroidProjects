package aproject02.csc214.project2_network.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dan on 4/8/17.
 */

public class NetworkHelper extends SQLiteOpenHelper {
    public NetworkHelper(Context context) {
        super(context, NetworkDbSchema.DATABASE_NAME, null, NetworkDbSchema.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + NetworkDbSchema.Users.NAME
                + "(_id integer primary key autoincrement, "
                + NetworkDbSchema.Users.Cols.EMAIL + ", "
                + NetworkDbSchema.Users.Cols.USERNAME + ", "
                + NetworkDbSchema.Users.Cols.PASSWORD + ", "
                + NetworkDbSchema.Users.Cols.FIRST_NAME + ", "
                + NetworkDbSchema.Users.Cols.LAST_NAME + ", "
                + NetworkDbSchema.Users.Cols.BIRTH_DATE + ", "
                + NetworkDbSchema.Users.Cols.PROFILE_PIC + ","
                + NetworkDbSchema.Users.Cols.HOMETOWN + ", "
                + NetworkDbSchema.Users.Cols.BIO + ")"
        );

        db.execSQL("CREATE TABLE " + NetworkDbSchema.Posts.NAME
                + "(_id integer primary key autoincrement, "
                + NetworkDbSchema.Posts.Cols.USERNAME + ", "
                + NetworkDbSchema.Posts.Cols.POSTED_DATE + ", "
                + NetworkDbSchema.Posts.Cols.TEXT_CONTENT + ", "
                + NetworkDbSchema.Posts.Cols.PHOTO_PATH + ")"
        );

        db.execSQL("CREATE TABLE " + NetworkDbSchema.Favorites.NAME
                + "(_id integer primary key autoincrement, "
                + NetworkDbSchema.Favorites.Cols.EMAIL + ", "
                + NetworkDbSchema.Favorites.Cols.FAVORITE + ")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
