package com.example.project.controller;

import com.example.project.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @PostMapping("/borrow/{book}/{user}")
    public ResponseEntity borrowBook(@PathVariable Long book, @PathVariable  Long user){
        borrowService.borrowBook(book, user);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
