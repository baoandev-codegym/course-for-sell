package com.codegym.course_for_sell.service;

import com.codegym.course_for_sell.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService extends IGenerateService<Category> {
    List<Category> findAllCategory();

    Page<Category> findCategoryByKeyword(String keyword, Pageable pageable);
}
