package com.egor.blogbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Posts {
    private @Id @GeneratedValue long id;
    private String title;
    private @Lob String post;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posts posts = (Posts) o;
        return id == posts.id && Objects.equals(title, posts.title) && Objects.equals(post, posts.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, post);
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", post='" + post + '\'' +
                '}';
    }
}
