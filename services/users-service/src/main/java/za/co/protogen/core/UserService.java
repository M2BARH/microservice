package za.co.protogen.core;

import za.co.protogen.domain.User;

import java.util.List;

// user service interface
public interface UserService {

    // UserService methods to manipulate user object
    void addUser(User user); // add new user object to the users list
    void removeUser(long id); // remove the user object from the list
    User getUserById(long id); // retrieve user by unique identifier
    List<User> getAllUsers(); // return a list of all users in a user list
    void updateUser(long id, User updatedUser); // update identified user's attributes
    List<User> searchUsers(long id, String firstName, String lastName); // search and return list of all users identified by given attributes
}
