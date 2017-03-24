package assignment06.csc214.homework6_listrecyclerviews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import assignment06.csc214.homework6_listrecyclerviews.model.Course;

/**
 * Created by Dan on 3/24/17.
 */

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseViewHolder> {

    private List<Course> mCourses;
    public CourseRecyclerAdapter(List<Course> mCourseList) {
        mCourses = mCourseList;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        View mView = mInflater.inflate(R.layout.view_course, parent, false);
        CourseViewHolder mHolder = new CourseViewHolder(mView);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {
        holder.bindCourse(mCourses.get(position));
    }

    @Override
    public int getItemCount() {
        return mCourses.size();
    }
}
