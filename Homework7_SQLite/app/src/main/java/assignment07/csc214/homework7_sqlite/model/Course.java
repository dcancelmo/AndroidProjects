package assignment07.csc214.homework7_sqlite.model;

import assignment07.csc214.homework7_sqlite.R;

/**
 * Created by Dan on 3/22/17.
 */

public class Course {
    private String sCourseName;
    private int sCourseNum;
    private String sInstructor;
    private String sDescription;

    public Course(String mCourseName, int mCourseNum, String mInstructor, String mDescription) {
        sCourseName = mCourseName;
        sCourseNum = mCourseNum;
        sInstructor = mInstructor;
        sDescription = mDescription;
    }
    public Course(int mCourseNum) {
        sCourseName = null;
        sCourseNum = mCourseNum;
        sInstructor = null;
        sDescription = null;
    }


    public String getCourseName() {
        return sCourseName;
    }

    public void setCourseName(String sCourseName) {
        sCourseName = sCourseName;
    }

    public Integer getCourseNum() {
        return sCourseNum;
    }

    public void setCourseNum(int sCourseNum) {
        sCourseNum = sCourseNum;
    }

    public String getInstructor() {
        return sInstructor;
    }

    public void setInstructor(String sInstructor) {
        sInstructor = sInstructor;
    }

    public String getDescription() {
        return sDescription;
    }

    public void setDescription(String sDescription) {
        sDescription = sDescription;
    }

    @Override
    public String toString() {
        return getCourseNum() + " " + getCourseName() + "\nInstructor: " + getInstructor();
    }
}
