package assignment07.csc214.homework7_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dan on 4/4/17.
 */

public class CourseDatabaseHelper extends SQLiteOpenHelper {



    public CourseDatabaseHelper (Context context) {

        super(context, CourseDbSchema.DATABASE_NAME, null, CourseDbSchema.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + CourseDbSchema.CourseTable.NAME
                + "(_id integer primary key autoincrement, "
                + CourseDbSchema.CourseTable.Cols.COURSE_NUM + ", "
                + CourseDbSchema.CourseTable.Cols.COURSE_NAME + ", "
                + CourseDbSchema.CourseTable.Cols.INSTRUCTOR + ", "
                + CourseDbSchema.CourseTable.Cols.DESCRIPTION + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
