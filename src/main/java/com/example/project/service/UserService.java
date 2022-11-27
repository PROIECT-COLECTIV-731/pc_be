package com.example.project.service;

import com.example.project.dto.UserDto;
import com.example.project.entity.UserEntity;
import org.mapstruct.control.MappingControl;

import java.util.List;


public interface UserService {
    List<UserDto> findAll();

    UserDto findByEmailAndPassword(String email, String password);

    String login(String email, String password);

    boolean email_validator(UserEntity userEntity);
    boolean name_validator(UserEntity userEntity);
    boolean password_validator(UserEntity userEntity);
    UserEntity saveUser(UserEntity userEntity);

}
