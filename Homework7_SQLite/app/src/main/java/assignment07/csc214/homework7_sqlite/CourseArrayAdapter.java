package assignment07.csc214.homework7_sqlite;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import assignment07.csc214.homework7_sqlite.model.Course;

/**
 * Created by Dan on 4/4/17.
 */

public class CourseArrayAdapter<T extends Course> extends ArrayAdapter<T> {

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
