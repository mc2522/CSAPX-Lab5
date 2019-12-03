/**
 * Represents a user.
 *
 * @author Mike Cao
 * @date 10/22/18
 * @assignment Lab 5
 */

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.Collection;
import java.util.Collections;

public class User implements Comparable<User> {

    private TreeSet<Course> courses;
    private User.UserType type;
    private String username;

    /**
     * enum UserType of STUDENT or PROFESSOR
     */
    public enum UserType {
        PROFESSOR,
        STUDENT
    }

    /**
     * Creates a User.
     * @param username username
     * @param type type of user
     * @param comp comparator
     */
    public User(String username, UserType type, Comparator<Course> comp) {
        this.courses = new TreeSet<Course>(comp);
        this.type = type;
        this.username = username;
    }

    /**
     * Returns the username.
     * @return username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * returns STUDENT or PROFESSOR.
     * @return type
     */
    public User.UserType getType() {
        return this.type;
    }

    /**
     * Adds a course to courses.
     * @param course
     * @return true if the course has been added else false
     */
    public boolean addCourse​(Course course) {
        return courses.add(course);
    }

    /**
     * Removes a course from courses.
     * @param course
     * @return true if the course has been deleted else false
     */
    public boolean removeCourse​(Course course) {
        return courses.remove(course);
    }

    /**
     * returns an ArrayList of Courses.
     * @return ArrayList of Course
     */
    public Collection<Course> getCourses() {
        ArrayList<Course> listOfCourses = new ArrayList<>();
        for (Course course: courses) {
            listOfCourses.add(course);
        }
        return listOfCourses;
    }

    /**
     * Checks if the username is equal to other's username.
     * @param other
     * @return true if equal else false
     */
    public boolean equals​(User other) {
        return this.username.equals(other.username);
    }

    /**
     * Returns the hashcode of the username.
     * @return hashcode
     */
    public int hashCode() {
        return username.hashCode();
    }

    /**
     * Return a string representation of the course in the format:
     * User{username=username, type=type, courses=names}
     * @return the formatted string
     */
    @Override
    public String toString() {
        ArrayList <String> names = new ArrayList<>();
        for(Course c: courses) {
            names.add(c.getName());
        }
        Collections.sort(names);

        return "User{" +
                "username='" + username + "\'" +
                ", type=" + type  +
                ", courses=" + names +
                '}';
    }

    /**
     * Compares the username's alphabetical order to other's username.
     * @param other
     * @return 1 if greater, 0 if same, else -1
     */
    @Override
    public int compareTo(User other) {
        if (this.username.compareTo(other.username) > 0) {
            return 1;
        } else if (this.username.compareTo(other.username) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

}
