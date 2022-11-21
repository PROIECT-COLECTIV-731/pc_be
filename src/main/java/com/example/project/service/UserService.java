package com.example.project.service;

import com.example.project.dto.UserDto;
import com.example.project.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findByEmailAndPassword(String email, String password);

    String login(String email, String password);

    UserDto findByEmail(String email);
}
