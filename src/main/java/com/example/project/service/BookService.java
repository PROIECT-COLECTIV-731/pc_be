package com.example.project.service;
import java.util.List;

import com.example.project.dto.BookDto;
import com.example.project.entity.BookEntity;
import com.example.project.dto.BookDTO;

public interface BookService {
    public List<BookDto> findAll();
    public BookEntity save(BookEntity book);
    public BookDto findById(Long id);
    void delete(BookEntity book);
    void deleteAll(List<BookEntity>books);
    public BookDto convertEntityToDTO(BookEntity book);
    public List<BookDto> convertEntityListToDTOList(List<BookEntity> books);
}
