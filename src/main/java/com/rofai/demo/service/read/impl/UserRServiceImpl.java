package com.rofai.demo.service.read.impl;

import java.util.List;
import java.util.UUID;

import com.rofai.demo.domain.User;
import com.rofai.demo.repository.read.UserRRepository;
import com.rofai.demo.service.read.UserRService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRServiceImpl implements UserRService{
    @Autowired
    private UserRRepository userRRepository;

    @Override
    public User getUser(UUID ui_iduser) {
        return userRRepository.getUser(ui_iduser);
    }

    @Override
    public List<User> getUsers() {
        return userRRepository.getUsers();
	}

}