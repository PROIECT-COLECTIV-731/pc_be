package com.example.project.service.interfaces;

import com.example.project.dto.BookDto;
import com.example.project.dto.CategoryDto;
import com.example.project.entity.BookEntity;
import com.example.project.entity.DomainEntity;
import com.example.project.entity.PublisherEntity;

import java.util.List;

public interface BookService {
    List<BookDto> findAll();

    List<BookDto> findBookEntityByTitleAndAuthor(String author, String title);

    BookDto findBookEntityByISBN(String isbn);

    List<CategoryDto> getAllCategories(int id_book);

    List<BookDto> findBookEntityByDomainEntity(int id_domain);

    List<BookDto> findBookEntityByPublisherEntity(int id_publisher);
}
