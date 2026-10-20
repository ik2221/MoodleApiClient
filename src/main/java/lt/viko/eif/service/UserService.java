package lt.viko.eif.service;

import lt.viko.eif.dto.User;
import lt.viko.eif.repository.UserRepository;

import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String firstName, String lastName, String email) {
        return userRepository.save(new User(null, firstName, lastName, email));
    }

    @Transactional
    public void createMultipleUsers(List<User> users) {
        userRepository.saveAll(users);
    }
}
