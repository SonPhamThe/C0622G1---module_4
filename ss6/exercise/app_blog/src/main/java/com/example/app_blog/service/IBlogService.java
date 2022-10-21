package com.example.app_blog.service;

import com.example.app_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    void create(Blog blog);

    void update(Blog blog);

    Blog findById(int id);

    void remove(Blog blog);

    List<Blog> searchByNameBlog(@Param("searchNameOne") String searchNameOne, @Param("searchNameTwo") String searchNameTwo);
}
