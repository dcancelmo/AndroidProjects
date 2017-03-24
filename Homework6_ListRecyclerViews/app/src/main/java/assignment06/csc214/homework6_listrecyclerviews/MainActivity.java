package assignment06.csc214.homework6_listrecyclerviews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import assignment06.csc214.homework6_listrecyclerviews.model.Course;
import assignment06.csc214.homework6_listrecyclerviews.model.Schedule;


public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private List<Course> mCourseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCourseList = Schedule.get(this).getSchedule();
        mViewPager = (ViewPager) findViewById(R.id.main_activity_view_pager);
        mViewPager.setAdapter(new CoursePagerAdapter(getSupportFragmentManager(), mCourseList));

//        FragmentManager mFragManager = getSupportFragmentManager();
//        Fragment mFragment = mFragManager.findFragmentById(R.id.main_activity_framelayout);
////        if(mFragment == null) {
////            mFragment = new CourseFragment();
////            mFragManager.beginTransaction().add(R.id.main_activity_framelayout, mFragment).commit();
////        }
//        if (mFragment == null) {
//            mFragment = new RecyclerCourseFragment();
//            mFragManager.beginTransaction().add(R.id.main_activity_framelayout, mFragment).commit();
//        }
    }
}
