package com.example.project.service.implementations;

import com.example.project.DatabaseMockupForTests;
import com.example.project.dto.BookDto;
import com.example.project.entity.BookEntity;
import com.example.project.entity.CategoryEntity;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.print.Book;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CategoryServiceImplTest extends DatabaseMockupForTests {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private com.example.project.mapper.BookMapper BookMapper;

    @Test
    void getAllBooks() {
        CategoryEntity category = this.categories.get(0);
        List<BookDto> result =  categoryService.getAllBooks(category.getId());
        assert (result.contains(BookMapper.entityToDto(this.books.get(0))));
        assert (result.contains(BookMapper.entityToDto(this.books.get(1))));
        assert (result.contains(BookMapper.entityToDto(this.books.get(2))));
    }
}