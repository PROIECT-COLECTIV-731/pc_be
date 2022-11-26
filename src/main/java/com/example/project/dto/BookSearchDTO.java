package com.example.project.dto;


import com.example.project.entity.CategoryEntity;
import com.example.project.entity.DomainEntity;
import lombok.Data;

@Data
public class BookSearchDTO {

    private Long ISBN;
    private String author;
    private String title;
    private int publicationYear;
    private CategoryEntity category;
    private DomainEntity domain;
}
