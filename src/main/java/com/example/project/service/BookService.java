package com.example.project.service;

import java.util.List;

import com.example.project.dto.BookSearchDTO;
import com.example.project.entity.BookEntity;

public interface BookService {
    public List<BookEntity> findAll();
    public BookEntity save(BookEntity book);
    public List<BookSearchDTO> search(String word);
}