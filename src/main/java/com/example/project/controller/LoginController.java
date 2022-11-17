package com.example.project.controller;

import com.example.project.entity.UserEntity;
import com.example.project.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class LoginController {
    @Autowired
    private LoginService loginService;
    @GetMapping("/get-all")
    public ResponseEntity<List<UserEntity>> getAll() {
        return ResponseEntity.ok(this.loginService.findAll());
    }

    @GetMapping("/{email}/{password}")
    public ResponseEntity<UserEntity> findUserByEmailAndPassword(@PathVariable String email, String password) {
        return ResponseEntity.ok(this.loginService.findByEmailAndPassword(email, password));
    }

    @PostMapping("/user")
    public String login(@RequestBody String email, String password){return loginService.login(email, password);}


}
