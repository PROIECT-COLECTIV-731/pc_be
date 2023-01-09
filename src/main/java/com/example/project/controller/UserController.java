package com.example.project.controller;

import com.example.project.dto.BookDTO;
import com.example.project.dto.RegisterRequestDto;
import com.example.project.dto.RegisterResponseDto;
import com.example.project.dto.UserDto;
import com.example.project.entity.UserEntity;
import com.example.project.entity.BookEntity;
import com.example.project.entity.ResponseForUserBooks;
import com.example.project.entity.UserBookEntity;
import com.example.project.entity.UserEntity;
import com.example.project.service.BookService;
import com.example.project.service.UserBookService;
import com.example.project.service.UserService;
import com.example.project.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<UserDto>> getAllUser() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/books")
    public ResponseEntity<ResponseForUserBooks> getBooks(@RequestParam String username) {
            List<UserBookEntity>expiredBooks=userService.getExpiredBooks(username);
            userBookService.deleteUserBooks(expiredBooks);
            UserEntity foundUser=userService.findUserByUserName(username);
            if(foundUser!=null){
            List<BookDTO>books=bookService.convertEntityListToDTOList(userBookService.getUserBooks(foundUser));
            if(books.size()>0){
                List<String>expiredTitles=new ArrayList<>();
                expiredBooks.forEach(book->expiredTitles.add(book.getBookEntity().getTitle()));
                return ResponseEntity.ok().body(new ResponseForUserBooks(books,expiredTitles,"Updated List"));
            }
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/{email}/{password}")
    public ResponseEntity<UserDto> findUserByEmailAndPassword(@PathVariable String email, String password) {
        return ResponseEntity.ok(this.userService.findByEmailAndPassword(email, password));
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody String email, String password)
    {return ResponseEntity.ok(userService.login(email, password));}


//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestBody String email, String password)
//    {return ResponseEntity.ok(userService.login(email, password));}

    @PostMapping(value = "/register")
    public ResponseEntity<RegisterResponseDto> registerUser(@RequestBody RegisterRequestDto dto) {
        try{
            return new ResponseEntity<>(userService.saveUser(dto),HttpStatus.OK);
        }
        catch (Exception e) {
            return ResponseEntity.status(409).build();
        }
    }
}
