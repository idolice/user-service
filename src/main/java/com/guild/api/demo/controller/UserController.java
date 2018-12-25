package com.guild.api.demo.controller;

import com.guild.api.demo.model.User;
import com.guild.api.demo.repository.UserRepository;
import com.guild.api.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/users/{userId}")
    public String getUser(@PathVariable String userId) throws InterruptedException {
        Thread.sleep(1000);
        User user = new User();
        user.setId(userId);
        user.setName("James");
        userService.saveUser(user);
        User result = userService.getUser(userId);
        return String.format("{Id: %s, Name: %s}", result.getId(), result.getName());
    }

}
