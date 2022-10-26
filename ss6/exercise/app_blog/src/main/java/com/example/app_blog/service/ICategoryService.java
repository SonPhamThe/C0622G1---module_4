package com.example.app_blog.service;

import com.example.app_blog.model.Blog;
import com.example.app_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
    Page<Category> findAll(Pageable pageable);

    void create(Category category);

    void update(Category category);

    Category findById(int id);

    void remove(Category category);
}
