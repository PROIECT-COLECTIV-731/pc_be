package com.example.project.controller;
 c
import com.example.project.entity.UserEntity;
import com.example.project.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/forgotPassword")
public class ForgotPasswordController {

    private UserRepository repository;

    @GetMapping("/email")
    public UserEntity getPasswordByEmail(@PathVariable Long email){
        return repository.findUserById(email);
    }

}