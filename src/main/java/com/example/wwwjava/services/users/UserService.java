package com.example.wwwjava.services.users;

import com.example.wwwjava.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(Long id);
    List<User> getAllUsers();

    User saveUser(User user);

    void deleteUserById(Long id);
    User registerDefaultUser(User user);
}
