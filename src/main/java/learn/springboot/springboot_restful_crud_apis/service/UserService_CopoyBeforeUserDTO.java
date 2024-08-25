package learn.springboot.springboot_restful_crud_apis.service;

import learn.springboot.springboot_restful_crud_apis.entity.User;

import java.util.List;

public interface UserService_CopoyBeforeUserDTO {
    User createUser(User user);

    User getUserById(int userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(int userId);
}
