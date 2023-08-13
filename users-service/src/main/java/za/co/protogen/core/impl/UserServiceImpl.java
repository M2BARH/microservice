package za.co.protogen.core.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import za.co.protogen.core.UserService;
import za.co.protogen.domain.User;
import za.co.protogen.utility.Constants;

import java.util.List;
import java.util.stream.Collectors;

// class that implements UserService methods
@Service
public class UserServiceImpl implements UserService {

    private final List<UserService> userServices;
    private final RestTemplate restTemplate;

    public UserServiceImpl(List<UserService> userServices, RestTemplate restTemplate) {
        this.userServices = userServices;
        this.restTemplate = restTemplate;
    }

    // method to add user object
    @Override
    public void addUser(User user) {
        Constants.users.add(user); // add user to a users list
    }

    // method to remove user identified by unique identifier
    @Override
    public void removeUser(long id) {
        Constants.users.removeIf(user -> user.getId().equals(id)); // remove user found
    }

    // method to retrieve user identified by unique id
    @Override
    public User getUserById(long id) {
        return Constants.users.stream().filter(reservation -> reservation.getId().equals(id)).findFirst().orElse(null); // retrieve first reservation found
    }

    // method that return a list of all users
    @Override
    public List<User> getAllUsers() {
        return Constants.users;
    }

    // method to update user
    @Override
    public void updateUser(long id, User updatedUser) {
        User existingUser = getUserById(id); // return existing user by calling a getUser method
        if (existingUser != null) { // if user do exist from the list. the following attributes are updated
            existingUser.setId(updatedUser.getId());
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
        }
    }

    // method to search for a user through provided attributes
    @Override
    public List<User> searchUsers(long id, String firstName, String lastName) {
        return Constants.users.stream().filter(user -> user.getId() == id ||
                user.getFirstName().toLowerCase().equals(firstName) ||
                user.getLastName().toLowerCase().equals(lastName)).collect(Collectors.toList());
    }
}
