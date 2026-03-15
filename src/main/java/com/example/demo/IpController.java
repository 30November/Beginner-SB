package com.example.demo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IpController {

    @GetMapping("/get-ip")
    public String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For"); 
        if (ip == null || ip.isEmpty()) {
            ip = request.getRemoteAddr(); 
        }
        return "Client IPv4: " + ip;
    }
}