package com.example.project.dto;


import lombok.Data;

@Data
public class ReviewDto {
    private int id;
    private int id_book;
    private int id_user;
    private String description;
    private float rating;
}
