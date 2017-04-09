package aproject02.csc214.project2_network.model;

import java.util.Date;

/**
 * Created by Dan on 4/8/17.
 */

public class Post {
    private String mUsername;
    private Date mPostedDate;
    private String mContent;
    private String mPhotoPath;


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


}
