package com.example.project.service;

import com.example.project.dto.UserDto;
import com.example.project.entity.BookEntity;
import com.example.project.entity.UserBookEntity;
import com.example.project.entity.UserEntity;

import java.util.List;

public interface UserService {
    public List<UserDto> findAll();
    UserEntity findUserByUserName(String username);
    List<UserBookEntity> getExpiredBooks(String username);
    List<BookEntity> getBooks(String username);
}