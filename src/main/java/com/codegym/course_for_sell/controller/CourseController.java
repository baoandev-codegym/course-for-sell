package com.codegym.course_for_sell.controller;

import com.codegym.course_for_sell.dto.CategoryDto;
import com.codegym.course_for_sell.dto.CourseDto;
import com.codegym.course_for_sell.dto.CreateCourseDto;
import com.codegym.course_for_sell.entity.Category;
import com.codegym.course_for_sell.entity.Course;
import com.codegym.course_for_sell.service.ICategoryService;
import com.codegym.course_for_sell.service.ICourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final ICourseService courseService;
    private final ICategoryService categoryService;

    @ModelAttribute("categories")
    public Page<Category> categoryList(Pageable pageable) {
        return categoryService.findAll(pageable);
    }

    @GetMapping
    public ModelAndView showList(@PageableDefault(size = 4) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("course/list");
        modelAndView.addObject("categories", categoryService.findAllCategory());
        modelAndView.addObject("courseList", courseService.findAllCourses(pageable));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() throws Exception {
        Exception exception = new Exception();
        ModelAndView modelAndView = new ModelAndView("course/create");
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("course", new CreateCourseDto());
        modelAndView.addObject("categories", categoryService.findAllCategory());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("course") @Validated CreateCourseDto createCourseDto,
                       BindingResult bindingResult, Model model) throws Exception {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("categories", categoryService.findAllCategory());
            return "course/create";
        } else {
            Course course = new Course();
            BeanUtils.copyProperties(createCourseDto, course);
            course.setImage(createCourseDto.getImage().getBytes());
            Category category = new Category();
            category.setId(createCourseDto.getCategory().getId());
            course.setCategory(category);
            courseService.save(course);
            return "redirect:/courses";
        }
    }

    @GetMapping("{id}/edit")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Course> course = courseService.findById(id);
        CreateCourseDto createCourseDto = new CreateCourseDto();
        BeanUtils.copyProperties(course.get(), createCourseDto);
        ModelAndView modelAndView = new ModelAndView("course/update");
        modelAndView.addObject("course", createCourseDto);
        modelAndView.addObject("categories", categoryService.findAllCategory());
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("course") @Validated CreateCourseDto createCourseDto,
                       BindingResult bindingResult, Model model) throws Exception {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("categories", categoryService.findAllCategory());
            return "course/update";
        } else {
            Course course = new Course();
            BeanUtils.copyProperties(createCourseDto, course);
            course.setImage(createCourseDto.getImage().getBytes());
            Category category = new Category();
            category.setId(createCourseDto.getCategory().getId());
            course.setCategory(category);
            courseService.save(course);
            return "redirect:/courses";
        }
    }

    @GetMapping("{id}/delete")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Course> course = courseService.findById(id);
        return new ModelAndView("redirect:/courses");
    }
}
