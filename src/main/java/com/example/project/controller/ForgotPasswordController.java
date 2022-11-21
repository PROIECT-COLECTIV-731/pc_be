package com.example.project.controller;
import com.example.project.dto.UserDto;
import com.example.project.entity.UserEntity;
import com.example.project.repository.UserRepository;
import com.example.project.service.EmailSenderService;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/forgotPassword")
public class ForgotPasswordController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmailSenderService emailSenderService;

    @GetMapping("/{email}")
    public UserDto getPasswordByEmail(@PathVariable String email){
        emailSenderService.sendEmail(email, "Current Password", userService.findByEmail(email).getPassword());
        return userService.findByEmail(email);
    }

}