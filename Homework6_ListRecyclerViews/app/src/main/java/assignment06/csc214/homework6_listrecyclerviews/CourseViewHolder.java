package assignment06.csc214.homework6_listrecyclerviews;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import assignment06.csc214.homework6_listrecyclerviews.model.Course;

/**
 * Created by Dan on 3/24/17.
 */

public class CourseViewHolder extends RecyclerView.ViewHolder {

    private TextView mCourseView;
    private Course mCourse;

    public CourseViewHolder(View mView) {
        super(mView);
        mCourseView = (TextView) mView.findViewById(R.id.course_textview);
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View mInnerView) {
                AppCompatActivity mContext = (AppCompatActivity) mInnerView.getContext();
                FragmentManager mManager = mContext.getSupportFragmentManager();
                DescriptionDialogFragment mDialog = DescriptionDialogFragment.newInstance(mCourse);
                mDialog.show(mManager, "Course Dialog");
            }
        });

    }

    public void bindCourse(Course mPCourse) {
        mCourse = mPCourse;
        mCourseView.setText(mPCourse.toString());
    }
}
