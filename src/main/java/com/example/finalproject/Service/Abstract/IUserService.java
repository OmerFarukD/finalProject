package com.example.finalproject.Service.Abstract;

import com.example.finalproject.Entity.User;

import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void makeAdmin(String username);
}