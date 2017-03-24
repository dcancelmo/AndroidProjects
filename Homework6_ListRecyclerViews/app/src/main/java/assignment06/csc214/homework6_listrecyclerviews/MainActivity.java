package assignment06.csc214.homework6_listrecyclerviews;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import static android.R.attr.fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager mFragManager = getFragmentManager();
        Fragment mFragment = mFragManager.findFragmentById(R.id.main_activity_framelayout);
        if(mFragment == null) {
            mFragment = new CourseFragment();
            mFragManager.beginTransaction().add(R.id.main_activity_framelayout, mFragment).commit();
        }
//        if (mFragment == null) {
//            mFragment = new RecyclerCourseFragment();
//            mFragManager.beginTransaction().add(R.id.main_activity_framelayout, mFragment).commit();
//        }
    }
}
