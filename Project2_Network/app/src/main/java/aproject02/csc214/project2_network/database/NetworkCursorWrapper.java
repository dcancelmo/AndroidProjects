package aproject02.csc214.project2_network.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import aproject02.csc214.project2_network.model.Post;
import aproject02.csc214.project2_network.model.User;

/**
 * Created by Dan on 4/8/17.
 */

public class NetworkCursorWrapper extends CursorWrapper {

    private static final DateFormat FORMAT = new SimpleDateFormat("mm/dd/yyyy");

    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public NetworkCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public User getUser() {
        User mUser = new User();
        mUser.setEmail(getString(getColumnIndex(NetworkDbSchema.Users.Cols.EMAIL)));
        mUser.setUsername(getString(getColumnIndex(NetworkDbSchema.Users.Cols.USERNAME)));
        mUser.setPassword(getString(getColumnIndex(NetworkDbSchema.Users.Cols.PASSWORD)));
        mUser.setFirstName(getString(getColumnIndex(NetworkDbSchema.Users.Cols.FIRST_NAME)));
        mUser.setLastName(getString(getColumnIndex(NetworkDbSchema.Users.Cols.LAST_NAME)));
        mUser.setBirthDate(new Date(getLong(getColumnIndex(NetworkDbSchema.Users.Cols.BIRTH_DATE))));
        mUser.setProfilePic(getString(getColumnIndex(NetworkDbSchema.Users.Cols.PROFILE_PIC)));
        mUser.setHometown(getString(getColumnIndex(NetworkDbSchema.Users.Cols.HOMETOWN)));
        mUser.setBio(getString(getColumnIndex(NetworkDbSchema.Users.Cols.BIO)));
        return mUser;
    }

    public Post getPost() {
        Post mPost = new Post();
        mPost.setUsername(getString(getColumnIndex(NetworkDbSchema.Posts.Cols.USERNAME)));
        mPost.setContent(getString(getColumnIndex(NetworkDbSchema.Posts.Cols.TEXT_CONTENT)));
        mPost.setPhotoPath(getString(getColumnIndex(NetworkDbSchema.Posts.Cols.PHOTO_PATH)));
        mPost.setPostedDate(new Date(getLong(getColumnIndex(NetworkDbSchema.Posts.Cols.POSTED_DATE))));
        return mPost;
    }
}
