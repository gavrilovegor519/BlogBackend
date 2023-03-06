package com.egor.blogbackend.controllers;

import com.egor.blogbackend.entities.Users;
import com.egor.blogbackend.models.UsersModel;
import com.egor.blogbackend.repos.UsersRepository;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {
    private UsersRepository repository;

    public UsersController(UsersRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/getCurrentUser")
    public UsersModel getCurrentUser(Authentication authentication) {
        Users user = repository.findByUsername(authentication.getName());
        return new UsersModel(user.getId(), user.getUsername(), user.getPosts());
    }

    @PostMapping("/registration")
    public UsersModel registration(@RequestBody Users users) {
        Users user = repository.save(users);
        return new UsersModel(user.getId(), user.getUsername(), user.getPosts());
    }

    @DeleteMapping("/deleteAccount")
    public void deleteAccount(Authentication authentication) {
        repository.delete(repository.findByUsername(authentication.getName()));
    }
}
