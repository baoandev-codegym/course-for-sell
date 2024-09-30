package com.codegym.course_for_sell.repository;

import com.codegym.course_for_sell.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    User findByPhone(String phone);
}
