/**
 * Represents a professor.
 *
 * @author Mike Cao
 * @date 10/22/18
 * @assignment Lab 5
 */

import java.util.Comparator;

public class Professor extends User {
    /**
     * Creates a new Professor of username=username, type=PROFESSOR, and compare
     * @param username
     */
    public Professor(String username) {
        super(username, UserType.PROFESSOR, new compare());
    }

    /**
     * Compares the levels, or the name if the levels are the same.
     */
    public static class compare implements Comparator<Course> {
        @Override
        public int compare(Course o1, Course o2) {
            if(o1.getLevel() == o2.getLevel()) {
                return o1.getName().compareTo(o2.getName());
            }
            return o1.getLevel() - o2.getLevel();
        }

    }

}
