package com.example.demodds.service.impl;

import com.example.demodds.model.User;
import com.example.demodds.repository.IUserRepository;
import com.example.demodds.service.IUserService;

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
