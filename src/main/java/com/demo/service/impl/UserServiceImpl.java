package com.demo.service.impl;

import com.demo.base.UserType;
import com.demo.entity.User;
import com.demo.repo.UserRepo;
import com.demo.service.UserService;
import com.demo.util.RecordBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findById(Long id) {
        return userRepo.findOne(id);
    }

    @Override
    public long countUsers() {
        return userRepo.countUsers();
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public User create(String email, String password, UserType userType) {
        User user = RecordBuilder.buildUser(email);
        user.setPassword(password);
        user.setUserType(userType);
        return create(user);
    }

    @Override
    @Transactional(readOnly = false)
    public User create(User user) {
        if (user.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepo.save(user);
    }
}
