/**
 * Represents a student.
 *
 * @author Mike Cao
 * @date 10/22/18
 * @assignment Lab 5
 */

public class Student extends User {
    /**
     * Creates a User of username, UserType STUDENT, and courseComparator
     * @param username
     */
    public Student(String username) {
        super(username, UserType.STUDENT, new CourseComparator());
    }

}
