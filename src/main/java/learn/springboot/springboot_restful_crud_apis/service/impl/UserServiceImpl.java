package learn.springboot.springboot_restful_crud_apis.service.impl;

import learn.springboot.springboot_restful_crud_apis.userDtoEntity.UserDTO;
import learn.springboot.springboot_restful_crud_apis.entity.User;
import learn.springboot.springboot_restful_crud_apis.exception.EmailIDExistsException;
import learn.springboot.springboot_restful_crud_apis.exception.ResourceNotFoundException;
import learn.springboot.springboot_restful_crud_apis.mapper.AutoUserMapper;
import learn.springboot.springboot_restful_crud_apis.repository.UserRepository;
import learn.springboot.springboot_restful_crud_apis.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDto) {


        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent()) {
            throw new EmailIDExistsException("Email already exists, Please choose alternate email address");
        }
        //Convert UserDTO in to User JPA Entity

        //Using Manual UserMapper class
        //User userJPAEntity = UserMapper.mapToUser(userDto);

        //Using ModelMapper library
        User userJPAEntity = AutoUserMapper.MAPPER.mapToUser(userDto);
        User savedUser = userRepository.save(userJPAEntity);

        //Convert user jpa entity to user dto

        //Using Manual UserMapper class
        //UserDTO savedUserDto = UserMapper.mapToUserDTO(savedUser);

        //Using ModelMapper library
        //UserDTO savedUserDto = modelMapper.map(savedUser, UserDTO.class);

        //Using ModelMapper library
        UserDTO savedUserDto = AutoUserMapper.MAPPER.mapToUserDTO(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDTO getUserById(int userId) {
        User byId = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId));
        // User getUser = byId.get();
        //return UserMapper.mapToUserDTO(getUser);
        //return modelMapper.map(getUser, UserDTO.class);
        return AutoUserMapper.MAPPER.mapToUserDTO(byId);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        //return allUsers.stream().map(UserMapper::mapToUserDTO).collect(Collectors.toList());
        //return allUsers.stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
        return allUsers.stream().map(user -> AutoUserMapper.MAPPER.mapToUserDTO(user)).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        User userToUpdate = userRepository
                .findById(user.getId()).orElseThrow(() -> new ResourceNotFoundException("User", "id", user.getId()));
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());
        User updatedUser = userRepository.save(userToUpdate);
        //return UserMapper.mapToUserDTO(updatedUser);
        //return modelMapper.map(updatedUser, UserDTO.class);
        return AutoUserMapper.MAPPER.mapToUserDTO(updatedUser);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository
                .findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        userRepository.deleteById(userId);
    }


}
