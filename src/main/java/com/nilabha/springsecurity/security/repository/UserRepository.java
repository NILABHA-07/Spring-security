package com.nilabha.springsecurity.security.repository;

import com.nilabha.springsecurity.security.entitities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
