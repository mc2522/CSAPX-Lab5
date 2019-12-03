/**
 * Represents a backend.
 *
 * @author Mike Cao
 * @date 10/22/18
 * @assignment Lab 5
 */

import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class Backend {

    private CourseDB courseDB = new CourseDB();
    private UserDB userDB = new UserDB();

    public Backend(String courseFile, String professorFile, String studentFile) throws FileNotFoundException {
        /***
         * Initializes courseDB and userDB.
         */
        initializeCourseDB​(courseFile);
        initializeUserDB​(professorFile, studentFile);
    }

    /**
     * Sets the various values in courseFile to courseId, courseName, and courseLevel and adds a new Course(courseId, courseName, courseLevel) to courseDB.
     * @param courseFile
     * @throws FileNotFoundException
     */
    private void initializeCourseDB​(String courseFile) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File(courseFile))) {
            while (in.hasNext()) {
                String[] fields = in.nextLine().split(",");
                // fields[0] is the course id, as a String
                int courseID = Integer.parseInt(fields[0]);
                // fields[1] is the course name, as a String
                String courseName = fields[1];
                // fields[2] is the course level, as a String
                int courseLevel = Integer.parseInt(fields[2]);
                courseDB.addValue​(new Course(courseID, courseName, courseLevel));
            }
        }
    }

    /**
     * Adds courses with either professor or student with course IDs.
     * @param professorFile
     * @param studentFile
     * @throws FileNotFoundException
     */
    private void initializeUserDB​(String professorFile, String studentFile) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File(professorFile))) {
            while (in.hasNext()) {
                String[] fields = in.nextLine().split(",");
                Professor professor = new Professor(fields[0]);

                addCourses​(professor, Arrays.copyOfRange(fields,1,fields.length));
            }
        }
        try (Scanner in = new Scanner(new File(studentFile))) {
            while (in.hasNext()) {
                String[] fields = in.nextLine().split(",");
                Student student = new Student(fields[0]);
                String [] courseIds = new String[fields.length - 1];

                addCourses​(student, Arrays.copyOfRange(fields,1,fields.length));
            }
        }
    }

    /**
     * Adds courses of the courseIds to the user of username in userDB.
     * @param user
     * @param courseIds
     */
    private void addCourses​(User user, String[] courseIds) {
        userDB.addValue​(user);

        for(int i = 0; i < courseIds.length; i++) {
            Course course = courseDB.getValue​(Integer.parseInt(courseIds[i]));
            String username = user.getUsername();
            if(user.getType().equals(User.UserType.PROFESSOR)) {
                course.addProfessor(username);
            } else {
                course.addStudent(username);
            }
            userDB.getValue​(username).addCourse​(course);
        }
    }

    /**
     * Checks if the course of with course id of id exists.
     * @param id
     * @return true if the course exists else false
     */
    public boolean courseExists​(int id) {
        return courseDB.hasKey​(id);
    }

    /**
     * Gets the course with courseID and assigns it to the user in userDB.
     * @param username
     * @param courseId
     * @return true if student has been enrolled else false
     */
    public boolean enrollStudent​(String username, int courseId) {
        courseDB.getValue​(courseId).addStudent(username);
        return userDB.getValue​(username).addCourse​(courseDB.getValue​(courseId));
    }

    /**
     * Returns an ArrayList of Courses.
     * @return ArrayList of Courses
     */
    public Collection<Course> getAllCourses() {
        ArrayList<Course> listOfCourses = new ArrayList<>();
        for (Course c: courseDB.getAllValues()) {
            listOfCourses.add(c);
        }
        return listOfCourses;
    }

    /**
     * Returns an ArrayList of Users.
     * @return ArrayList of Users
     */
    public Collection<User> getAllUsers() {
        ArrayList<User> listOfUsers = new ArrayList<>();
        for (User u: userDB.getAllValues()) {
            listOfUsers.add(u);
        }
        return listOfUsers;
    }

    /**
     * Checks if username is a student.
     * @param username
     * @return true if username is a student else false
     */
    public boolean isStudent​(String username) {
        if(userDB.getValue​(username)!= null)
            return true;
        return false;
    }

    /**
     * Gets the Course associated with the id.
     * @param id
     * @return Course
     */
    public Course getCourse​(int id) {
        return courseDB.getValue​(id);
    }

    /**
     * Unenrolls the student associated with the username from the course associated with the courseId.
     * @param username
     * @param courseId
     * @return true if the student has been unenrolled else false
     */
    public boolean unenrollStudent​(String username, int courseId) {
        return userDB.getValue​(username).removeCourse​(courseDB.getValue​(courseId));
    }

    /**
     * Returns an ArrayList of Courses associated with the user of username.
     * @param username
     * @return ArrayList of Courses
     */
    public Collection<Course> getCoursesUser​(String username) {
        ArrayList<Course> listOfCourses = new ArrayList<>();
        for(Course c: userDB.getValue​(username).getCourses()) {
            listOfCourses.add(c);
        }
        return listOfCourses;
    }

}
