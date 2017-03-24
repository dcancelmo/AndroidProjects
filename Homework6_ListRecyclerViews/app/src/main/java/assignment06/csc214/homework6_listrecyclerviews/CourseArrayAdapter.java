package assignment06.csc214.homework6_listrecyclerviews;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import assignment06.csc214.homework6_listrecyclerviews.model.Course;

/**
 * Created by Dan on 3/23/17.
 */

public class CourseArrayAdapter<T extends Course> extends ArrayAdapter<T> {

    public CourseArrayAdapter(Context context, int resource, List<T> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("DEBUG", "getView" + position);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View mLayout;
        if (convertView == null) {
            mLayout = inflater.inflate(R.layout.view_course, parent, false);
        } else {
            mLayout = convertView;
        }
        T mComic = getItem(position);
        TextView mCourseNum = (TextView) mLayout.findViewById(R.id.course_num);
        mCourseNum.setText(mComic.getCourseNum());
        TextView mCourseName = (TextView) mLayout.findViewById(R.id.course_name);
        mCourseName.setText(mComic.getCourseName());
        TextView mInstructor = (TextView) mLayout.findViewById(R.id.instructor);
        mInstructor.setText(mComic.getInstructor());

        return mLayout;
    }
}

