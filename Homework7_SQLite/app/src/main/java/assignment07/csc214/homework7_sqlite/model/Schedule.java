package assignment07.csc214.homework7_sqlite.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import assignment07.csc214.homework7_sqlite.CourseCursorWrapper;
import assignment07.csc214.homework7_sqlite.CourseDatabaseHelper;
import assignment07.csc214.homework7_sqlite.CourseDbSchema;

/**
 * Created by Dan on 3/22/17.
 */

public class Schedule {
    private static Schedule sSchedule;
    private Context mAppContext;
    //private Map<Integer, Course> sMapSchedule;
    private ArrayList<Course> sListSchedule;

    private final Context mContext;
    private final SQLiteDatabase mDatabase;

    private Schedule(Context appContext) {
        mAppContext = appContext;
        //sMapSchedule = new HashMap<>();
        sListSchedule = new ArrayList<>();
        mContext = appContext.getApplicationContext();
        mDatabase = new CourseDatabaseHelper(mContext).getWritableDatabase();
//        addCourse("CSC Computation and Formal Systems", 173, "Ferguson", "Investigation of several formal systems influential in computer science, and also some of their applications (e.g. inspiring and providing the foundation for a computer programming style, or providing the basis for solving important practical problems like communications protocols, compiling, systems analysis, graphics ...)");
//        addCourse("CSC Computer Organization", 252, "Ipek", "Introduction to computer architecture and the layering of hardware/software systems. Topics include instruction set design; logical building blocks; computer arithmetic; processor organization; the memory hierarchy (registers, caches, main memory, and secondary storage); I/O—buses, devices, and interrupts; microcode and assembly language; virtual machines; the roles of the assembler, linker, compiler, and operating system; technological trends and the future of computing hardware. Several programming assignments required.");
//        addCourse("CSC Android Mobile App Dev", 214, "StJacques", "Coursework covers user interface designs and functional algorithms for mobile devices (Android) and unique user interactions using multi-touch technologies. Object-oriented design using model-view-controller paradigm, memory management. Other topics include: object-oriented database API, animation, multi-threading and performance considerations");
    }

    public void addCourse(String mCourseName, int mCourseNum, String mInstructor, String mDescription) {
        Course mNewCourse = new Course(mCourseName, mCourseNum, mInstructor, mDescription);
        sListSchedule.add(mNewCourse);
    }

    public List<Course> getSchedule() {
//        for (int i = 0; i < 20; i++) {
//            Log.d("DEBUGTAG", "CHECK " + sListSchedule.get(i));
//        }
        return sListSchedule;
    }
    public static Schedule get(Context mContext) {
        if(sSchedule == null) {
            sSchedule = new Schedule(mContext);
        }
        return sSchedule;
    }

    public void addCourse(Course mCourse) {
        ContentValues mValues = getContentValues(mCourse);
        mDatabase.insert(CourseDbSchema.CourseTable.NAME, null, mValues);
    }

    private static ContentValues getContentValues(Course mCourse) {
        ContentValues mValues = new ContentValues();
        mValues.put(CourseDbSchema.CourseTable.Cols.COURSE_NUM, mCourse.getCourseNum().toString());
        mValues.put(CourseDbSchema.CourseTable.Cols.COURSE_NAME, mCourse.getCourseName().toString());
        mValues.put(CourseDbSchema.CourseTable.Cols.INSTRUCTOR, mCourse.getInstructor().toString());
        mValues.put(CourseDbSchema.CourseTable.Cols.DESCRIPTION, mCourse.getDescription().toString());
        return mValues;
    }

    public void updateCourse(Course mCourse) {
        String mCourseNum = mCourse.getCourseNum().toString();
        ContentValues mValues = getContentValues(mCourse);
        mDatabase.update(CourseDbSchema.CourseTable.NAME, mValues, CourseDbSchema.CourseTable.Cols.COURSE_NUM + "=?", new String[]{mCourseNum});
    }

    private CourseCursorWrapper queryCourses(String where, String[] args) {
        Cursor mCursor = mDatabase.query(
                CourseDbSchema.CourseTable.NAME, // table name
                null,                          // which columns; null for all
                where,                         // where clause, e.g. id=?
                args,                          // where arguments
                null,                          // group by
                null,                          // having
                null                           // order by
        );

        return new CourseCursorWrapper(mCursor);
    }

    public List<Course> getCourses() {
        CourseCursorWrapper mWrapper = queryCourses(null, null);

        try {
            mWrapper.moveToFirst();
            while(mWrapper.isAfterLast() == false) {
                Course mCourse = mWrapper.getCourse();
                sListSchedule.add(mCourse);
                mWrapper.moveToNext();
            }
        } finally {
            mWrapper.close();
        }
        return sListSchedule;
    }
}
