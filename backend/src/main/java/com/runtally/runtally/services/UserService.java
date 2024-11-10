package com.runtally.runtally.services;

import com.runtally.runtally.dto.UpdateUserDTO;
import com.runtally.runtally.entities.User;
import com.runtally.runtally.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public Object update(UpdateUserDTO userDTO) {
        User user = getUser(userDTO.id());
        if (user == null) throw new NullPointerException("User not found");

        user.setName(userDTO.name());
        user.setPassword(userDTO.password());

        return userRepository.save(user);
    }

    @Transactional
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(String id) {
        return userRepository.findById(id).orElse(null);
    }
}
