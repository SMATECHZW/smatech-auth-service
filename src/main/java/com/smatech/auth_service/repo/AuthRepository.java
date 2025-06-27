package com.smatech.auth_service.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.smatech.auth_service.model.User;

public interface AuthRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);
}
