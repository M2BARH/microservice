package za.co.protogen.core.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import za.co.protogen.Specifications.UserSpecifications;
import za.co.protogen.core.UserService;
import za.co.protogen.domain.User;
import za.co.protogen.exception.UserNotFoundException;
import za.co.protogen.persistance.repository.UserRepository;
import za.co.protogen.searchCriteria.UserSearchCriteria;

import java.util.List;
import java.util.stream.Collectors;

// class that implements UserService methods
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
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
        boolean exists = userRepository.existsById(id);
        if (!exists) {
            throw  new IllegalStateException("User with id " + id + " does not exist");
        }
        userRepository.deleteById(id);
    }

    // method to retrieve user identified by unique id
    @Override
    public User getUserById(long id) {
        return userRepository.findById(id) // retrieve first reservation found
                .orElseThrow(() -> new UserNotFoundException(id));
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
    public List<User> searchUsers(UserSearchCriteria criteria) {
        Specification<User> spec = UserSpecifications.buildSpecification(criteria);
        return userRepository.findAll(spec);
    }
}
