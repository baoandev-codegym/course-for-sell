package com.codegym.course_for_sell.controller;

import com.codegym.course_for_sell.dto.CategoryDto;
import com.codegym.course_for_sell.entity.Category;
import com.codegym.course_for_sell.service.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
    private final ICategoryService categoryService;

    @GetMapping
    public ModelAndView showList(@PageableDefault(size = 10) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("category/list");
        modelAndView.addObject("categoryList", categoryService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() throws Exception {
        Exception exception = new Exception();
        ModelAndView modelAndView = new ModelAndView("category/create", "category", new CategoryDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("category")
                                 @Validated CategoryDto category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("category/create");
            return modelAndView;
        } else {
            Category category1 = new Category();
            category1.setName(category.getName());
            categoryService.save(category1);
            ModelAndView modelAndView = new ModelAndView("redirect:/categories");
            return modelAndView;
        }
    }

    @GetMapping("{id}/edit")
    public ModelAndView showUpdateForm(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        return new ModelAndView("category/update", "category", category);
    }

    @PostMapping("/update")
    public ModelAndView update(Category category) {
        categoryService.save(category);
        return new ModelAndView("redirect:/categories");
    }

    @GetMapping("{id}/delete")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        return new ModelAndView("redirect:/categories");
    }
}
