package assignment07.csc214.homework7_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import assignment07.csc214.homework7_sqlite.model.Course;

/**
 * Created by Dan on 4/4/17.
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

    public void setCourses(List<Course> mPCourses) {
        mCourses = mPCourses;
        notifyDataSetChanged();
    }
}
