package com.example.project.dto;


import com.example.project.entity.BookEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(exclude="books")
public class CategoryDto {
    private int id;
    private String name;
    private List<BookEntity> books;
}
