package com.example.project.service.implementations;

import com.example.project.dto.UserDto;
import com.example.project.entity.BookEntity;
import com.example.project.entity.UserEntity;
import com.example.project.mapper.UserMapper;
import com.example.project.repository.BookRepository;
import com.example.project.repository.UserRepository;
import com.example.project.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public List<UserDto> findAll() {
        return userMapper.entitiesToDtos(this.userRepository.findAll());
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public UserDto findByEmailAndPassword(String email, String password) {
        return userMapper.entityToDto(this.userRepository.findByEmailAndPassword(email, password));
    }
    @Override
    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
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
            return null;
        }
    }
}
