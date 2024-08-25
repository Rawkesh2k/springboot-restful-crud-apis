package learn.springboot.springboot_restful_crud_apis.controller;

import learn.springboot.springboot_restful_crud_apis.entity.User;
import learn.springboot.springboot_restful_crud_apis.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/users")
public class UserController_Copy_Before_UserDTO {

    @Autowired //we don't need to use this because spring
    // automatically injects if there's only 1 parameterized constructor
    private UserService userService;

    //Build CREATE Rest API

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }


    //Build GET user by ID

    //http:localhost:8080/api/users/1
    @GetMapping(value = "{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int userID) {
        User userById = userService.getUserById(userID);
        System.out.println("The user details are: " + "Id -> "
                + userById.getId()
                + " , First name -> " + userById.getFirstName()
                + " , Last name -> " + userById.getLastName()
                + " , Email -> " + userById.getEmail()
        );
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    //Build GET ALL USERS API

    //http:localhost:8080/api/users
    @GetMapping(value = "/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    //Build UPDATE User API

    //http:localhost:8080/api/users/1

    @PutMapping(value = "{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") int userId, @RequestBody User user) {
        user.setId(userId);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //Build DELETE User API

    //http:localhost:8080/api/users/1

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!!", HttpStatus.OK);
    }

}
*/
