package com.example.project.controller;
import com.example.project.dto.UserDto;
import com.example.project.entity.UserEntity;
import com.example.project.repository.UserRepository;
import com.example.project.service.EmailSenderService;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@CrossOrigin(origins="*")
@RequestMapping("/forgotPassword")
public class ForgotPasswordController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmailSenderService emailSenderService;

    @GetMapping("/{email}")
    public ResponseEntity<UserDto> getPasswordByEmail(@PathVariable String email){
        UserDto user = userService.findByEmail(email);
        if(user == null) return ResponseEntity.status(404).build();
        emailSenderService.sendEmail(email, "Current Password", user.getPassword());
        return ResponseEntity.ok(user);
    }

}