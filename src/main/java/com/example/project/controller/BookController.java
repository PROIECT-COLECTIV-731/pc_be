package com.example.project.controller;


import com.example.project.dto.BookDTO;
import com.example.project.entity.BookEntity;
import com.example.project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/get-all")
    public ResponseEntity<List<BookEntity>> getAll() {
        return ResponseEntity.ok(this.bookService.findAll());
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> getAllDTO() {
        return ResponseEntity.ok(this.bookService.convertEntityListToDTOList(this.bookService.findAll()));
    }

    @PostMapping("/add")
    public ResponseEntity<BookEntity> saveBook(@RequestBody BookEntity book) {
        return ResponseEntity.ok(this.bookService.save(book));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> findBookById(@PathVariable Long id) {
        return ResponseEntity.ok(this.bookService.findById(id));
    }
}