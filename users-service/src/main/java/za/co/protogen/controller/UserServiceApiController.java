package za.co.protogen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.protogen.core.UserService;
import za.co.protogen.core.impl.UserServiceImpl;
import za.co.protogen.domain.User;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserServiceApiController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserServiceApiController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping
    public  void addCar(@RequestBody User user) {
        userServiceImpl.addUser(user);
    }

    @GetMapping
    public List<User> getAllReservation() {
        return userServiceImpl.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userServiceImpl.getUserById(id);
    }

    @PutMapping
    public void updatedUser(@RequestBody Long id, User user) {
        userServiceImpl.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void removeUser(Long id) {
        userServiceImpl.removeUser(id);
    }
}
