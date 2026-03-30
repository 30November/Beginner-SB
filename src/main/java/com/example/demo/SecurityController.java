package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Controller;

import com.example.demo.model.Users;
import com.example.demo.service.UserService;
import com.example.demo.dto.UserRegistration;


// import java.util.Map; ... Without using RequestParam

@Controller
@RequestMapping("/user")
public class SecurityController {

    private final UserService userService;
    PasswordEncoder pwd = new BCryptPasswordEncoder();

    public SecurityController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    String registerForm()
    {
        return "register";
    }

    @PostMapping("/entry")
    String entryUser(@ModelAttribute UserRegistration dto)
    {

        
        String name = dto.getNm();
        String password = pwd.encode(dto.getPw());
        String role = dto.getRl();

        userService.addUser(new Users(name,password,role));
        return "redirect:/user";

    }

}
