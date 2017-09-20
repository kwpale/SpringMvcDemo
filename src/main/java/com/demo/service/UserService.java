package com.demo.service;

import com.demo.base.UserType;
import com.demo.entity.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    long countUsers();

    void create(String email, String password, UserType userType);

    List<User> findAll();
}
