package com.example.wwwjava.controllers;

import com.example.wwwjava.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping(value = "/sendmail")
    public String sendmail() {

        emailService.sendMail("czarnaherbata223@gmail.com", "Test Subject", "Test mail");

        return "sent";
    }
}
