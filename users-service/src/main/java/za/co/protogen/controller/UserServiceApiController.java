package za.co.protogen.controller;

import com.example.userservice.api.UsersApi;
import com.example.userservice.models.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.protogen.adapter.UserMapper;
import za.co.protogen.core.impl.UserServiceImpl;
import za.co.protogen.domain.User;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserServiceApiController implements UsersApi {

//    private final UserServiceImpl userServiceImpl;
    private final UserServiceImpl userServiceImpl;
    private  final UserMapper userMapper;

    @Autowired
    public UserServiceApiController(UserServiceImpl userServiceImpl, UserMapper userMapper) {
        this.userServiceImpl = userServiceImpl;
        this.userMapper = userMapper;
    }

    @Override
    public ResponseEntity<Void> addUser(UserDTO userDTO) {
        User user = userMapper.dtoToUser(userDTO);
        userServiceImpl.addUser(user);
        return null;
    }

    @Override
    public ResponseEntity<List<UserDTO>> getAllUser() {
        return null;
    }

    @Override
    public ResponseEntity<UserDTO> getUserById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<Void> removeUser(String id) {
        return null;
    }

    @Override
    public ResponseEntity<UserDTO> updateUser(String id) {
        return null;
    }

//    @PostMapping
//    public void addUser(@RequestBody UserDTO userDTO) {
//        userServiceImpl.addUser(userMapper.userDTOToUser(userDTO));
//    }
//
//    @GetMapping
//    public List<User> getAllUser() {
//        return userServiceImpl.getAllUsers();
//    }
//
//    @GetMapping("/{id}")
//    public User getUserById(@PathVariable Long id) {
//        return userServiceImpl.getUserById(id);
//    }
//
//    @PutMapping
//    public void updatedUser(@RequestBody Long id, User user) {
//        userServiceImpl.updateUser(id, user);
//    }
//
//    @DeleteMapping("/{id}")
//    public void removeUser(Long id) {
//        userServiceImpl.removeUser(id);
//    }
}
