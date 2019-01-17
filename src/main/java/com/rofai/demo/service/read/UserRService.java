package com.rofai.demo.service.read;

import java.util.List;
import java.util.UUID;

import com.rofai.demo.domain.User;

public interface UserRService{
    User getUser(UUID ui_iduser);
    List<User> getUsers();
}