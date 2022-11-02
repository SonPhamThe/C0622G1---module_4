package com.example.app_blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AppBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppBlogApplication.class, args);
    }
}