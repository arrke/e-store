package com.example.wwwjava.controllers;

import com.example.wwwjava.models.User;
import com.example.wwwjava.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @InitBinder
    private void initBinder(WebDataBinder dataBinder)
    {
        logger.info("init of binder");
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @Autowired
    private UserDao userService;
    @Autowired private BCryptPasswordEncoder providedEncodere;

    @GetMapping("/register")
    public String processRegister(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        logger.info("creating user");
        return "account/register";
    }

    @PostMapping("/register")
    public String processRegister(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("user", user);
            logger.error("error in register process. User can't be registered");
            return "account/register";
        }
        userService.registerDefaultUser(user);
        logger.info("user registered");
        return "account/register_success";
    }

    @GetMapping("/login")
    public String login() {

        logger.info("logging into acount");
        return "login";
    }

}
