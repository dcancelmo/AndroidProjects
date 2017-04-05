package assignment07.csc214.homework7_sqlite;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import assignment07.csc214.homework7_sqlite.model.Course;
import assignment07.csc214.homework7_sqlite.model.Schedule;


/**
 * A simple {@link Fragment} subclass.
 */
public class CourseFragment extends Fragment {

    private static  final String TAG = "DEBUG_TAG";


    private static final String COURSE_NUM = "COURSE_NUM";

    private RecyclerView mRecyclerView;
    private TextView mCourseTextView;
    private Course mCourse;
    EditText mNumEdit;
    EditText mNameEdit;
    EditText mInstructorEdit;
    EditText mDescriptionEdit;



    public CourseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView CourseFragment called");
        Log.i(TAG, "RecyclerView");
        View mView = inflater.inflate(R.layout.fragment_course, container, false);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.course_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CourseRecyclerAdapter mAdapter = new CourseRecyclerAdapter(Schedule.get(getActivity()).getSchedule());
        mRecyclerView.setAdapter(mAdapter);

        mNumEdit = (EditText) mView.findViewById(R.id.course_num_enter);
        mNameEdit = (EditText) mView.findViewById(R.id.course_name_enter);
        mInstructorEdit = (EditText) mView.findViewById(R.id.instructor_enter);
        mDescriptionEdit = (EditText) mView.findViewById(R.id.description_enter);

        return  mView;
    }

    public static CourseFragment newInstance(Course mCourse) {
        Log.d(TAG, "newInstance CourseFragment called");
        CourseFragment mFragment = new CourseFragment();
        Bundle args = new Bundle();
        args.putInt(COURSE_NUM, mCourse.getCourseNum());
        mFragment.setArguments(args);
        return mFragment;
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause CourseFragment called");
        mCourse.setCourseNum(Integer.getInteger(mNumEdit.getText().toString()));
        mCourse.setCourseName(mNameEdit.getText().toString());
        mCourse.setInstructor(mInstructorEdit.getText().toString());
        mCourse.setDescription(mDescriptionEdit.getText().toString());
        Schedule.get(getContext()).updateCourse(mCourse);
    }


}
