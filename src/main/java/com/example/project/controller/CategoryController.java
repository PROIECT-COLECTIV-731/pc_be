package com.example.project.controller;

import com.example.project.entity.CategoryEntity;
import com.example.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<CategoryEntity> addCategory(@RequestBody CategoryEntity category){
        return  ResponseEntity.ok(this.categoryService.addCategory(category));
    }
}
