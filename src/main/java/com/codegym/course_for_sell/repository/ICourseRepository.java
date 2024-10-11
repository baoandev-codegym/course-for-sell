package com.codegym.course_for_sell.repository;

import com.codegym.course_for_sell.dto.CourseDto;
import com.codegym.course_for_sell.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICourseRepository extends JpaRepository<Course, Long> {
    Page<Course> findCoursesByNameContaining(@Param("name") String name, Pageable pageable);

    @Query("SELECT c FROM Course c WHERE c.category.id = :categoryId")
    Page<Course> findCoursesByCategoryContaining(@Param("categoryId") Long categoryId, Pageable pageable);

    @Query("SELECT c FROM Course c WHERE c.name LIKE %:name% AND c.category.id = :categoryId")
    Page<Course> findCoursesByNameContainingAndCategoryContaining(
            @Param("name") String name, @Param("categoryId") Long categoryId, Pageable pageable);
}
