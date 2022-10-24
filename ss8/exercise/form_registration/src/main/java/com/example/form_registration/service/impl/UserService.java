package com.example.form_registration.service.impl;

import com.example.form_registration.model.User;
import com.example.form_registration.repository.IUserRepository;
import com.example.form_registration.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;


    @Override
    public Page<User> displayAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
