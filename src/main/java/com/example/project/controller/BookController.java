package com.example.project.controller;


import com.example.project.dto.BookSearchDTO;
import com.example.project.entity.CategoryEntity;
import com.example.project.entity.DomainEntity;

import com.example.project.dto.BookDTO;
import com.example.project.entity.BookEntity;

import com.example.project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @GetMapping("/search")
    public List<BookSearchDTO> searchBook(@RequestParam String word) {
        return this.bookService.search(word);
    }

    @PostMapping("/add")
    public ResponseEntity saveBook(@RequestBody BookDTO book) {
        BookEntity bookEntity=bookService.findByISBN(book.getISBN());
        if (bookEntity!=null)
            return ResponseEntity.badRequest().body("Error! Book with ISBN " + book.getISBN() + " already exists!");
        BookEntity foundBook;
        try{foundBook=this.bookService.save(bookService.convertDTOToEntity(book));}
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        return ResponseEntity.ok(foundBook);
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

    @PostMapping("/update")
    public ResponseEntity updateBook(@RequestBody BookDTO dto) {
        BookEntity book;
        try {
           book=bookService.update(dto);
        } catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        if(book!=null)
        {return ResponseEntity.ok(book);}
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book could not be found");
    }
}