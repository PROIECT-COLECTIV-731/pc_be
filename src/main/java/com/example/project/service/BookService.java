package com.example.project.service;

import java.util.List;

import com.example.project.dto.BookSearchDTO;
import com.example.project.entity.BookEntity;
import com.example.project.entity.CategoryEntity;
import com.example.project.entity.DomainEntity;

public interface BookService {
    public List<BookEntity> findAll();
    public BookEntity save(BookEntity book);
    public BookSearchDTO search(String author, String title, int year, Long isbn, CategoryEntity categorie, DomainEntity domain);
}