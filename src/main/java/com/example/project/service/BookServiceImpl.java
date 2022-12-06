package com.example.project.service;

import com.example.project.dto.BookSearchDTO;
import com.example.project.repository.BookRepository;
import com.example.project.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public BookSearchDTO convertToDTO(BookEntity book){
        return BookSearchDTO.builder()
                .ISBN(book.getISBN())
                .author(book.getAuthor())
                .title(book.getTitle())
                .publicationYear(book.getPublicationYear())
                .category(book.getCategory())
                .domain(book.getDomain())
                .build();
    }

    public List<BookSearchDTO> convertListToDTO(List<BookEntity> bookEntities){
        return bookEntities.stream().map(this::convertToDTO).collect(Collectors.toList());

    }

    public List<BookSearchDTO> search(String word){
        if(word == null || word.isBlank() || word.isEmpty())
            return convertListToDTO(this.bookRepository.findAll());
        List<BookSearchDTO> returnList = new ArrayList<>();


        for(BookEntity book : this.bookRepository.findAll()){
            if(book.toString().contains(word))
                returnList.add(convertToDTO(book));

        }
        return returnList;

    }
}