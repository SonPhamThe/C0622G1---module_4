package com.example.app_blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
class CaseStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaseStudyApplication.class, args);
    }

}