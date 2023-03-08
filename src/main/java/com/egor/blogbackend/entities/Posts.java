package com.egor.blogbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Posts {
    private @Id @GeneratedValue long id;
    private String title;
    private @Lob String post;
    private String username;

    private @ManyToOne @JsonIgnore Users users;

    public Posts() {
    }

    public Posts(String title, String post) {
        this.title = title;
        this.post = post;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posts posts = (Posts) o;
        return id == posts.id && Objects.equals(title, posts.title) && Objects.equals(post, posts.post) && Objects.equals(username, posts.username) && Objects.equals(users, posts.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, post, username, users);
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", post='" + post + '\'' +
                ", username='" + username + '\'' +
                ", users=" + users +
                '}';
    }
}
