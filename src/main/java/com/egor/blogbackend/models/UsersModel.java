package com.egor.blogbackend.models;

import com.egor.blogbackend.entities.Posts;

import java.util.Objects;
import java.util.Set;

public class UsersModel {
    private long id;
    private String username;

    private Set<Posts> posts;

    public UsersModel(long id, String username, Set<Posts> posts) {
        this.id = id;
        this.username = username;
        this.posts = posts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Posts> getPosts() {
        return posts;
    }

    public void setPosts(Set<Posts> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersModel that = (UsersModel) o;
        return id == that.id && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }

    @Override
    public String toString() {
        return "UsersModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
