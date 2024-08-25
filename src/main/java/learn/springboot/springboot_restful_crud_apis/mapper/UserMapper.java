package learn.springboot.springboot_restful_crud_apis.mapper;

import learn.springboot.springboot_restful_crud_apis.userDtoEntity.UserDTO;
import learn.springboot.springboot_restful_crud_apis.entity.User;

public class UserMapper {

    //Convert User JPA Entity into User DTO
    public static UserDTO mapToUserDTO(User user) {
        UserDTO userDto = new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDto;
    }

    //Convert User DTO into User JPA Entity
    public static User mapToUser(UserDTO userDto) {
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
    }
}
