package com.egor.blogbackend.controllers;

import com.egor.blogbackend.entities.Posts;
import com.egor.blogbackend.repos.PostsRepository;
import com.egor.blogbackend.repos.UsersRepository;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostsController {
    private PostsRepository repository;
    private UsersRepository usersRepository;

    public PostsController(PostsRepository repository, UsersRepository usersRepository) {
        this.repository = repository;
        this.usersRepository = usersRepository;
    }

    @GetMapping("/allPosts")
    public List<Posts> allPosts() {
        return repository.findAll();
    }

    @GetMapping("/post/{id}")
    public Posts post(@PathVariable long id) {
        return repository.findById(id);
    }

    @PostMapping("/addPost")
    public Posts addPost(@RequestBody Posts posts, Authentication authentication) {
        Posts post = new Posts(posts.getTitle(), posts.getPost());
        post.setUsers(usersRepository.findByUsername(authentication.getName()));
        post.setUsername(authentication.getName());

        return repository.save(post);
    }

    @DeleteMapping("/deletePost/{id}")
    public void deletePost(@PathVariable long id, Authentication authentication) {
        Posts post = repository.findById(id);

        if (post.getUsers().getUsername().compareTo(authentication.getName()) == 0) {
            repository.deleteById(id);
        }
    }
}
