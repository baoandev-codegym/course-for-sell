package com.codegym.course_for_sell.dto;

import com.codegym.course_for_sell.entity.Category;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CreateCourseDto {
    private Long id;
    private String name;
    private String content;
    private Double price;
    private MultipartFile image;
    private Category category;
}
