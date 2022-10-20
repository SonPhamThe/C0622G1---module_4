package com.example.app_blog.service;

import com.example.app_blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    void create(Blog blog);

    void update(Blog blog);

    Blog findById(int id);

    void remove(Blog blog);
}
