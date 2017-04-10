package aproject02.csc214.project2_network.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dan on 4/8/17.
 */

public class Post {
    private String mUsername;
    private Date mPostedDate;
    private String mContent;
    private String mPhotoPath;

    private static final DateFormat FORMAT = new SimpleDateFormat("mm/dd/yyyy");

    public Post() {
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public Date getPostedDate() {
        return mPostedDate;
    }

    public void setPostedDate(Date mPostedDate) {
        this.mPostedDate = mPostedDate;
    }

    public void setPostedDate(String mPostedDate) throws ParseException {
        this.mPostedDate = FORMAT.parse(mPostedDate);
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }

    public String getPhotoPath() {
        return mPhotoPath;
    }

    public void setPhotoPath(String mPhotoPath) {
        this.mPhotoPath = mPhotoPath;
    }

    @Override
    public String toString() {
        return getUsername() + "\n" + getContent() + "\n" + getPostedDate();
    }

}
