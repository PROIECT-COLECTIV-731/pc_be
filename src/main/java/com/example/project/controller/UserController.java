package com.example.project.controller;

import com.example.project.dto.BookDTO;
import com.example.project.dto.UserDto;
import com.example.project.entity.BookEntity;
import com.example.project.service.BookService;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @GetMapping("/get-all")
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }
    @GetMapping("/getBooks")
    public ResponseEntity<List<BookDTO>> getBooks(@RequestParam String username) {
            List<BookEntity>userBooks=userService.getUserBooks(username);
            List<BookDTO>books=bookService.bookList(userBooks);
            if(books.size()>0)
                return ResponseEntity.ok().body(books);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}
