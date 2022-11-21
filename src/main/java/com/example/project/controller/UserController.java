package com.example.project.controller;

import com.example.project.dto.BookDTO;
import com.example.project.dto.UserDto;
import com.example.project.entity.BookEntity;
import com.example.project.entity.UserBookEntity;
import com.example.project.entity.UserEntity;
import com.example.project.service.BookService;
import com.example.project.service.UserBookService;
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
    private UserBookService userBookService;
    @Autowired
    private BookService bookService;

    @GetMapping("/get-all")
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }
    
    //gets the books of a user and deleted the expired ones
    @GetMapping("/user-books")
    public ResponseEntity<List<BookDTO>> getBooks(@RequestParam String username) {
            List<UserBookEntity>expiredBooks=userService.getExpiredBooks(username);
            userBookService.deleteUserBooks(expiredBooks);
            UserEntity foundUser=userService.findUserByUserName(username);
            if(foundUser!=null){
            List<BookDTO>books=bookService.convertEntityListToDTOList(userBookService.getUserBooks(foundUser));
            if(books.size()>0)
                return ResponseEntity.ok().body(books);}
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}
