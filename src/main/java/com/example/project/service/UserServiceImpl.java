package com.example.project.service;

import com.example.project.dto.UserDto;
import com.example.project.entity.BookEntity;
import com.example.project.entity.UserBookEntity;
import com.example.project.entity.UserEntity;
import com.example.project.mapper.UserMapper;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    private UserMapper userMapper;

    private final Long MAX_DAYS_TO_BORROW=5L;


    @Override
    public List<UserDto> findAll() {
        return userMapper.entitiesToDtos(this.userRepository.findAll());
    }

    @Override
    public UserEntity findUserByUserName(String username)
    {
        return userRepository.findAll().stream().filter(user->user.getUsername().equals(username)).findFirst().orElse(null);
    }

    //gets expired the books of a user expired=the book was borrowed more than 4 days

    public List<UserBookEntity> getExpiredBooks(String username) {
        UserEntity foundUser=findUserByUserName(username);
        List<UserBookEntity>books=new ArrayList<>();
        LocalDate todaysDate=LocalDate.now();

        if(foundUser!=null)
        {
            foundUser.getBooks().forEach(userBook->{if(userBook.getStartDate().plusDays(MAX_DAYS_TO_BORROW).isBefore(todaysDate)){books.add(userBook);}});
        }
        return books;
    }

    public List<BookEntity> getBooks(String username) {
        UserEntity foundUser=findUserByUserName(username);
        List<BookEntity>books=new ArrayList<>();
        if(foundUser!=null)
        {
            foundUser.getBooks().forEach(userBook->{books.add(userBook.getBookEntity());});
        }
        return books;
    }




}
