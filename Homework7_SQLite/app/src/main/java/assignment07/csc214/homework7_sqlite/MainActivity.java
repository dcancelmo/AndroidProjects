package assignment07.csc214.homework7_sqlite;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import assignment07.csc214.homework7_sqlite.model.Course;
import assignment07.csc214.homework7_sqlite.model.Schedule;

public class MainActivity extends AppCompatActivity {

    private static  final String TAG = "DEBUG_TAG";

    private static final String KEY_COURSE_NUM = "assignment07.csc214.homeowork7_sglite.num";
    private static final String KEY_COURSE_NAME = "assignment07.csc214.homeowork7_sglite.name";
    private static final String KEY_INSTRUCTOR = "assignment07.csc214.homeowork7_sglite.instructor";
    private static final String KEY_DESCRIPTION = "assignment07.csc214.homeowork7_sglite.description";

    private CourseListFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate MainActivity called");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager mFragManager = getSupportFragmentManager();
        //mFragment = mFragManager.findFragmentById(R.id.recycle_activity_frame_layout);
        mFragment = new CourseListFragment();
        mFragManager.beginTransaction().add(R.id.recycle_activity_frame_layout, mFragment).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFragment.updateUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu mMenu) {
        Log.d(TAG, "onCreateOptionsMenu MainActivity called");
        getMenuInflater().inflate(R.menu.menu_main, mMenu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mItem) {
        Log.d(TAG, "onOptionsItemSelected MainActivity called");
        boolean handled;
        switch(mItem.getItemId()) {
            case R.id.menu_item_course_entry:
                Intent mIntent = CourseEntryActivity.newIntent(this, null);
                startActivityForResult(mIntent, 0);
                handled = true;
                break;
            default:
                handled = super.onOptionsItemSelected(mItem);
                break;
        }
        return handled;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult MainActivity called");
        if(resultCode == Activity.RESULT_OK) {
            Schedule mSchedule = Schedule.get(getApplicationContext());
            mSchedule.addCourse(data.getStringExtra(KEY_COURSE_NAME), Integer.parseInt(data.getStringExtra(KEY_COURSE_NUM)), data.getStringExtra(KEY_INSTRUCTOR), data.getStringExtra(KEY_DESCRIPTION));
            mFragment.updateUI();
        }
    }


}
