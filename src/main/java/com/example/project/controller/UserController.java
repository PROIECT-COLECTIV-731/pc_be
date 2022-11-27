package com.example.project.controller;

import com.example.project.dto.UserDto;
import com.example.project.entity.UserEntity;
import com.example.project.service.UserService;
import com.example.project.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get-all")
    public ResponseEntity<List<UserDto>> getAllUser() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{email}/{password}")
    public ResponseEntity<UserDto> findUserByEmailAndPassword(@PathVariable String email, String password) {
        return ResponseEntity.ok(this.userService.findByEmailAndPassword(email, password));
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody String email, String password)
    {return ResponseEntity.ok(userService.login(email, password));}

    @PostMapping(value = "/save")
    public UserEntity saveUsers(@RequestBody UserEntity userEntity) {
        if(userService.email_validator(userEntity) && userService.name_validator(userEntity) && userService.password_validator(userEntity)){
            UserEntity user = new UserEntity();
            user.setEmail(userEntity.getEmail());
            user.setPassword(userEntity.getPassword());
            user.setFirstName(userEntity.getFirstName());
            user.setLastName(userEntity.getLastName());
            user.setId(userEntity.getId());
            return userService.saveUser(user);
        }
        return null;
    }
}
