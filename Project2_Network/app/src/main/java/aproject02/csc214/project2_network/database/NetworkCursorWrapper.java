package aproject02.csc214.project2_network.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.Date;

import aproject02.csc214.project2_network.model.User;

/**
 * Created by Dan on 4/8/17.
 */

public class NetworkCursorWrapper extends CursorWrapper {
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
        mUser.setUsername(getString(getColumnIndex(NetworkDbSchema.Users.Cols.USERNAME)));
        mUser.setPassword(getString(getColumnIndex(NetworkDbSchema.Users.Cols.PASSWORD)));
        mUser.setFirstName(getString(getColumnIndex(NetworkDbSchema.Users.Cols.FIRST_NAME)));
        mUser.setLastName(getString(getColumnIndex(NetworkDbSchema.Users.Cols.LAST_NAME)));
        mUser.setBirthDate(new Date(getLong(getColumnIndex(NetworkDbSchema.Users.Cols.BIRTH_DATE))));
        mUser.setProfilePic(getString(getColumnIndex(NetworkDbSchema.Users.Cols.PROFILE_PIC)));

        return mUser;
    }
}
