/**
 * Represents a user database.
 *
 * @author Mike Cao
 * @date 10/22/18
 * @assignment UserBD.java Lab 5
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collection;

public class UserDB implements DB<String, User> {

    private HashMap<String, User> users = new HashMap<>();

    /**
     * adds the user to users
     * @param user: user
     * @return previous User
     */
    public User addValue​(User user) {
        return users.put(user.getUsername(), user);
    }

    /**
     * Gets the user with the username of username.
     * @param username: name of user
     * @return User with username
     */
    public User getValue​(String username) {
        return users.get(username);
    }

    /**
     * Checks if the username is a key of users
     * @param username
     * @return true if key exists else false
     */
    public boolean hasKey​(String username) {
        return users.containsKey(username);
    }

    /**
     * Gets all the values of users
     * @return Collection of User
     */
    public Collection<User> getAllValues() {
        ArrayList <User> values = new ArrayList<>();
        for(User o: users.values()) {
            values.add(o);
        }
        return values;
    }

}
