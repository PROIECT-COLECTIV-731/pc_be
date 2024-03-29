package com.example.project.controller;

import com.example.project.dto.CategoryDto;
import com.example.project.dto.DomainDto;
import com.example.project.entity.CategoryEntity;
import com.example.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody CategoryEntity category){
        if(categoryService.findPublisherByName(category.getName()) != null){
            return ResponseEntity.badRequest().body("Error! Category with name " + category.getName() + " already exists!");
        }
        return  ResponseEntity.ok(this.categoryService.addCategory(category));
    }
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok(this.categoryService.convertEntityListToDTOList(this.categoryService.findAll()));
    }

}
