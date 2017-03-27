package assignment06.csc214.homework6_listrecyclerviews;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import assignment06.csc214.homework6_listrecyclerviews.model.Course;
import assignment06.csc214.homework6_listrecyclerviews.model.Schedule;


public class CourseFragment extends ListFragment {

    private static final String COURSE_NUM = "COURSE_NUM";

    private List<Course> mCourses;

    public CourseFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCourses = Schedule.get(getActivity()).getSchedule();
        CourseArrayAdapter<Course> mAdapter = new CourseArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, mCourses);
        setListAdapter(mAdapter);

//        for (int i = 0; i < 20; i++ ) {
//            Log.d("DEBUGTAG", "Course: " + mCourses.get(i));
//        }

    }

    public static CourseFragment newInstance(Course mCourse) {
        CourseFragment mFragment = new CourseFragment();
        Bundle args = new Bundle();
        args.putInt(COURSE_NUM, mCourse.getCourseNum());
        mFragment.setArguments(args);
        return mFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_course_list, container, false);
        return mView;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        AppCompatActivity mContext = (AppCompatActivity) v.getContext();
        android.support.v4.app.FragmentManager mFragManager = mContext.getSupportFragmentManager();
        //FragmentManager mFragManager = getFragmentManager();
        DescriptionDialogFragment mDialog = DescriptionDialogFragment.newInstance(mCourses.get(position));
        mDialog.show(mFragManager, "Course Dialog");
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        super.onCreateView(inflater, container, savedInstanceState);
//        View mView = inflater.inflate(R.layout.fragment_course, container, false);
//
//
//        return mView;
//    }


}
