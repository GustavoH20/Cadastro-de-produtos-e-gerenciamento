package com.produtoapi.projeto_springboot.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    // Mapeia a URL /login para o template login.html
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    // Mapeia a URL /home para o template home.html
    // Esta é a página que o usuário verá após o login
    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
