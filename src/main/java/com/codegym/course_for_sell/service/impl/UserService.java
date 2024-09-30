package com.codegym.course_for_sell.service.impl;

import com.codegym.course_for_sell.entity.User;
import com.codegym.course_for_sell.repository.IUserRepository;
import com.codegym.course_for_sell.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
