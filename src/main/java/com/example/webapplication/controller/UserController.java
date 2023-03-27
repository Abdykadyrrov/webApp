package com.example.webapplication.controller;

import com.example.webapplication.model.User;
import com.example.webapplication.service.UserService;
import com.example.webapplication.utils.UserValidator;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
    private final UserService userService;
    private final UserValidator userValidator;

    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registrationPage(@ModelAttribute("user") User user) {
        return "register";
    }

    @PostMapping("/register")
    public String performRegistration(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {

        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors())
            return "register";

        userService.create(user);
        return "redirect:/login";
    }

}
