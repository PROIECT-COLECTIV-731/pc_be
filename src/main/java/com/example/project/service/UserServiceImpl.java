package com.example.project.service;

import com.example.project.dto.UserDto;
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
}
