package com.ex.controller;

import com.ex.models.User;
import com.ex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/run")
    public String run() {
        userService.getAllUsers();

        User newUser = new User(3L, "James", "Brown", (byte) 30);
        String firstPart = userService.createUser(newUser);

        newUser.setName("Thomas");
        newUser.setLastName("Shelby");
        String secondPart = userService.updateUser(newUser);
        String thirdPart = userService.deleteUser(newUser.getId());

        return firstPart + secondPart + thirdPart;
    }
}