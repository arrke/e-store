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

//    public EmailService(JavaMailSender javaMailSender) {
//        this.javaMailSender = javaMailSender;
//    }

    public void sendMail(String toEmail, long idOrder) {

     SimpleMailMessage simpleMailMessage=new SimpleMailMessage();

     simpleMailMessage.setTo("jb2022@interia.pl");
     simpleMailMessage.setSubject("subject");
     simpleMailMessage.setText("Dziękujemy za złożenie zamówienia!");
     simpleMailMessage.setFrom("jb2022@interia.pl");
     javaMailSender.send(simpleMailMessage);
//        mailMessage.setTo(toEmail);
//        mailMessage.setSubject(subject);
//        mailMessage.setText(message);
//
//        mailMessage.setFrom("johndoe@example.com");
//
//        javaMailSender.send(mailMessage);
    }

//    public void sendMail(String toEmail, String subject, String message) {
//
//        var mailMessage = new SimpleMailMessage();
//
//        mailMessage.setTo(toEmail);
//        mailMessage.setSubject(subject);
//        mailMessage.setText(message);
//
//        mailMessage.setFrom("johndoe@example.com");
//
//        javaMailSender.send(mailMessage);
//    }
}