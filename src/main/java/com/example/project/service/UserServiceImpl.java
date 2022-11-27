package com.example.project.service;

import com.example.project.dto.UserDto;
import com.example.project.entity.UserEntity;
import com.example.project.mapper.UserMapper;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDto> findAll() {
        return userMapper.entitiesToDtos(this.userRepository.findAll());
    }

    @Override
    public UserDto findByEmailAndPassword(String email, String password) {
        return userMapper.entityToDto(this.userRepository.findByEmailAndPassword(email, password));
    }
    @Override
    public String login(String email, String password){
        try {
            UserDto user = findByEmailAndPassword(email, password);
            if (user != null && email.contains("@stud.ubbcluj.ro"))
                return "userAccepted";
            else if (user != null && email.contains("@ubbcluj.ro")) {
                return "adminAccepted";
            }
            return null;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public boolean email_validator(UserEntity userEntity){
        return userEntity.getEmail().endsWith("@stud.ubbcluj.ro");
    }
    public boolean name_validator(UserEntity userEntity){
        return userEntity.getFirstName().length() > 0 && userEntity.getLastName().length() > 0;
    }
    public boolean password_validator(UserEntity userEntity){
        return userEntity.getPassword().length()>0;
    }
    public UserEntity saveUser(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

}
