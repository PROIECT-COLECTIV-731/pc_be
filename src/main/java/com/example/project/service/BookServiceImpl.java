package com.example.project.service;

import com.example.project.dto.BookDto;
import com.example.project.repository.BookRepository;
import com.example.project.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDto> findAll() {
        List<BookDto>allBooksDTO=new ArrayList<>();
        this.bookRepository.findAll().forEach(book -> allBooksDTO.add(this.convertEntityToDTO(book)));
        return allBooksDTO;
    }

    @Override
    public BookEntity save(BookEntity book){
        if (book != null)
            return bookRepository.save(book);
        return null;
    }

    @Override
    public BookDto findById(Long id) {
        return this.convertEntityToDTO(this.bookRepository.findById(id).orElse(null));
    }

    @Override
    public BookDto convertEntityToDTO(BookEntity book) {
        List<String>categories=new ArrayList<>();
        book.getBookCategories().forEach(categoryEntity -> categories.add(categoryEntity.getName()));
        return BookDto.builder().
                ISBN(book.getISBN()).
                author(book.getAuthor()).
                title(book.getTitle()).
                ranking(book.getRanking())
                .publisher(book.getPublisher().getName()).
                publicationYear(book.getPublicationYear()).
                bookCategories(categories)
                .summary(book.getSummary())
                .domain(book.getDomain().getName())
                .build();
    }
}
