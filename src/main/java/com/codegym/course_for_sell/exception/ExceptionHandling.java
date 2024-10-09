package com.codegym.course_for_sell.exception;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@ComponentScan("com.codegym.course_for_sell")
public class ExceptionHandling {
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e) {
        return new ModelAndView("error", "message", e.getMessage());
    }
}
