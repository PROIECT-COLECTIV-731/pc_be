package com.example.project.service;

import com.example.project.dto.UserDto;
import com.example.project.entity.BookEntity;
import com.example.project.entity.UserBookEntity;
import com.example.project.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findByEmailAndPassword(String email, String password);

    String login(String email, String password);

    UserDto findByEmail(String email);
    
    UserEntity findUserByUserName(String username);
    List<UserBookEntity> getExpiredBooks(String username);
    List<BookEntity> getBooks(String username);

}
