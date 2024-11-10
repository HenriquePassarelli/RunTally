package com.runtally.runtally.controllers;

import com.runtally.runtally.dto.UpdateUserDTO;
import com.runtally.runtally.dto.UserDTO;
import com.runtally.runtally.entities.User;
import com.runtally.runtally.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody UserDTO userDTO) {
        return userService.save(new User(userDTO));
    }

    @PutMapping
    public Object updateUser(@RequestBody UpdateUserDTO user) {
        return userService.update(user);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") String id) {
        userService.delete(id);
    }

    @GetMapping("{id}")
    public Object getUser(@PathVariable("id") String id) {
        return null;
    }

    @GetMapping("/all")
    public List<User> getUsers() {
        return userService.getUsers();
    }
}
