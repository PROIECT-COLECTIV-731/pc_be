package com.example.project.service;

import com.example.project.entity.CategoryEntity;
import com.example.project.entity.PublisherEntity;
import com.example.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryEntity addCategory(CategoryEntity category){
        return categoryRepository.save(category);
    }

    public CategoryEntity findPublisherByName(String name) {
        for (CategoryEntity c : categoryRepository.findAll()) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }
}
