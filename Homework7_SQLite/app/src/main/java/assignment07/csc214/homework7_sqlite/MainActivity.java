package assignment07.csc214.homework7_sqlite;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private CourseListFragment mCourseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager mFragManager = getSupportFragmentManager();
        Fragment mFragment = mFragManager.findFragmentById(R.id.recycle_activity_frame_layout);
        if (mFragment == null) {
            mFragment = new CourseListFragment();
            mFragManager.beginTransaction().add(R.id.recycle_activity_frame_layout, mFragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu mMenu) {
        getMenuInflater().inflate(R.menu.menu_main, mMenu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mItem) {
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
        if(resultCode == Activity.RESULT_OK) {
            mCourseList.updateUI();
        }
    }
}
