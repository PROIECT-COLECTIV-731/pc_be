package com.example.project.service;

import com.example.project.entity.UserEntity;
import com.example.project.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LoginService {
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findAll() {
        return this.userRepository.findAll();
    }

    public UserEntity findByEmailAndPassword(String email, String password) {
        return this.userRepository.findByEmailAndPassword(email, password);
    }

    public String login(String email, String password){
        try {
            UserEntity userEntity = findByEmailAndPassword(email, password);
            if (userEntity != null && password.contains("@stud.ubbcluj.ro"))
                return "userAccepted";
            else if (userEntity != null && password.contains("@ubbcluj.ro")) {
                return "adminAcceoted";
            }
            return null;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
