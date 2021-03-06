package com.example.wwwjava;

import com.example.wwwjava.models.Role;
import com.example.wwwjava.models.User;
import com.example.wwwjava.repositories.UserRepository;
import com.example.wwwjava.services.roles.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;
@ComponentScan({"com.example.wwwjava.services", "com.example.wwwjava"})
@SpringBootApplication
@EnableAsync
public class WwwJavaApplication {
    @Autowired
    public UserRepository repository;
    @Autowired
    public RoleService roleService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    public static void main(String[] args) {
        SpringApplication.run(WwwJavaApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData() {
        return (args) -> {
            // create admin user
            User u = repository.getUserByUsername("admin");
            if (u == null) {
                User admin = new User();
                admin.setEmail("admin@admin.pl");
                admin.setFirstName("adminowski");
                admin.setLastName("adminowski");
                admin.setPassword(passwordEncoder.encode("adminadmin"));
                Set<Role> roles = new HashSet<>();
                roles.add(new Role("ROLE_ADMIN"));
                roles.add(new Role("ROLE_USER"));
                admin.setRoles(roles);
                repository.save(admin);
                System.out.println("UTWORZONO ADMINA");
            }
            System.out.println("SEEDY ZAŁADOWANO");
        };
    }
}
