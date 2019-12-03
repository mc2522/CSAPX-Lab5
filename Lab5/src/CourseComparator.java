/**
 * Represents a course comparator.
 *
 * @author Mike Cao
 * @date 10/22/18
 * @assignment Lab 5
 */

import java.util.Comparator;

/**
 * A class that overrides the natural order comparison of courses to order
 * them alphabetically by course name.
 *
 * @author Mike Cao
 */
public class CourseComparator implements Comparator<Course> {
    /**
     * Compares two courses' names.
     * @param o1
     * @param o2
     * @return int based on comparison
     */
    @Override
    public int compare(Course o1, Course o2) {
        return o1.getName().compareTo(o2.getName());

    }
}
