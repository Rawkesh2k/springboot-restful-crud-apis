package learn.springboot.springboot_restful_crud_apis.service;

import learn.springboot.springboot_restful_crud_apis.userDtoEntity.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO user);

    UserDTO getUserById(int userId);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(UserDTO user);

    void deleteUser(int userId);
}
