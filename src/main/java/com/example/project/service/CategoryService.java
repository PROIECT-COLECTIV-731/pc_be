package com.example.project.service;

import com.example.project.dto.CategoryDto;
import com.example.project.dto.DomainDto;
import com.example.project.dto.PublisherDto;
import com.example.project.entity.CategoryEntity;
import com.example.project.entity.DomainEntity;
import com.example.project.entity.PublisherEntity;
import com.example.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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

    public CategoryDto convertCategoryToDTO(CategoryEntity categoryEntity) {
        return CategoryDto.builder().name(categoryEntity.getName()).build();
    }
    public List<CategoryDto> convertEntityListToDTOList(List<CategoryEntity> categories) {
        List<CategoryDto> categoriesList = new ArrayList<>();
        if (categories != null) {
            categories.forEach(categoryEntity -> categoriesList.add(convertCategoryToDTO(categoryEntity)));
        }
        return categoriesList;
    }

    public List<CategoryEntity> findAll() {
        return this.categoryRepository.findAll();
    }
}
