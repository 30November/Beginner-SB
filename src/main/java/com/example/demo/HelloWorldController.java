package com.example.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloWorldController {

    @GetMapping("/")
    String hello(@RequestParam(value = "n", defaultValue = "World") String name) {
        return String.format("Hello %s!!!", name);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admins")
    String admin()
    {
        return "admin page";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/users")
    String user()
    {
        return "user page";
    }


}
