package com.example.wwwjava.controllers;

import com.example.wwwjava.models.User;
import com.example.wwwjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired private BCryptPasswordEncoder providedEncodere;

    @GetMapping("/register")
    public String processRegister(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "account/register";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("user", user);
            return "account/register";
        }
        userService.registerDefaultUser(user);
        return "account/register_success";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
