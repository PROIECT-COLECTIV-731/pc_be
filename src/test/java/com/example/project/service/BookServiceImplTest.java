package com.example.project.service;

import com.example.project.dto.BookDTO;
import com.example.project.entity.*;
import com.example.project.repository.BookRepository;
import com.example.project.repository.UserBookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {
    @Mock
    BookRepository testBookRepository;

    @Mock
    UserBookRepository testUserBookRepository;
    BookEntity firstEntity;
    BookEntity secondEntity;
    CategoryEntity firstCategory;
    DomainEntity firstDomain;
    PublisherEntity firstPublisher;

    UserEntity firstUserEntity;

    UserEntity secondUserEntity;

    UserBookEntity firstUserBookEntity;

    UserBookEntity secondUserBookEntity;

    UserBookEntity thirdUserBookEntity;

    Iterable<UserBookEntity> listUserBook;

    Map<String,String> bookUserPairs;

    List<BookEntity> books;

    private BookService testService;


    @BeforeEach
    public void setup() {
        firstPublisher = new PublisherEntity(1L,"SomePublisher", List.of());
        firstDomain = new DomainEntity(1L, "SomeDomain", List.of());
        firstCategory = new CategoryEntity((1L), "SomeCategory", List.of());

        LocalDate date1 = LocalDate.of(2022, 12, 13);
        LocalDate date2 = LocalDate.of(2022, 12, 17);

        firstEntity = new BookEntity(1L, 12345L, "First author", "Huba",
                2012, "someLink", firstDomain, firstPublisher, List.of(), "Description", 7.75F, List.of());
        secondEntity = new BookEntity(2L, 4534L, "Second author", "Buba",
                2010, "someOtherLink", firstDomain, firstPublisher, List.of(), "Different description", 9.75F, List.of());

        firstUserEntity = new UserEntity(1L, "John", "Johnston", "john.don@ubbcluj.ro",
                "1234","someName", List.of(), List.of());

        secondUserEntity = new UserEntity(2L, "Some", "Guy", "some.guy@ubbcluj.ro",
                "1234","someName", List.of(), List.of());

        firstUserBookEntity = new UserBookEntity(new UserBookID(),firstUserEntity, firstEntity, date1);
        secondUserBookEntity = new UserBookEntity(new UserBookID(),firstUserEntity, secondEntity, date1);
        thirdUserBookEntity = new UserBookEntity(new UserBookID(),secondUserEntity, secondEntity, date2);

       listUserBook = List.of(firstUserBookEntity, secondUserBookEntity, thirdUserBookEntity);

       books = List.of(firstEntity, secondEntity);

       bookUserPairs = new LinkedHashMap<>();

       bookUserPairs.put("Buba", "2");
       bookUserPairs.put("Huba", "1");

        this.testService = new BookServiceImpl(testBookRepository, testUserBookRepository);
    }

    @Test
    void findById() {
        when(testBookRepository.findById(firstEntity.getId())).thenReturn(Optional.of(firstEntity));

        final BookDTO result =testService.findById(1L);

        assertEquals(result.getISBN(), firstEntity.getISBN());

        when(testBookRepository.findById(secondEntity.getId())).thenReturn(Optional.of(secondEntity));

        final BookDTO secondResult =testService.findById(2L);

        assertEquals(secondResult.getISBN(), secondEntity.getISBN());

    }


    @Test
    void countUsersForAllBooks() {

       when(testUserBookRepository.findAll()).thenReturn(listUserBook);

        when(testBookRepository.findAll()).thenReturn(books);

        Map<String, String> mapResult = testService.countUsersForAllBooks();


        assertEquals(mapResult.get("Buba"), bookUserPairs.get("Buba"));
        assertEquals(mapResult.get("Huba"), bookUserPairs.get("Huba"));

        assertEquals(mapResult, bookUserPairs);


    }

}
