package com.nilabha.springsecurity.security.contollers;

import com.nilabha.springsecurity.security.entitities.User;
import com.nilabha.springsecurity.security.repository.UserRepository;
import com.nilabha.springsecurity.security.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        //return userRepository.save(user);
        System.out.println("Registering user: " + user.getUsername());
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.verify(user);

    }

}
