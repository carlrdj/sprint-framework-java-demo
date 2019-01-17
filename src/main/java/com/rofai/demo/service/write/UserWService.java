package com.rofai.demo.service.write;

import java.util.UUID;

import com.rofai.demo.domain.User;

public interface UserWService{
    UUID createUser(User user);
    boolean updateUser(User user);
}