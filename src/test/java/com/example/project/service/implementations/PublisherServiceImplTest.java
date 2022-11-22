package com.example.project.service.implementations;

import com.example.project.DatabaseMockupForTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class PublisherServiceImplTest extends DatabaseMockupForTests {

    @Autowired
    private PublisherServiceImpl publisherService;

    @Autowired
    private com.example.project.mapper.BookMapper BookMapper;

    @Test
    void getAllBooks() {
        assert(publisherService.getAllBooks(this.publishers.get(0).getId()).contains(BookMapper.entityToDto(this.books.get(0))));
        assert(publisherService.getAllBooks(this.publishers.get(0).getId()).contains(BookMapper.entityToDto(this.books.get(1))));
        assert(publisherService.getAllBooks(this.publishers.get(0).getId()).contains(BookMapper.entityToDto(this.books.get(2))));
    }
}