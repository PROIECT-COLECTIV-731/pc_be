package com.example.project.controller;

import com.example.project.entity.BookEntity;
import com.example.project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity saveBook(@RequestBody BookEntity book) {
        if (bookService.findByISBN(book.getISBN()) != null)
            return ResponseEntity.badRequest().body("Error! Book with ISBN " + book.getISBN() + " already exists!");
        return ResponseEntity.ok(this.bookService.save(book));
    }
}
