package com.example.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ResponseBody
@RequestMapping("/forgotPassword")
public class ForgotPasswordController {

    private UserRepository repository;

    @GetMapping("/email")
    public User getPasswordByEmail(@PathVariable string email){
        return repository.findById(id);
    }

}