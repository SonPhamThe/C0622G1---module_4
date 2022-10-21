package com.example.app_blog.service.impl;


import com.example.app_blog.model.Blog;
import com.example.app_blog.repository.IBlogRepository;
import com.example.app_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Blogservice implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageablea) {
        return blogRepository.findAll(pageablea);
    }

    @Override
    public void create(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public List<Blog> searchByNameBlog(String searchNameOne, String searchNameTwo) {
        return blogRepository.searchByNameBlog(searchNameOne, searchNameTwo);
    }


}
