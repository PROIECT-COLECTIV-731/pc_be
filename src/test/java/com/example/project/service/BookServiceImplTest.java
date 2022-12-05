package com.example.project.service;

import com.example.project.dto.BookDto;
import com.example.project.entity.BookEntity;
import com.example.project.entity.CategoryEntity;
import com.example.project.entity.DomainEntity;
import com.example.project.entity.PublisherEntity;
import com.example.project.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {
    @Mock
    BookRepository testBookRepository;
    BookEntity firstEntity;
    BookEntity secondEntity;
    CategoryEntity firstCategory;
    DomainEntity firstDomain;
    PublisherEntity firstPublisher;

    private BookService testService;


    @BeforeEach
    public void setup() {
        firstPublisher = new PublisherEntity(1L,"SomePublisher", List.of());
        firstDomain = new DomainEntity(1L, "SomeDomain", List.of());
        firstCategory = new CategoryEntity((1L), "SomeCategory", List.of());

        firstEntity = new BookEntity(1L, 12345L, "First author", "Huba Buba",
                2012, firstDomain, firstPublisher, List.of(), "Description", 7.75F);
        secondEntity = new BookEntity(2L, 4534L, "Second author", "Buba Huba",
                2010, firstDomain, firstPublisher, List.of(), "Different description", 9.75F);

        this.testService = new BookServiceImpl(testBookRepository);
    }

    @Test
    void findById() {
        when(testBookRepository.findById(firstEntity.getId())).thenReturn(Optional.of(firstEntity));

        final BookDto result =testService.findById(1L);

        assertEquals(result.getISBN(), firstEntity.getISBN());

        when(testBookRepository.findById(secondEntity.getId())).thenReturn(Optional.of(secondEntity));

        final BookDto secondResult =testService.findById(2L);

        assertEquals(secondResult.getISBN(), secondEntity.getISBN());

    }
}