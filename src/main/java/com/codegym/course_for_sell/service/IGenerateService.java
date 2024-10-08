package com.codegym.course_for_sell.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGenerateService<T> {
    Page<T> findAll(Pageable pageable);

    Optional<T> findById(Long id);

    T save(T t);

    void delete(Long id);
}
