package com.covelotaf.api.controller;

import com.covelotaf.api.entity.User;
import com.covelotaf.api.repository.UserRepository;
import com.covelotaf.api.request.UpdateUserRequest;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    public User create(@RequestBody UpdateUserRequest updateUserRequest) {
        User user = new User(updateUserRequest.getFirstName(), updateUserRequest.getLastName());

        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);

        userRepository.insert(user);

        return user;
    }

    @PutMapping("/user/{userId}")
    public User update(@PathVariable String userId, @RequestBody UpdateUserRequest updateUserRequest) {
        User user = userRepository.findByUserId(userId);

        user.setFirstName(updateUserRequest.getFirstName());
        user.setLastName(updateUserRequest.getLastName());

        userRepository.save(user);

        return user;
    }
}
