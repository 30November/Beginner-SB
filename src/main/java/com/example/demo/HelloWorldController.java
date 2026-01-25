package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloWorldController {
    
    @GetMapping("/")
    String hello(@RequestParam 
        (value = "n", defaultValue = "World") 
        String name)
    {
        return String.format("Hello %s!!!",name);
    }
}
