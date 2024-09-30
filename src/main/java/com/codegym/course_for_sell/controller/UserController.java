package com.codegym.course_for_sell.controller;

import com.codegym.course_for_sell.entity.User;
import com.codegym.course_for_sell.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("users")
    public Iterable<User> commonData(Model model) {
        return userService.findAll();
    }

    @GetMapping
    public String showList(Model model) {
        return "UserList";
    }

    @GetMapping("/search")
    public String search(@RequestParam String username, Model model) {
        model.addAttribute("user", userService.findByUsername(username));
        return "UserDetail";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "CreateUser";
    }

    @PostMapping("/create")
    public String save(User user, @ModelAttribute("users") Iterable<User> users) {
        System.out.println(users);
        userService.save(user);
        return "redirect:/users";
    }
}
