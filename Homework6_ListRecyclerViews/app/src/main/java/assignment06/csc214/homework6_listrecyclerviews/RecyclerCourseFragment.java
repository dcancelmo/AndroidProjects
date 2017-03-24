package assignment06.csc214.homework6_listrecyclerviews;


import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import assignment06.csc214.homework6_listrecyclerviews.model.Course;
import assignment06.csc214.homework6_listrecyclerviews.model.Schedule;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerCourseFragment extends Fragment {

    private static final String COURSE_NUM = "COURSE_NUM";

    private RecyclerView mRecyclerView;
    private TextView mCourseTextView;


    public RecyclerCourseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("INFOTAG", "RecylcerView");
        View mView = inflater.inflate(R.layout.fragment_recycler_course, container, false);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.course_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CourseRecyclerAdapter mAdapter = new CourseRecyclerAdapter(Schedule.get(getActivity()).getSchedule());
        mRecyclerView.setAdapter(mAdapter);

//        mCourseTextView = (TextView) mView.findViewById(R.id.course_textview);
//        final Course mCourse = Schedule.get(getActivity()).getSchedule().get(mCourse.getCourseNum());
//        mCourseTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View mClickView) {
//                FragmentManager mFragManager = getFragmentManager();
//                DescriptionDialogFragment mDialog = DescriptionDialogFragment.newInstance(mCourses.get(position));
//                mDialog.show(mFragManager, "Course Dialog");
//            }
//
//        });

        // Inflate the layout for this fragment
        return  mView;
    }

    public static RecyclerCourseFragment newInstance(Course mCourse) {
        RecyclerCourseFragment mFragment = new RecyclerCourseFragment();
        Bundle args = new Bundle();
        args.putInt(COURSE_NUM, mCourse.getCourseNum());
        mFragment.setArguments(args);
        return mFragment;
    }

}
