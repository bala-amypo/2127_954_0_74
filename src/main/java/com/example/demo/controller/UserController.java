package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getOneUser(id);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        Optional<User> userOpt = userService.getOneUser(id);

        if (userOpt.isPresent()) {
            User existingUser = userOpt.get();
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            userService.insertUser(existingUser);
            return "User Updated Successfully";
        }
        return "User Not Found";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        Optional<User> user = userService.getOneUser(id);

        if (user.isPresent()) {
            userService.deleteUser(id);
            return "User Deleted Successfully";
        }
        return "User Not Found";
    }
}