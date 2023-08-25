package za.co.protogen.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.LocalDate;
import za.co.protogen.controller.models.UsersApi;
import za.co.protogen.controller.models.UserDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import za.co.protogen.adapter.UserMapper;
import za.co.protogen.core.impl.UserServiceImpl;
import za.co.protogen.domain.User;
import za.co.protogen.searchCriteria.UserSearchCriteria;

import java.util.List;

@RestController
@RefreshScope
@RequiredArgsConstructor
@RequestMapping
public class UserServiceApiController implements UsersApi {

    private final UserServiceImpl userServiceImpl;
    private  final UserMapper userMapper;
    private final Logger logger = LoggerFactory.getLogger(UserServiceApiController.class);

    @Override
    public ResponseEntity<Void> addUser(UserDTO userDTO) {
        logger.info("Adding a user to the database");
        userServiceImpl.addUser(userMapper.dtoToUser(userDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<List<UserDTO>> getAllUser() {
        logger.info("Fetching all users from the database");
        return ResponseEntity.ok(userMapper.userToDTO(userServiceImpl.getAllUsers()));
    }

    @Override
    public ResponseEntity<UserDTO> getUserById(Long id) {
        logger.info("Fetching a car identified by: " + id + ",from the database");
        return ResponseEntity.ok(userMapper.userToDTO(userServiceImpl.getUserById(id)));
    }

    @Override
    public ResponseEntity<List<UserDTO>> searchUser(
            Long id, String firstName, String lastName,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth, String rsaId) {
        logger.info("Searching for a reservation from the database");
        UserSearchCriteria criteria = new UserSearchCriteria();
        criteria.setId(id);
        criteria.setFirstName(firstName);
        criteria.setLastName(lastName);
        criteria.setDateOfBirth(dateOfBirth);
        criteria.setRsaId(rsaId);

        List<User> users = userServiceImpl.searchUsers(criteria);
        List<UserDTO> userDTOs = userMapper.userToDTO(users);
        return ResponseEntity.ok(userDTOs);
    }

    @Override
    public ResponseEntity<Void> removeUser(Long id) {
        logger.info("Removing a user identified by: " + id + ", from the database");
        userServiceImpl.removeUser(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<Void> updateUser(Long id) {
        logger.info("Fetching adding a car identified by: " + id + ", and updating them");
        userServiceImpl.updateUser(id, userServiceImpl.getUserById(id));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
