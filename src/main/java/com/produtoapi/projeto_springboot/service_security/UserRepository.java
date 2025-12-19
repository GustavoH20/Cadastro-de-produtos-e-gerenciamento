package com.produtoapi.projeto_springboot.service_security;

import com.produtoapi.projeto_springboot.security_login.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
