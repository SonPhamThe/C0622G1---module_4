package com.example.app_blog.repository;

import com.example.app_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog where name_blog like %:searchNameOne% and name_writer like %:searchNameTwo%", nativeQuery = true)
    List<Blog> searchByNameBlog(@Param("searchNameOne") String searchNameOne, @Param("searchNameTwo") String searchNameTwo);
}
