package com.example.demodds.service;

import com.example.demodds.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<User> displayAll(Pageable pageable);

    void save(User user);
}
