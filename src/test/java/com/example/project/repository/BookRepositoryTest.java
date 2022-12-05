package com.example.project.repository;

import com.example.project.DatabaseMockupForTests;
import com.example.project.entity.BookEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BookRepositoryTest extends DatabaseMockupForTests {

    @Test
    void findAllBooks() {
        assert(this.bookRepository.findAll().size() == 3);
    }

    @Test
    void findBookEntityByTitle() {
        assert(this.books.get(2).equals(this.bookRepository.findBookEntityByTitle("Das Parfum").get(0)));
    }

    @Test
    void findBookEntityByAuthor() {
        assert(this.books.get(2).equals(this.bookRepository.findBookEntityByAuthor("Patrick Suskind").get(0)));
    }

    @Test
    void findBookEntityByTitleAndAuthor() {
        assert(this.books.get(2).equals(this.bookRepository.findBookEntityByTitleAndAuthor("Das Parfum","Patrick Suskind").get(0)));
    }

    @Test
    void findBookEntityByISBN() {
        assert(this.books.get(2).equals(this.bookRepository.findBookEntityByISBN("9783257228007")));
    }
}