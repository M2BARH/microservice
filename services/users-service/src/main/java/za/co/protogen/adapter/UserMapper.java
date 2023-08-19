package za.co.protogen.adapter;

import com.example.userservice.models.UserDTO;
import org.mapstruct.Mapper;
import za.co.protogen.domain.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO userToDTO(User user); // controller to domain
    List<UserDTO> userToDTO(List<User> user); // domain to controller
    User dtoToUser(UserDTO userDTO); // entity to domain
}
