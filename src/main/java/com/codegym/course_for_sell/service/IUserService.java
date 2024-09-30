package com.codegym.course_for_sell.service;

import com.codegym.course_for_sell.entity.User;

import java.util.List;

public interface IUserService {
    Iterable<User> findAll();
    User findById(Long id);
    void save(User user);
    void remove(Long id);

    User findByUsername(String username);
}
