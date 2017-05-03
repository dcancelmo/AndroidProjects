package project3.csc214.project3_final;

/**
 * Created by Dan on 5/3/17.
 */

public class Song {
    private final String mName;
    private final String mPath;

    public Song(String name, String path) {
        mName = name;
        mPath = path;
    }

    public String getName() {
        return mName;
    }

    public String getPath() {
        return mPath;
    }
}
