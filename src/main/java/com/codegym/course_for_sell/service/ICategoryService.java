package com.codegym.course_for_sell.service;

import com.codegym.course_for_sell.entity.Category;

import java.util.List;

public interface ICategoryService extends IGenerateService<Category> {
    List<Category> findAllCategory();
}
