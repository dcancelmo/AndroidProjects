package homework08.csc214.homework8_sounds;

/**
 * Created by Dan on 4/11/17.
 */

public class Track {
    private final String mPath;
    private final String mName;
    private final String mAlbum;
    private final String mArtist;
    private Integer mId;

    public Track(String path, String name, String album, String artist) {
        mPath = path;
        mName = name;
        mAlbum = album;
        mArtist = artist;
    }

    public String getPath() {
        return mPath;
    }

    public String getName() {
        return mName;
    }

    public String getAlbum() {
        return mAlbum;
    }

    public String getArtist() {
        return mArtist;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }
}
