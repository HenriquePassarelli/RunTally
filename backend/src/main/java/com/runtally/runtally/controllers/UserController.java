package com.runtally.runtally.controllers;

import com.runtally.runtally.auth.AuthenticationService;
import com.runtally.runtally.auth.JwtService;
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
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;


    public UserController(UserService userService, JwtService jwtService, AuthenticationService authenticationService) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public User save(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @PutMapping
    public Object update(@RequestBody UpdateUserDTO user) {
        return userService.update(user);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id) {
        userService.delete(id);
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") String id) {
        return userService.getUser(id);
    }

    @GetMapping("/all")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO) {
        System.out.println(userService.authenticate(userDTO.email(), userDTO.password()));
        User authenticatedUser = authenticationService.authenticate(userDTO);

        System.out.println(authenticatedUser.getName());

        String jwtToken = jwtService.generateToken(authenticatedUser);

        return jwtToken;
    }
}
