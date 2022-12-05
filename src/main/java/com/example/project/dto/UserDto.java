package com.example.project.dto;

import com.example.project.entity.BookEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(exclude={"borrowed"})
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private List<BookEntity> borrowed;
}
