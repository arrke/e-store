package com.example.wwwjava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailData {
    @Bean
    public JavaMailSender javaMailSender()
    {
        JavaMailSenderImpl javaMailSender=new JavaMailSenderImpl();
        javaMailSender.setHost("poczta.interia.pl");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("jb2022@interia.pl");
        javaMailSender.setPassword("JavaBiznes2022");
        Properties properties=javaMailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", "true");
        return javaMailSender;

    }
}
