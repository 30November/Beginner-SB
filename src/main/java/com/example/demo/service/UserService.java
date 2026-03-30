package com.example.demo.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.repo.UserRepo;
import com.example.demo.model.Users;


@Service
public class UserService implements UserDetailsService{ // Repo <-> Login
    public final UserRepo userRepo;

    
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Users addUser(Users user)
    {
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        return userRepo.save(user);
    }

    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Users user = userRepo.findByName(name)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
            .withUsername(user.getName())
            .password(user.getPassword())
            .roles(user.getRole())
            .build();
    }


    

}
