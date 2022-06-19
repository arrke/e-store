package com.example.wwwjava.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Async
@AllArgsConstructor
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String toEmail, long idOrder) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject("subject");
        simpleMailMessage.setText("Dziękujemy za złożenie zamówienia!");
        simpleMailMessage.setFrom("jb2022@interia.pl");
        javaMailSender.send(simpleMailMessage);
    }
}