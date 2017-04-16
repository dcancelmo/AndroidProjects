package assignment07.csc214.homework7_sqlite;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.widget.CursorAdapter;

import assignment07.csc214.homework7_sqlite.model.Course;

/**
 * Created by Dan on 4/4/17.
 */

public class CourseCursorWrapper extends CursorWrapper {

    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public CourseCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Course getCourse() {
        String mCourseNum = getString(getColumnIndex(CourseDbSchema.CourseTable.Cols.COURSE_NUM));
        String mCourseName = getString(getColumnIndex(CourseDbSchema.CourseTable.Cols.COURSE_NAME));
        String mInstructor = getString(getColumnIndex(CourseDbSchema.CourseTable.Cols.INSTRUCTOR));
        String mDescription = getString(getColumnIndex(CourseDbSchema.CourseTable.Cols.DESCRIPTION));
        Course mCourse = new Course(mCourseName, Integer.valueOf(mCourseNum), mInstructor, mDescription);
//        mCourse.setCourseName(mCourseName);
//        mCourse.setInstructor(mInstructor);
//        mCourse.setDescription(mDescription);
        return mCourse;
    }
}
