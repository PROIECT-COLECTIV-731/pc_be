package com.example.project.service.implementations;

import com.example.project.DatabaseMockupForTests;
import com.example.project.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DomainServiceImplTest extends DatabaseMockupForTests {

    @Autowired
    private DomainServiceImpl domainService;

    @Autowired
    private com.example.project.mapper.BookMapper BookMapper;

    @Test
    void getAllBooks() {
        assert(domainService.getAllBooks(this.domains.get(1).getId()).contains(BookMapper.entityToDto(this.books.get(1))));
        assert(domainService.getAllBooks(this.domains.get(1).getId()).contains(BookMapper.entityToDto(this.books.get(2))));
    }
}