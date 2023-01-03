package com.example.project.service;

import com.example.project.dto.BookDTO;
import com.example.project.dto.DomainDto;
import com.example.project.dto.PublisherDto;
import com.example.project.entity.*;
import com.example.project.repository.BookRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
                .publisher(convertPublisherToDTO(book.getPublisher())).
                publicationYear(book.getPublicationYear())
                .bookCategories(book.getBookCategories().stream().map(CategoryEntity::getName).toList())
                .summary(book.getSummary())
                .domain(convertDomainToDTO(book.getDomain()))
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

    @Override
    public PublisherDto convertPublisherToDTO(PublisherEntity publisherEntity) {
        return PublisherDto.builder()
                        .name(publisherEntity.getName())
                .build();
    }

    @Override
    public DomainDto convertDomainToDTO(DomainEntity domainEntity) {
        return DomainDto.builder().name(domainEntity.getName()).build();
    }


}
