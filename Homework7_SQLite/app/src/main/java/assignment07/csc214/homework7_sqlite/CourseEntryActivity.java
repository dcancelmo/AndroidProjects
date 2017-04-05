package assignment07.csc214.homework7_sqlite;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.UUID;

public class CourseEntryActivity extends AppCompatActivity {

    public static final String ID_TAG = "assignment07.csc214.homework7_sqlite.id";

    private static final String KEY_COURSE_NUM = "assignment07.csc214.homeowork7_sglite.num";
    private static final String KEY_COURSE_NAME = "assignment07.csc214.homeowork7_sglite.name";
    private static final String KEY_INSTRUCTOR = "assignment07.csc214.homeowork7_sglite.instructor";
    private static final String KEY_DESCRIPTION = "assignment07.csc214.homeowork7_sglite.description";

    private static int sCourseNum;
    private static String sCourseName;
    private static String sInstructor;
    private static String sDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_entry);
        if (savedInstanceState != null) {
            sCourseNum = savedInstanceState.getInt(KEY_COURSE_NUM);
            sCourseName = savedInstanceState.getString(KEY_COURSE_NAME);
            sInstructor = savedInstanceState.getString(KEY_INSTRUCTOR);
            sDescription = savedInstanceState.getString(KEY_DESCRIPTION);
            setTextValues();
        }
    }

    public void setTextValues() {
        EditText mNumEdit = (EditText) findViewById(R.id.course_num_enter);
        EditText mNameEdit = (EditText) findViewById(R.id.course_name_enter);
        EditText mInstructorEdit = (EditText) findViewById(R.id.instructor_enter);
        EditText mDescriptionEdit = (EditText) findViewById(R.id.description_enter);
        mNumEdit.setText(Integer.toString(sCourseNum));
        mNameEdit.setText(sCourseName);
        mInstructorEdit.setText(sInstructor);
        mDescriptionEdit.setText(sDescription);
    }

    public static Intent newIntent(Context mContext, UUID mId) {
        Intent intent = new Intent(mContext, CourseEntryActivity.class);
        intent.putExtra(ID_TAG, mId);
        return intent;
    }

    public void cancelNewCourse(View view) {
        Intent intent = new Intent(CourseEntryActivity.this, MainActivity.class);
        setResult(RESULT_CANCELED, intent);
        finish();
    }

    public void acceptNewCourse(View view) {

        Intent intent = new Intent(CourseEntryActivity.this, MainActivity.class);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        state.putInt(KEY_COURSE_NUM, sCourseNum);
        state.putString(KEY_COURSE_NAME, sCourseName);
        state.putString(KEY_INSTRUCTOR, sInstructor);
        state.putString(KEY_DESCRIPTION, sDescription);
    }
}
