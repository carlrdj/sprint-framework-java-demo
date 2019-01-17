package com.rofai.demo.service.write.impl;

import java.util.List;
import java.util.UUID;

import com.rofai.demo.domain.User;
import com.rofai.demo.repository.read.UserRRepository;
import com.rofai.demo.repository.write.UserWRepository;
import com.rofai.demo.service.read.UserRService;
import com.rofai.demo.service.write.UserWService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWServiceImpl implements UserWService{
    @Autowired
    private UserWRepository userWRepository;

    @Override
    public UUID createUser(User user) {
        return userWRepository.createUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userWRepository.updateUser(user);
    }

}