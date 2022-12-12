package com.example.project.service;

import com.example.project.dto.BookDTO;
import com.example.project.entity.BookEntity;
import com.example.project.repository.BookRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public void delete(BookEntity book) {
        if(book!=null)
        {
            bookRepository.delete(book);
        }
    }
    @Override
    public void deleteAll(List<BookEntity> books) {
        if(books.size()>0)
        {
            books.forEach(this::delete);
        }
    }

    @Override
    public BookDTO findById(Long id) {
        return this.convertEntityToDTO(this.bookRepository.findById(id).orElse(null));
    }

    @Override
    public BookDTO convertEntityToDTO(BookEntity book) {
        List<String>categories=new ArrayList<>();
        book.getBookCategories().forEach(categoryEntity -> categories.add(categoryEntity.getName()));
        return BookDTO.builder().
                ISBN(book.getISBN()).
                author(book.getAuthor()).
                title(book.getTitle()).
                ranking(book.getRanking())
                .publisher(book.getPublisher().getName()).
                publicationYear(book.getPublicationYear()).
                bookCategories(categories)
                .domain(book.getDomain().getName())
                .contentLink(book.getContentLink())
                .build();
    }

    @Override
    public List<BookDTO> convertEntityListToDTOList(List<BookEntity> books) {
        List<BookDTO>boookList=new ArrayList<>();
        if(books!=null){
            books.forEach(bookEntity -> boookList.add(convertEntityToDTO(bookEntity)));
        }
        return boookList;
    }

    @Override
    public BookEntity findBookByISBN(Long isbn) {

       return bookRepository.findAll().stream().filter(bookEntity -> bookEntity.getISBN().equals(isbn)).findFirst().orElse(null);

    }



}
