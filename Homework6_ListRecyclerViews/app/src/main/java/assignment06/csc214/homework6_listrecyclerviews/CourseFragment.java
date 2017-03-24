package assignment06.csc214.homework6_listrecyclerviews;

import android.app.FragmentManager;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Collections;
import java.util.List;

import assignment06.csc214.homework6_listrecyclerviews.model.Course;
import assignment06.csc214.homework6_listrecyclerviews.model.Schedule;


public class CourseFragment extends ListFragment {

    private List<Course> mCourses;

    public CourseFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCourses = Schedule.get(getActivity()).getSchedule();
        ArrayAdapter<Course> mAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, mCourses);
        setListAdapter(mAdapter);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        FragmentManager mFragManager = getFragmentManager();
        DescriptionDialogFragment mDialog = DescriptionDialogFragment.newInstance(mCourses.get(position));
        mDialog.show(mFragManager, "Course Dialog");
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        super.onCreateView(inflater, container, savedInstanceState);
//        View mView = inflater.inflate(R.layout.fragment_course, container, false);
//
//        Bundle args = getArguments();
//        Course mCourseSelected = args.get
//        mCourseSelected.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentManager mManager = getFragmentManager();
//                DescriptionDialogFragment mDialog = DescriptionDialogFragment.newInstance(mCourse);
//                mDialog.setTargetFragment(CourseFragment.this, 0);
//                mDialog.show(mManager, 0);
//            }
//        });
//
//        return mView;
//    }


}
