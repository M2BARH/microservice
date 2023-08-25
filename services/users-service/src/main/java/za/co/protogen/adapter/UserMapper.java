package za.co.protogen.adapter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import za.co.protogen.controller.models.UserDTO;
import za.co.protogen.domain.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "dateOfBirth", source = "dateOfBirth", dateFormat = "yyyy-MM-dd")
    UserDTO userToDTO(User user); // controller to domain

    List<UserDTO> userToDTO(List<User> user); // domain to controller

    @Mapping(target = "dateOfBirth", source = "dateOfBirth", dateFormat = "yyyy-MM-dd")
    User dtoToUser(UserDTO userDTO); // entity to domain
}
