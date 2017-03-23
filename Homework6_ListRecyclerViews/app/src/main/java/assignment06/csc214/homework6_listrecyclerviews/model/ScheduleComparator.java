package assignment06.csc214.homework6_listrecyclerviews.model;

import java.util.Comparator;

/**
 * Created by Dan on 3/23/17.
 */

public class ScheduleComparator implements Comparator<Course> {
    @Override
    public int compare(Course lhs, Course rhs) {
        int result = 0;
        if (lhs.getCourseNum() == rhs.getCourseNum()) {
            result = 0;
        } else if (lhs.getCourseNum() < rhs.getCourseNum()) {
            result = -1;
        } else if (lhs.getCourseNum() > rhs.getCourseNum()) {
            result = 1;
        }
        return result;
    }

}
