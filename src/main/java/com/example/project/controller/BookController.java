package com.example.project.controller;


import com.example.project.dto.BookDTO;
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
    public ResponseEntity saveBook(@RequestBody BookEntity book) {
        if (bookService.findByISBN(book.getISBN()) != null)
            return ResponseEntity.badRequest().body("Error! Book with ISBN " + book.getISBN() + " already exists!");
        return ResponseEntity.ok(this.bookService.save(book));
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/getBooksWithUsersNr")
    public Map<String,String> getBorrowNrForBooks() {
        return bookService.countUsersForAllBooks();
    }


    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> findBookById(@PathVariable Long id) {
        return ResponseEntity.ok(this.bookService.findById(id));
    }
}