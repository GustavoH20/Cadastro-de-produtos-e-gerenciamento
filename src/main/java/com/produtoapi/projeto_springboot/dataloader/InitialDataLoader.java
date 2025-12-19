package com.produtoapi.projeto_springboot.dataloader;

import com.produtoapi.projeto_springboot.security_login.Role;
import com.produtoapi.projeto_springboot.security_login.RoleRepository;
import com.produtoapi.projeto_springboot.security_login.User;
import com.produtoapi.projeto_springboot.service_security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class InitialDataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Cria o papel se não existir
        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseGet(() -> roleRepository.save(new Role(null, "ROLE_USER")));

        // Cria o usuário se não existir
        if (userRepository.findByUsername("teste").isEmpty()){
            User user = new User();
            user.setUsername("teste");
            // Criptografa a senha 123456
            user.setPassword(passwordEncoder.encode("123456"));
            user.setRoles(Set.of(userRole));
            userRepository.save(user);
        }

    }
}
