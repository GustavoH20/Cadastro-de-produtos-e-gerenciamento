package com.produtoapi.projeto_springboot.security_config;

import com.produtoapi.projeto_springboot.service_security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Config {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    // 1. Define o codificador de senhas (Obrigatório)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 2. Configurar o provedor de atutenticação
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    // 3. Configura as regras de autorização HTTP
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csft -> csft.disable()) // Desabilita CSRF para APIs, mas matenha para formulários
                .authorizeHttpRequests(auth -> auth

                        // Permite acesso a páginas públicas (ex: login, registro)
                        .requestMatchers("/login", "/register", "/css/**", "/js/**").permitAll()

                        // Exige autenticação para qualquer outra requisição
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login") // Define URL da sua página de login
                        .defaultSuccessUrl("/home", true) // Redireciona após login bem-sucedido
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout") // Redireciona após logout
                        .permitAll()
                );
        return httpSecurity.build();

    }
}
