package com.example.project.service;
import java.util.List;

import com.example.project.dto.BookDto;
import com.example.project.entity.BookEntity;

public interface BookService {
    public List<BookDto> findAll();
    public BookEntity save(BookEntity book);
    public BookDto findById(Long id);
    public BookDto convertEntityToDTO(BookEntity book);
}
