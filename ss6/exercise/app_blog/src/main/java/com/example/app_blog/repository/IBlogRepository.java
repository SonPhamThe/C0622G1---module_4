package com.example.app_blog.repository;

import com.example.app_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog where name_blog like %:searchNameOne% and name_writer like %:searchNameTwo%", nativeQuery = true)
    List<Blog> searchByNameBlog(@Param("searchNameOne") String searchNameOne, @Param("searchNameTwo") String searchNameTwo);

    @Query(value = "SELECT * FROM blog JOIN category ON blog.category_id = category.id WHERE category.name like %:keyword%", nativeQuery = true)
    List<Blog> searchByNameCategory(@Param("keyword") String keyword);
}
