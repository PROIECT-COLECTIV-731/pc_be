package com.example.project.service;

import com.example.project.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findByEmailAndPassword(String email, String password);

    String login(String email, String password);

    UserDto findByEmail(String email);
}
