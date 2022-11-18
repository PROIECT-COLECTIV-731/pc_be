package com.example.project.controller;

import com.example.project.dto.UserDto;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get-all")
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{email}/{password}")
    public ResponseEntity<UserDto> findUserByEmailAndPassword(@PathVariable String email, String password) {
        return ResponseEntity.ok(this.userService.findByEmailAndPassword(email, password));
    }
    @PostMapping("/user")
    public String login(@RequestBody String email, String password){return userService.login(email, password);}

}
