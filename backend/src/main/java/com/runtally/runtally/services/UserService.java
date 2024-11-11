package com.runtally.runtally.services;

import com.runtally.runtally.dto.UpdateUserDTO;
import com.runtally.runtally.dto.UserDTO;
import com.runtally.runtally.entities.Role;
import com.runtally.runtally.entities.User;
import com.runtally.runtally.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User save(UserDTO userDTO) {
        List<Role> roles = roleService.getRoles(userDTO.roles());
        if (roles.isEmpty()) throw new IllegalArgumentException("Roles do not exist or are invalid");

        User user = new User(userDTO.name(), userDTO.email(), passwordEncoder.encode(userDTO.password()), userDTO.cpf(), roles);

        return userRepository.save(user);
    }

    @Transactional
    public Object update(UpdateUserDTO userDTO) {
        User user = getUser(userDTO.id());

        user.setName(userDTO.name());
        user.setPassword(passwordEncoder.encode(userDTO.password()));
        user.setRoles(roleService.getRoles(userDTO.roles()));

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
        return userRepository.findById(id).orElseThrow(() -> new NullPointerException("User not found"));
    }

    public boolean authenticate(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password).isPresent();
    }
}
