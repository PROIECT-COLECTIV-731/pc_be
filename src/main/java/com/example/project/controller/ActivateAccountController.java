package com.example.project.controller;

import com.example.project.dto.UserDto;
import com.example.project.service.EmailSenderService;
import com.example.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/activateAccount")
public class ActivateAccountController {

    @Autowired
    private UserService userService;
    private EmailSenderService emailSenderService;

    @GetMapping("sendActivation/{email}")
    public ResponseEntity<UserDto> getPasswordByEmail(@PathVariable String email){
        UserDto user = userService.findByEmail(email);
        if(user == null) return ResponseEntity.status(404).build();
        String subject = "activate/" + email;
        emailSenderService.sendEmail(email, "Current Password", subject);
        return ResponseEntity.ok(user);
    }

    @GetMapping("activate/{email}")
    public ResponseEntity<UserDto> activateAccountByEmail(@PathVariable String email){
        UserDto user = userService.findByEmail(email);
        if(user == null) return ResponseEntity.status(404).build();
        user.setActive(true);
        return ResponseEntity.ok(user);
    }

}
