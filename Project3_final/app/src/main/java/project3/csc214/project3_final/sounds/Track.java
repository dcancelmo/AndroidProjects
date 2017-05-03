package project3.csc214.project3_final.sounds;

/**
 * Created by Dan on 5/3/17.
 */

public class Track {
    private final String mPath;
    private final String mName;
    private Integer mId;

    //Creates the track object
    public Track(String path, String name) {
        mPath = path;
        mName = name;
    }

    public String getPath() {
        return mPath;
    }

    public String getName() {
        return mName;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }
}
