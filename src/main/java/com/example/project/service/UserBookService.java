package com.example.project.service;

import com.example.project.entity.BookEntity;
import com.example.project.entity.UserBookEntity;
import com.example.project.entity.UserEntity;
import com.example.project.repository.UserBookRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserBookService {
    @Autowired
    private UserBookRepository userBookRepository;
    public void deleteUserBooks(List<UserBookEntity> books)
    {
        if(books.size()>0){
        userBookRepository.deleteAll(books);}
    }
    public List<UserBookEntity> getAll()
    {
        return (List<UserBookEntity>) userBookRepository.findAll();
    }
    public List<BookEntity> getUserBooks(UserEntity userEntity)
    {
        List<BookEntity>books=new ArrayList<>();
        getAll().forEach(el->{ if(el.getUserEntity().getId().equals(userEntity.getId())){books.add(el.getBookEntity());}});
        return books;
    }



}
