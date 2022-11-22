package com.example.project.dto;


import com.example.project.entity.CategoryEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(exclude="categories")
public class BookDto {
    private int id;

    private String author;
    private String title;
    private int year;
    private String ISBN;
    private String summary;
    private String contentLink;
    private float ranking;
    private int id_domain;
    private int id_publisher;
    private List<CategoryEntity> categories;
}
