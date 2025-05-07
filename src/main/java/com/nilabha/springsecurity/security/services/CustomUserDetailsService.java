package com.nilabha.springsecurity.security.services;

import com.nilabha.springsecurity.security.CustomUserDetails;
import com.nilabha.springsecurity.security.entitities.User;
import com.nilabha.springsecurity.security.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username);
        if(Objects.isNull(user)){
            throw new UsernameNotFoundException("Username is not found");
        }
        return new CustomUserDetails(user);
    }
}
