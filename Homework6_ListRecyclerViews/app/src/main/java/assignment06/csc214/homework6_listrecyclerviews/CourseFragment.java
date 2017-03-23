package assignment06.csc214.homework6_listrecyclerviews;

import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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

        ArrayAdapter<Course> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mCourses);
        setListAdapter(adapter);

    }


}
