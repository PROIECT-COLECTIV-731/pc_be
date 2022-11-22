package com.example.project.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class BorrowDto {
    int id_book;
    int id_user;
    Date borrowTime;
}
