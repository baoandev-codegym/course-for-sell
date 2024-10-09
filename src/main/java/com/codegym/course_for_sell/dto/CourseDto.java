package com.codegym.course_for_sell.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CourseDto {
    private Long id;
    private String name;
    private String content;
    private Double price;
    private String image;
    private Long categoryId;

}
