package com.example.project.service;

import com.example.project.repository.BookRepository;
import com.example.project.entity.BookEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<BookEntity> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public BookEntity save(BookEntity book){
        if (book != null)
            return bookRepository.save(book);
        return null;
    }

    @Override
    public BookEntity findByISBN(Long ISBN){
        for(BookEntity b: bookRepository.findAll()){
            if(Objects.equals(b.getISBN(), ISBN)){
                return b;
            }
        }
        return null;
    }
}
