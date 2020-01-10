package code.flatura.expendit.service;

import code.flatura.expendit.model.User;
import code.flatura.expendit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserService() {
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User newUser) {
        return userRepository.save(newUser);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }

    public User getByName(String name) {
        return userRepository.findByName(name);
    }

    public void update(User updatedUser, int id) {
        if (userRepository.existsById(id)) {
            userRepository.save(updatedUser);
        }
    }

    public void delete(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }
}
