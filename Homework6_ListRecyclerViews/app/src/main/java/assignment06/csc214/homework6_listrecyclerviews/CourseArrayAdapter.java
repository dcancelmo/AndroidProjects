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

//    public CourseArrayAdapter(Context context, int resource, List<T> objects) {
//        super(context, 0, objects);
//    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        Log.d("DEBUG", "getView " + position);
//        LayoutInflater inflater = LayoutInflater.from(getContext());
//        View mLayout;
//        if (convertView == null) {
//            mLayout = inflater.inflate(R.layout.view_course, parent, false);
//        } else {
//            mLayout = convertView;
//        }
//        T mCourse = getItem(position);
//        TextView mCourseTextView = (TextView) mLayout.findViewById(R.id.course_textview);
//        mCourseTextView.setText(mCourse.toString());
//
//        return mLayout;
//    }

    private List<T> mCourses;
    public CourseArrayAdapter(Context context, int resource, List<T> objects) {
        super(context, resource, objects);
        mCourses = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("DEBUG", "getView " + position);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View mLayout;
        if (convertView == null) {
            mLayout = inflater.inflate(R.layout.view_course, parent, false);
        } else {
            mLayout = convertView;
        }
        // T mCourse = getItem(position);
        TextView mCourseTextView = (TextView) mLayout.findViewById(R.id.course_textview);
        mCourseTextView.setText(mCourses.get(position).toString());

        return mLayout;
    }
}

