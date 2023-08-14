package za.co.protogen.core.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import za.co.protogen.core.UserService;
import za.co.protogen.domain.User;
import za.co.protogen.persistance.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

// class that implements UserService methods
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    // method to add user object
    @Override
    public void addUser(User user) {
        userRepository.save(user); // add user to a users list
    }

    // method to remove user identified by unique identifier
    @Override
    public void removeUser(long id) {
         // remove user if found
        boolean exists = userRepository.existsById(String.valueOf(id));
        if (!exists) {
            throw  new IllegalStateException("User with id " + id + " does not exist");
        }
        userRepository.deleteById(String.valueOf(id));
    }

    // method to retrieve user identified by unique id
    @Override
    public User getUserById(long id) {
        return userRepository.findById(String.valueOf(id)).orElse(null); // retrieve first reservation found
    }

    // method that return a list of all users
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
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
        List<User> allUsers = userRepository.findAll();
        return allUsers.stream().filter(user -> user.getId() == id ||
                user.getFirstName().toLowerCase().equals(firstName) ||
                user.getLastName().toLowerCase().equals(lastName)).collect(Collectors.toList());
    }
}
