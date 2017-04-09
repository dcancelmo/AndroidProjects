package aproject02.csc214.project2_network.database;

/**
 * Created by Dan on 4/8/17.
 */

public class NetworkDbSchema {

    public static final String DATABASE_NAME = "URNetwork.db";
    public static final int VERSION = 1;

    public static class Users {
        public static final String NAME = "users";
        public static class Cols {
            public static final String EMAIL = "email";
            public static final String USERNAME = "username";
            public static final String PASSWORD = "password";
            public static final String FIRST_NAME = "first_name";
            public static final String LAST_NAME = "last_name";
            public static final String BIRTH_DATE = "birth_date";
            public static final String PROFILE_PIC = "profile_pic";
            public static final String HOMETOWN = "hometown";
            public static final String BIO = "bio";
            public static final String POST_LIST = "post_list";
            public static final String FAVORITE_LIST = "favorite_list";
        }
    }

    public static class Posts {
        public static final String NAME = "posts";
        public static class Cols {
            public static final String USERNAME = "username";
            public static final String POSTED_DATE = "posted_date";
            public static final String TEXT_CONTENT = "text_content";
            public static final String PHOTO_PATH = "photo_path";
        }
    }

}
