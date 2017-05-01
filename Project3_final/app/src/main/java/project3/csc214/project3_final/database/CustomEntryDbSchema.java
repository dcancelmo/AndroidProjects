package project3.csc214.project3_final.database;

/**
 * Created by Dan on 4/29/17.
 */

public class CustomEntryDbSchema {
    public static final String DATABASE_NAME = "UR_Phonebook.db";
    public static final int VERSION = 1;

    public static class CustomEntries {
        public static final String NAME = "custom_entries";
        public static class Cols {
            public static final String NAME = "name";
            public static final String ADDRESS = "address";
            public static final String PHONE_NUMBER = "phone_number";
            public static final String WEBSITE = "website";
            public static final String HOURS = "hours";
            public static final String DESCRIPTION = "description";
        }
    }

}
