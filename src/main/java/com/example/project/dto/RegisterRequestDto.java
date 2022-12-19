package com.example.project.dto;

import lombok.Data;

@Data
public class RegisterRequestDto {


    //email will be username
    private String email;

    private String password;

}
