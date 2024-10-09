package com.codegym.course_for_sell.service.impl;

import com.codegym.course_for_sell.dto.CourseDto;
import com.codegym.course_for_sell.entity.Course;
import com.codegym.course_for_sell.repository.ICourseRepository;
import com.codegym.course_for_sell.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService {
    private final ICourseRepository courseRepository;

    @Override
    public Page<Course> findAll(Pageable pageable) {
        return courseRepository.findAll(pageable);
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Page<CourseDto> findAllCourses(Pageable pageable) {
        Page<Course> courses = courseRepository.findAll(pageable);
        return courses.map(course -> {
            CourseDto courseDto = new CourseDto();
            BeanUtils.copyProperties(course, courseDto);
            courseDto.setCategoryId(course.getCategory().getId());
            courseDto.setImage(Base64.getEncoder().encodeToString(course.getImage()));
            return courseDto;
        });
    }
}
