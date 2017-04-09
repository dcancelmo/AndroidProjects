package aproject02.csc214.project2_network.model;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;

import aproject02.csc214.project2_network.database.NetworkDb;

/**
 * Created by Dan on 4/8/17.
 */

public class User {
    private String mEmail;
    private String mUsername;
    private String mPassword;
    private String mFirstName;
    private String mLastName;
    private Date mBirthDate;
    private String mProfilePic;
    private String mHometown;
    private String mBio;
    private NetworkDb mPostList;
    private NetworkDb mFavoriteList;

    public User() {
    }

    public User(String mEmail, String mUsername, String mPassword) {
        this.mEmail = mEmail;
        this.mUsername = mUsername;
        this.mPassword = mPassword;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public Date getBirthDate() {
        return mBirthDate;
    }

    public void setBirthDate(Date mBirthDate) {
        this.mBirthDate = mBirthDate;
    }

    public String getProfilePic() {
        return mProfilePic;
    }

    public void setProfilePic(String mProfilePic) {
        this.mProfilePic = mProfilePic;
    }

    public String getHometown() {
        return mHometown;
    }

    public void setHometown(String mHometown) {
        this.mHometown = mHometown;
    }

    public String getBio() {
        return mBio;
    }

    public void setBio(String mBio) {
        this.mBio = mBio;
    }

    public NetworkDb getPostList() {

        return mPostList;
    }

    public void setPostList(NetworkDb mPostList) {
        this.mPostList = mPostList;
    }

    public NetworkDb getFavoriteList() {
        return mFavoriteList;
    }

    public void setFavoriteList(NetworkDb mFavoriteList) {
        this.mFavoriteList = mFavoriteList;
    }
}
