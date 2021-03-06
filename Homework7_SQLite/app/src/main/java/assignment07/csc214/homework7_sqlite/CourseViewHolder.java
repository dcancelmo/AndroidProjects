package assignment07.csc214.homework7_sqlite;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import assignment07.csc214.homework7_sqlite.model.Course;

/**
 * Created by Dan on 4/4/17.
 */

public class CourseViewHolder extends RecyclerView.ViewHolder {

    private TextView mCourseView;
    private Course mCourse;

    public CourseViewHolder(View mView) {
        super(mView);
        mCourseView = (TextView) mView.findViewById(R.id.course_textview);


    }

    public void bindCourse(Course mPCourse) {
        mCourse = mPCourse;
        mCourseView.setText(mPCourse.toString());
    }
}

