package com.example.project.service;

import com.example.project.entity.UserBookEntity;
import com.example.project.repository.UserBookRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBookService {
    @Autowired
    private UserBookRepository userBookRepository;

    public void deleteUserBooks(List<UserBookEntity> books)
    {
        userBookRepository.deleteAll(books);
    }



}
