package assignment07.csc214.homework7_sqlite;


import android.content.Intent;
import android.graphics.Movie;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import assignment07.csc214.homework7_sqlite.model.Course;
import assignment07.csc214.homework7_sqlite.model.Schedule;


/**
 * A simple {@link Fragment} subclass.
 */
public class CourseListFragment extends Fragment {

    private static  final String TAG = "DEBUG_TAG";

    private static final String COURSE_NUM = "COURSE_NUM";

    private Schedule mSchedule;
    private RecyclerView mRecyclerView;
    private TextView mCourseTextView;
    private CourseRecyclerAdapter mAdapter;


    public CourseListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("INFOTAG", "RecylcerView");
        View mView = inflater.inflate(R.layout.fragment_course, container, false);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.recycler_view_courses);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CourseRecyclerAdapter mAdapter = new CourseRecyclerAdapter(Schedule.get(getActivity()).getSchedule());
        mRecyclerView.setAdapter(mAdapter);
        mSchedule = Schedule.get(getContext());
        updateUI();

        return  mView;
    }

    public static CourseListFragment newInstance(Course mCourse) {
        CourseListFragment mFragment = new CourseListFragment();
        Bundle args = new Bundle();
        args.putInt(COURSE_NUM, mCourse.getCourseNum());
        mFragment.setArguments(args);
        return mFragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    public void updateUI() {
        List<Course> mCourses = mSchedule.getSchedule();
        if(mAdapter == null) {
            mAdapter = new CourseRecyclerAdapter(mCourses);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setCourses(mCourses);
        }
    }

//    private class CourseAdapter extends RecyclerView.Adapter<CourseViewHolder> {
//        private List<Course> mCourses;
//
//        public CourseAdapter(List<Course> mCourseList) {
//            mCourses = mCourseList;
//        }
//
//        @Override
//        public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            Log.d(TAG, "onCreateViewHolder() CourseListFragment called");
//            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//            View itemView = inflater.inflate(R.layout.view_course, parent, false);
//            return new CourseViewHolder(itemView);
//        }
//
//        @Override
//        public void onBindViewHolder(CourseViewHolder holder, int position) {
//
//        }
//
//        @Override
//        public void onBindViewHolder(CourseViewHolder holder, int position) {
//            Log.d(TAG, "onBindViewHolder(holder," + position +") called");
//            Course mCourse = mCourses.get(position);
//            holder.bindCourse(mCourse);
//        }
//
//        @Override
//        public int getItemCount() {
//            Log.d(TAG, "getItemCount() returning " + mCourses.size());
//            return mCourses.size();
//        }
//
//        public void setCourses(List<Course> mCourseList) {
//            mCourses = mCourseList;
//            notifyDataSetChanged();
//        }
//    }



}
