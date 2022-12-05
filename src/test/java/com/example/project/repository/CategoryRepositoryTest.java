package com.example.project.repository;

import com.example.project.DatabaseMockupForTests;
import com.example.project.entity.CategoryEntity;
import com.example.project.entity.DomainEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CategoryRepositoryTest extends DatabaseMockupForTests {

    @Test
    void findAll() {
        assert (this.categories.equals(this.categoryRepository.findAll()));
    }

    @Test
    void findCategoryEntityByName() {
        List<CategoryEntity> result = this.categoryRepository.findCategoryEntityByName("General");
        assert (result.contains(this.categories.get(0)));
    }

    @Test
    void findCategoryEntityById() {
        CategoryEntity result = this.categoryRepository.findCategoryEntityById(this.categories.get(0).getId());
        assert (this.categories.get(0).equals(result));
    }
}