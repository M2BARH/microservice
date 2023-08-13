package za.co.protogen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.protogen.core.UserService;
import za.co.protogen.domain.User;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserServiceApiController {

    private final UserService userService;

    @Autowired
    public UserServiceApiController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public  void addCar(@RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllReservation() {
        return userService.getAllUsers();
    }

    @GetMapping("/{vin}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping
    public void updatedUser(@RequestBody Long id, User user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void removeUser(Long id) {
        userService.removeUser(id);
    }
}
