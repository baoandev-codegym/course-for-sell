package com.codegym.course_for_sell.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CategoryDto {
    private Long id;
    @NotEmpty(message = "Name must not empty")
    private String name;
}
