package assignment07.csc214.homework7_sqlite;

/**
 * Created by Dan on 4/4/17.
 */

public class CourseDbSchema {

    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "course_database.db";

    public static final class CourseTable {

        public static final String NAME = "Courses";

        public static final class Cols {
            public static final String COURSE_NUM = "course_num";
            public static final String COURSE_NAME = "course_name";
            public static final String INSTRUCTOR = "instructor";
            public static final String DESCRIPTION = "description";
        }
    }
}
