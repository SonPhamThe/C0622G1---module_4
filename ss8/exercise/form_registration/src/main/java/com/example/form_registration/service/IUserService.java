package com.example.form_registration.service;

import com.example.form_registration.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<User> displayAll(Pageable pageable);

    void save(User user);
}
