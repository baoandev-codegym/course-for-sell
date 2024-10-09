package com.codegym.course_for_sell.formatter;

import com.codegym.course_for_sell.entity.Category;
import com.codegym.course_for_sell.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CategoryFormatter implements Formatter<Category> {
    private final ICategoryService categoryService;

    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        Optional<Category> categoryOptional = categoryService.findById(Long.parseLong(text));
        return categoryOptional.orElse(null);
    }

    @Override
    public String print(Category object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
