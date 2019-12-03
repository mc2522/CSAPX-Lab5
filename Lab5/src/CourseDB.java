/**
 * Represents a course database.
 *
 * @author Mike Cao
 * @date 10/22/18
 * @assignment Lab 5
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collection;

public class CourseDB implements DB<Integer,Course> {

    private HashMap<Integer,Course> courses = new HashMap<Integer, Course>();

    /**
     * Adds course to courses
     * @param course
     * @return old Course
     */
    @Override
    public Course addValue​(Course course) {
        return courses.put(course.hashCode(), course);
    }

    /**
     * Returns the Course with the corresponding id
     * @param id
     * @return Course of key id
     */
    @Override
    public Course getValue​(Integer id) {
        return courses.get(id);
    }

    /**
     * Returns true if the id is a key, otherwise false.
     * @param id
     * @return true or false
     */
    @Override
    public boolean hasKey​(Integer id) {
        return courses.containsKey(id);
    }

    /**
     * Gets all the values and returns them in the form of an ArrayList.
     * @return ArrayList of Courses
     */
    @Override
    public Collection<Course> getAllValues() {
        ArrayList <Course> listOfCourses = new ArrayList<>();

        for(Course course: courses.values()) {
            listOfCourses.add(course);
        }
        return listOfCourses;
    }

}

