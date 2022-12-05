package com.example.project.service;
import java.util.List;

import com.example.project.dto.BookDTO;
import com.example.project.entity.BookEntity;


public interface BookService {
    public List<BookEntity> findAll();
    public BookEntity save(BookEntity book);
    public BookDTO findById(Long id);
    void delete(BookEntity book);
    void deleteAll(List<BookEntity>books);
    public BookDTO convertEntityToDTO(BookEntity book);
    public List<BookDTO> convertEntityListToDTOList(List<BookEntity> books);
    public BookEntity findBookByISBN(Long isbn);
}