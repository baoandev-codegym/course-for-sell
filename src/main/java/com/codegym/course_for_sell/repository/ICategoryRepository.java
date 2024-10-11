package com.codegym.course_for_sell.repository;

import com.codegym.course_for_sell.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
    Page<Category> findCategoryByNameContaining(@Param("name") String keyword, Pageable pageable);
}
