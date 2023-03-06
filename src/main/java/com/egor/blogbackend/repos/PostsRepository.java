package com.egor.blogbackend.repos;

import com.egor.blogbackend.entities.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    Posts findById(long id);
}
