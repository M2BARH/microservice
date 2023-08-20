package za.co.protogen.controller;

import com.example.userservice.api.UsersApi;
import com.example.userservice.models.UserDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import za.co.protogen.adapter.UserMapper;
import za.co.protogen.core.impl.UserServiceImpl;
import za.co.protogen.domain.User;

import java.util.List;

@RestController
@RefreshScope
@RequiredArgsConstructor
public class UserServiceApiController implements UsersApi {

    private final UserServiceImpl userServiceImpl;
    private  final UserMapper userMapper;
    private final Logger logger = LoggerFactory.getLogger(UserServiceApiController.class);

    @Override
    public ResponseEntity<Void> addUser(UserDTO userDTO) {
        logger.info("Adding a user to the database");
        User user = userMapper.dtoToUser(userDTO);
        userServiceImpl.addUser(user);
        return null;
    }

    @Override
    public ResponseEntity<List<UserDTO>> getAllUser() {
        logger.info("Fetching all users from the database");
        List<User> user = userServiceImpl.getAllUsers();
        List<UserDTO> userDTO = userMapper.userToDTO(user);
        return ResponseEntity.ok(userDTO);
    }

    @Override
    public ResponseEntity<UserDTO> getUserById(Long id) {
        logger.info("Fetching a car identified by: " + id + ",from the database");
        User user = userServiceImpl.getUserById(id);
        UserDTO userDTO = userMapper.userToDTO(user);
        return ResponseEntity.ok(userDTO);
    }

    @Override
    public ResponseEntity<Void> removeUser(Long id) {
        logger.info("Removing a user identified by: " + id + ", from the database");
        userServiceImpl.removeUser(id);
        return null;
    }

    @Override
    public ResponseEntity<Void> updateUser(Long id) {
        logger.info("Fetching adding a car identified by: " + id + ", and updating them");
        User user = userServiceImpl.getUserById(id);
        userServiceImpl.updateUser(id, user);
        return null;
    }

}
