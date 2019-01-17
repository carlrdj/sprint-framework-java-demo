package com.rofai.demo.repository.write;

import java.util.UUID;

import com.rofai.demo.domain.User;


public interface UserWRepository{
    UUID createUser(User user);
    boolean updateUser(User user);
}