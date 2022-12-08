package com.example.project.controller;

import com.example.project.entity.BookEntity;
import com.example.project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/get-all")
    public ResponseEntity<List<BookEntity>> getAll() {
        return ResponseEntity.ok(this.bookService.findAll());
    }
    @PostMapping("/add")
    public ResponseEntity<BookEntity> saveBook(@RequestBody BookEntity book) {
        return ResponseEntity.ok(this.bookService.save(book));
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/getBooksWithUsersNr")
    public Map<String,String> getBorrowNrForBooks() {
        Map<String,String>m=bookService.countUsersForAllBooks();
        m.forEach((key, value) -> System.out.println(key + ":" + value));
        return bookService.countUsersForAllBooks();
    }


}