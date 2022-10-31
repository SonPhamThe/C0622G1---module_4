package com.example.app_blog.controller;

import com.example.app_blog.dto.BlogDTO;
import com.example.app_blog.model.Blog;
import com.example.app_blog.service.IBlogService;
import com.example.app_blog.service.ICategoryService;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blog/v1")
public class BlogWebService {

    @Autowired
    private IBlogService blogService;

    /* Lấy tài nguyên - xem danh sách bài viết */
    @GetMapping("")
    public ResponseEntity<List<Blog>> getBlogList() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    /* Tạo Tài Nguyên - tạo một bài viết mới */
    @PostMapping("")
    public ResponseEntity addBLog(@RequestBody BlogDTO blogDTO) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDTO, blog);
        blogService.create(blog);
        return new ResponseEntity(HttpStatus.OK);
    }

    /* Chỉnh sửa tài nguyên - chỉnh sửa một bài viết */
    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(
            @PathVariable int id,
            @RequestBody BlogDTO blogDTO
    ) {
        Blog currentBLog = blogService.findById(id);
        if (currentBLog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(blogDTO, currentBLog);
        blogService.create(currentBLog);
        return new ResponseEntity<>(currentBLog, HttpStatus.OK);
    }

    /* Xóa tài nguyên - xóa bài viết theo id */
    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteBlog(
            @PathVariable int id,
            @RequestBody BlogDTO blogDTO
    ) {
        Blog currentBlog = blogService.findById(id);
        if (currentBlog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(blogDTO, currentBlog);
        blogService.remove(id);
        return new ResponseEntity<>(currentBlog, HttpStatus.OK);
    }

    /* Xem chi tiết một bài viết */
    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable int id) {
        Optional<Blog> blogOptional = blogService.findByIdOptional(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
    }

    /* Xem danh sách các bài viết của một category */
    @GetMapping("/search/{nameCategory}")
    public ResponseEntity<List<Blog>> searchByNameCategory(@PathVariable String nameCategory) {
        /* Nếu không biết Collections thì dùng Interator */
        List<Blog> blogList = blogService.searchByNameCategory(nameCategory);
        if (blogList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
