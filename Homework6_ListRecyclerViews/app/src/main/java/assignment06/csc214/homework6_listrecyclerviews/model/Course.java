package assignment06.csc214.homework6_listrecyclerviews.model;

import assignment06.csc214.homework6_listrecyclerviews.R;

/**
 * Created by Dan on 3/22/17.
 */

public class Course {
    private static String sCourseName;
    private static int sCourseNum;
    private static String sInstructor;
    private static String sDescription;

    public Course(String mCourseName, int mCourseNum, String mInstructor, String mDescription) {
        sCourseName = mCourseName;
        sCourseNum = mCourseNum;
        sInstructor = mInstructor;
        sDescription = mDescription;
    }


    public static String getCourseName() {
        return sCourseName;
    }

    public static void setCourseName(String sCourseName) {
        Course.sCourseName = sCourseName;
    }

    public static Integer getCourseNum() {
        return sCourseNum;
    }

    public static void setCourseNum(int sCourseNum) {
        Course.sCourseNum = sCourseNum;
    }

    public static String getInstructor() {
        return sInstructor;
    }

    public static void setInstructor(String sInstructor) {
        Course.sInstructor = sInstructor;
    }

    public static String getDescription() {
        return sDescription;
    }

    public static void setDescription(String sDescription) {
        Course.sDescription = sDescription;
    }

    @Override
    public String toString() {
        return getCourseNum() + " " + getCourseName() + "\nInstructor: " + getInstructor();
    }
}
