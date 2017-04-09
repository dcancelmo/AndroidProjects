package aproject02.csc214.project2_network.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import aproject02.csc214.project2_network.model.Post;
import aproject02.csc214.project2_network.model.User;

/**
 * Created by Dan on 4/8/17.
 */

public class NetworkDb {
    private static final String TAG = "cancelmo_network_test";
    private static final DateFormat FORMAT = new SimpleDateFormat("mm/dd/yyyy");


    private static NetworkDb SINGLETON;

    private final SQLiteDatabase mDatabase;

    private NetworkDb(Context mContext) {
        mDatabase = new NetworkHelper(mContext).getWritableDatabase();
    }

    public static NetworkDb get(Context context) {
        if(SINGLETON == null) {
            Log.i(TAG, "NetworkDb get(Context) called\nNew NetworkDb created and returned");
            SINGLETON = new NetworkDb(context);
        }
        return SINGLETON;
    }

    public void update(ContentValues mNewData, String mEmail) {
        mDatabase.update(NetworkDbSchema.Users.NAME, mNewData, "email= ?", new String[]{mEmail});
    }


        public User getUser(String mUsername, String mPassword) {
        Cursor mCursor = mDatabase.query(
                NetworkDbSchema.Users.NAME,
                null,
                "username = ? AND password = ?",
                new String[] {mUsername, mPassword},
                null,
                null,
                null
        );
        NetworkCursorWrapper mWrapper = new NetworkCursorWrapper(mCursor);
        User mUser;
        if(mWrapper.getCount() > 0) {
            mWrapper.moveToFirst();
            mUser = mWrapper.getUser();
        }
        else {
            mUser = null;
        }
        mWrapper.close();

        return mUser;
    }

    public User getUser(String mEmail) {
        Cursor mCursor = mDatabase.query(
                NetworkDbSchema.Users.NAME,
                null,
                "email = ?",
                new String[] {mEmail},
                null,
                null,
                null
        );
        NetworkCursorWrapper mWrapper = new NetworkCursorWrapper(mCursor);
        User mUser;
        if(mWrapper.getCount() > 0) {
            mWrapper.moveToFirst();
            mUser = mWrapper.getUser();
        }
        else {
            mUser = null;
        }
        mWrapper.close();

        return mUser;
    }

    public User getUserByName(String mUsername) {
        Cursor mCursor = mDatabase.query(
                NetworkDbSchema.Users.NAME,
                null,
                "username = ?",
                new String[] {mUsername},
                null,
                null,
                null
        );
        NetworkCursorWrapper mWrapper = new NetworkCursorWrapper(mCursor);
        User mUser;
        if(mWrapper.getCount() > 0) {
            mWrapper.moveToFirst();
            mUser = mWrapper.getUser();
        }
        else {
            mUser = null;
        }
        mWrapper.close();

        return mUser;
    }

    public void insertUser(User mUser) {
        ContentValues values = getUserContentValues(mUser);
        mDatabase.insert(NetworkDbSchema.Users.NAME, null, values);
    }

    public void insertFeedItem(Post mPost) {
        ContentValues values = getPostContentValues(mPost);
        mDatabase.insert(NetworkDbSchema.Posts.NAME, null, values);
    }



    private static ContentValues getUserContentValues(User user) {
        ContentValues values = new ContentValues();
        values.put(NetworkDbSchema.Users.Cols.EMAIL, user.getEmail());
        values.put(NetworkDbSchema.Users.Cols.USERNAME, user.getUsername());
        values.put(NetworkDbSchema.Users.Cols.PASSWORD, user.getPassword());
        values.put(NetworkDbSchema.Users.Cols.FIRST_NAME, user.getFirstName());
        values.put(NetworkDbSchema.Users.Cols.LAST_NAME, user.getLastName());
        if (user.getBirthDate() != null) {
            values.put(NetworkDbSchema.Users.Cols.BIRTH_DATE, user.getBirthDate().getTime());
        }
        values.put(NetworkDbSchema.Users.Cols.PROFILE_PIC, user.getProfilePic());
        return values;
    }

    private static ContentValues getPostContentValues(Post mPost) {
        ContentValues values = new ContentValues();
        values.put(NetworkDbSchema.Posts.Cols.USERNAME, mPost.getUsername());
        values.put(NetworkDbSchema.Posts.Cols.POSTED_DATE, mPost.getPostedDate().getTime());
        values.put(NetworkDbSchema.Posts.Cols.TEXT_CONTENT, mPost.getContent());
        values.put(NetworkDbSchema.Posts.Cols.PHOTO_PATH, mPost.getPhotoPath());
        return values;
    }
}