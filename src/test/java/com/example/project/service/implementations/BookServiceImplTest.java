package com.example.project.service.implementations;

import com.example.project.DatabaseMockupForTests;
import com.example.project.dto.BookDto;
import com.example.project.dto.CategoryDto;
import com.example.project.entity.BookEntity;
import com.example.project.entity.CategoryEntity;
import com.example.project.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceImplTest extends DatabaseMockupForTests {

    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private com.example.project.mapper.CategoryMapper CategoryMapper;

    @Test
    void getAllCategories() {
        BookEntity book = this.books.get(0);
        List<CategoryDto> result =  bookService.getAllCategories(book.getId());
        assert (result.contains(CategoryMapper.entityToDto(this.categories.get(0))));
    }

    @Test
    void findBookEntityByDomain() {
        List<BookDto> result = this.bookService.findBookEntityByDomainEntity(this.domains.get(1).getId());
        assert (result.contains(BookMapper.INSTANCE.entityToDto(this.books.get(1))));
        assert (result.contains(BookMapper.INSTANCE.entityToDto(this.books.get(2))));
    }

    @Test
    void findBookEntityByPublisher() {
        List<BookDto> result = this.bookService.findBookEntityByPublisherEntity(this.publishers.get(0).getId());
        assert (result.contains(BookMapper.INSTANCE.entityToDto(this.books.get(0))));
        assert (result.contains(BookMapper.INSTANCE.entityToDto(this.books.get(1))));
        assert (result.contains(BookMapper.INSTANCE.entityToDto(this.books.get(2))));
    }
}