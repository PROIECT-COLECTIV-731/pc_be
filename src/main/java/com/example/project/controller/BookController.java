package com.example.project.controller;

import com.example.project.dto.BookSearchDTO;
import com.example.project.entity.BookEntity;
import com.example.project.entity.CategoryEntity;
import com.example.project.entity.DomainEntity;
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
    public ResponseEntity<BookEntity> saveBook(@RequestBody BookEntity book) {
        return ResponseEntity.ok(this.bookService.save(book));
    }

    @GetMapping("/search")
    public BookSearchDTO searchBook(@RequestParam String author, String title, int year, Long isbn, CategoryEntity categorie, DomainEntity domain){
        return this.bookService.search(author,title,year,isbn,categorie, domain);
    }
}