package project3.csc214.project3_final.model;

import android.net.Uri;

import java.net.URL;

/**
 * Created by Dan on 4/29/17.
 */

public class InfoItem {

    private String mName;
    private String mAddress;
    private String mPhoneNumber;
    private URL mWebsite;
    private String mHours;
    private String mDescription;

    public InfoItem() {
    }


    public InfoItem(String mPName) {
        mName = mPName;
    }
    public InfoItem(String mPName, String mPAddress, String mPPhoneNumber, URL mPWebsite, String mPHours, String mPDescription) {
        mName = mPName;
        mAddress = mPAddress;
        mPhoneNumber = mPPhoneNumber;
        mWebsite = mPWebsite;
        mHours = mPHours;
        mDescription = mPDescription;
    }

    public InfoItem(String mPName, String mPAddress, String mPPhoneNumber, String mPHours, String mPDescription) {
        mName = mPName;
        mAddress = mPAddress;
        mPhoneNumber = mPPhoneNumber;
        mHours = mPHours;
        mDescription = mPDescription;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public URL getWebsite() {
        return mWebsite;
    }

    public void setWebsite(URL mWebsite) {
        this.mWebsite = mWebsite;
    }

    public String getHours() {
        return mHours;
    }

    public void setHours(String mHours) {
        this.mHours = mHours;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    @Override
    public String toString() {
        if (getAddress().equals("") && getHours().equals("")) {
            return getPhoneNumber();
        } else if (getAddress().equals("") && !getPhoneNumber().equals("")) {
            return getPhoneNumber() + "\n" + getHours();
        } else if (getAddress().equals("")) {
            return getHours();
        } else if (getHours().equals("")) {
            return getAddress();
        } else {
            return getAddress() + "\n" + getHours();
        }
    }
}
