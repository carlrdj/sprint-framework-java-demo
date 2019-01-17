package com.rofai.demo.repository.read;

import java.util.List;
import java.util.UUID;

import com.rofai.demo.domain.User;


public interface UserRRepository{
    User getUser(UUID ui_iduser);
    List<User> getUsers();
}