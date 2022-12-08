package com.example.project.service;
import java.awt.print.Book;
import java.util.List;
import java.util.Map;

import com.example.project.dto.BookDTO;
import com.example.project.entity.BookEntity;

public interface BookService {
    public List<BookEntity> findAll();
    public BookEntity save(BookEntity book);
     void delete(BookEntity book);
     void deleteAll(List<BookEntity>books);
    public BookDTO convertEntityToDTO(BookEntity book);
    public List<BookDTO> convertEntityListToDTOList(List<BookEntity> books);
    public BookEntity findBookByISBN(Long isbn);
    List<String> sortBookTitlesAlphabetical();
    Map<String,String> countUsersForAllBooks();
}