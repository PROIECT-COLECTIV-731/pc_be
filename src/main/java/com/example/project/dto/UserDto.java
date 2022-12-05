package com.example.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;

    private String password;

}
