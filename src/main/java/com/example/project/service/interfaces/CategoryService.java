package com.example.project.service.interfaces;

import com.example.project.dto.BookDto;
import com.example.project.dto.CategoryDto;
import com.example.project.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();

    List<CategoryDto> findCategoryEntityByName(String name);

    List<BookDto> getAllBooks(int id_category);
}
