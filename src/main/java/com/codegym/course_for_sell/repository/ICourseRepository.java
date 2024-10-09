package com.codegym.course_for_sell.repository;

import com.codegym.course_for_sell.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course, Long> {
}
