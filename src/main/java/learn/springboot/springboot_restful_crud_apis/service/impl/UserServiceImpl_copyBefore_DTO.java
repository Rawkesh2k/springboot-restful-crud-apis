package learn.springboot.springboot_restful_crud_apis.service.impl;

/*
@Service
@AllArgsConstructor
public class UserServiceImpl_copyBefore_DTO implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(int userId) {
        Optional<User> byId = userRepository.findById(userId);
        return byId.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User userToUpdate = userRepository.findById(user.getId()).get();
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());
        User updatedUser = userRepository.save(userToUpdate);
        return updatedUser;
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }
}*/
