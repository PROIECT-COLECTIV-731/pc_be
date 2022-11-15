package com.example.project.service;

import com.example.project.dto.UserDto;
import com.example.project.entity.UserEntity;

import java.util.List;

public interface UserService {
    public List<UserDto> findAll();
}
