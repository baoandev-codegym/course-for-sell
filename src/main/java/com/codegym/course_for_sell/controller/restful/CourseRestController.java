package com.codegym.course_for_sell.controller.restful;

import com.codegym.course_for_sell.entity.Category;
import com.codegym.course_for_sell.entity.Course;
import com.codegym.course_for_sell.service.ICategoryService;
import com.codegym.course_for_sell.service.ICourseService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin("*")
@AllArgsConstructor
public class CourseRestController {
    private final ICourseService courseService;

    @GetMapping
    public ResponseEntity<Page<Course>> findAll(@PageableDefault(page = 0, size = 10,sort = "id",direction = Sort.Direction.DESC) Pageable pageable) {
        return new ResponseEntity<>(courseService.findAll(pageable), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        courseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Course course) {
        courseService.save(course);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Course>> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(courseService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Course course) {
        courseService.save(course);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
