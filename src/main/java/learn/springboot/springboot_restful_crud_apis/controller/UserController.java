package learn.springboot.springboot_restful_crud_apis.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import learn.springboot.springboot_restful_crud_apis.userDtoEntity.UserDTO;
import learn.springboot.springboot_restful_crud_apis.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/users")
@Tag(
        name = "CRUD Rest API for User Resource",
        description = "Create, Update, Get, Get All Users, Delete User Rest APIs are built for User entity"
)
public class UserController {

    @Autowired //we don't need to use this because spring
    // automatically injects if there's only 1 parameterized constructor
    private UserService userService;

    //Build CREATE Rest API

    @PostMapping
    @Operation(summary = "Create User Rest API",
            description = "Create User Rest API is used to save the user in the database")
    @ApiResponse(responseCode = "201",
            description = "HTTP Status 201 CREATED")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO user) {
        UserDTO savedUser = userService.createUser(user);
        System.out.println("THe created user details are:" + "\n FirstName: " + savedUser.getFirstName() + "\n LastName: " +
                savedUser.getLastName() + "\n Email: " + savedUser.getEmail());
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }


    //Build GET user by ID

    //http:localhost:8080/api/users/1
    @GetMapping(value = "{id}")
    @Operation(summary = "Get User by ID Rest API",
            description = "Get User by ID Rest API is used to get the single user from the database")
    @ApiResponse(responseCode = "200",
            description = "HTTP Status 200 SUCCESS")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") int userID) {
        UserDTO userById = userService.getUserById(userID);
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
    @Operation(summary = "Get All Users Rest API",
            description = "Get Users Rest API is used to get all the users from the database")
    @ApiResponse(responseCode = "200",
            description = "HTTP Status 200 SUCCESS")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    //Build UPDATE User API

    //http:localhost:8080/api/users/1

    @PutMapping(value = "{id}")
    @Operation(summary = "Update User Rest API",
            description = "Update User Rest API is used to update a particular user in the database")
    @ApiResponse(responseCode = "200",
            description = "HTTP Status 200 SUCCESS")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") int userId,
                                              @RequestBody @Valid UserDTO user) {
        user.setId(userId);
        UserDTO updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //Build DELETE User API

    //http:localhost:8080/api/users/1

    @DeleteMapping(value = "{id}")
    @Operation(summary = "Delete User Rest API",
            description = "Delete User Rest API is used to delete a particular user in the database")
    @ApiResponse(responseCode = "200",
            description = "HTTP Status 200 SUCCESS")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!!", HttpStatus.OK);
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
//                                                                        WebRequest webRequest) {
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }
}
