package com.example.project.service;

import com.example.project.entity.CategoryEntity;
import com.example.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryEntity addCategory(CategoryEntity category){
        return categoryRepository.save(category);
    }
}
