package assignment06.csc214.homework6_listrecyclerviews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import assignment06.csc214.homework6_listrecyclerviews.model.Course;

/**
 * Created by Dan on 3/24/17.
 */

public class CoursePagerAdapter extends FragmentStatePagerAdapter {
    private List<Course> mCourseList;

    public CoursePagerAdapter(FragmentManager mFragManager, List<Course> mCourses) {
        super(mFragManager);
        mCourseList = mCourses;
    }

    @Override
    public Fragment getItem(int mPosition) {
        Course mCourse = mCourseList.get(mPosition);
        if (mPosition == 0) {
            return CourseFragment.newInstance(mCourse);
        } else {
            return RecyclerCourseFragment.newInstance(mCourse);
        }
    }

    @Override
    public int getCount() {
        return mCourseList.size();
    }
}
