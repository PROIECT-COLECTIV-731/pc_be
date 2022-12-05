package com.example.project.service.implementations;

import com.example.project.DatabaseMockupForTests;
import com.example.project.dto.UserDto;
import com.example.project.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest extends DatabaseMockupForTests {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private com.example.project.mapper.UserMapper UserMapper;

    @Test
    void findAll() {
        List<UserDto> userList = this.userService.findAll();

        assertEquals(userList.size(),3);
        assertTrue(userList.contains(UserMapper.INSTANCE.entityToDto(this.users.get(0))));
        assertTrue(userList.contains(UserMapper.INSTANCE.entityToDto(this.users.get(1))));
        assertTrue(userList.contains(UserMapper.INSTANCE.entityToDto(this.users.get(2))));
    }

    @Test
    void findByEmailAndPassword() {
        UserDto user = this.userService.findByEmailAndPassword("email@example.com","pass");

        assertEquals(user, UserMapper.INSTANCE.entityToDto(this.users.get(0)));
    }

    @Test
    void login_with_user_email() {
        String pass = this.userService.login("email@stud.ubbcluj.ro","passUser");

        assertEquals(pass,"userAccepted");
    }

    @Test
    void login_with_admin_email() {
        String pass = this.userService.login("email@ubbcluj.ro","passAdmin");

        assertEquals(pass,"adminAccepted");
    }

    @Test
    void login_without_appropriate_email() {
        String pass = this.userService.login("email@example.com","pass");

        assertNull(pass);
    }
}