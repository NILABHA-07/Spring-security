package com.nilabha.springsecurity.security.services;

import com.nilabha.springsecurity.security.entitities.User;
import com.nilabha.springsecurity.security.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User register(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
         return userRepository.save(user);
    }
    public String login(User user){
        User userToFind=userRepository.findByUsername(user.getUsername());
        if(Objects.isNull(userToFind)){
           return "user with "+user.getUsername()+" is not found";
        }
        return "You're logged in";
    }
}
