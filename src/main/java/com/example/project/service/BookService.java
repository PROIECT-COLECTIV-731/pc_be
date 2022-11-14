package com.example.project.service;
import java.util.List;

import com.example.project.dto.BookDTO;
import com.example.project.entity.BookEntity;

public interface BookService {
    public List<BookEntity> findAll();
    public BookEntity save(BookEntity book);
    public BookDTO convertEntityToDTO(BookEntity book);

    public List<BookDTO> bookList(List<BookEntity> books);
}