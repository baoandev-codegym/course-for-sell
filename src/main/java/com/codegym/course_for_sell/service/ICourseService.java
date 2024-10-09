package com.codegym.course_for_sell.service;

import com.codegym.course_for_sell.dto.CourseDto;
import com.codegym.course_for_sell.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICourseService extends IGenerateService<Course> {
    Page<CourseDto> findAllCourses(Pageable pageable);
}
