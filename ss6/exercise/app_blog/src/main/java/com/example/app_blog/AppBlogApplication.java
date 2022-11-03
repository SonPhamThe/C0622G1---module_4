package com.example.app_blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AppBlogApplication {
    public static void main(String[] args) { // nhấn đây nè
        SpringApplication.run(AppBlogApplication.class, args);
//        cái này để chạy hết chương trình, để lấy mã hóa thì cần tắt cái này cho nhanh
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("123"));
    }
}