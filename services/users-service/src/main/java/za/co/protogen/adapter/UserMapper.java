package za.co.protogen.adapter;

import com.example.userservice.models.UserDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import za.co.protogen.domain.User;
import za.co.protogen.serializer.LocalDateConfig;

import java.time.LocalDate;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "dateOfBirth", ignore = true)
    UserDTO userToDTO(User user); // controller to domain

    List<UserDTO> userToDTO(List<User> user); // domain to controller

    @Mapping(target = "dateOfBirth", ignore = true)
    User dtoToUser(UserDTO userDTO); // entity to domain

    default String localDateToString(LocalDate dateOfBirth) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateConfig())
                .create();
        return gson.toJson(dateOfBirth);
    }
}
