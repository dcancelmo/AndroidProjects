package assignment06.csc214.homework6_listrecyclerviews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RecylcleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recylcle);

        FragmentManager mFragManager = getSupportFragmentManager();
        Fragment mFragment = mFragManager.findFragmentById(R.id.recycle_activity_frame_layout);
        if (mFragment == null) {
            mFragment = new RecyclerCourseFragment();
            mFragManager.beginTransaction().add(R.id.recycle_activity_frame_layout, mFragment).commit();
        }
    }
}
