package com.example.project.repository;

import com.example.project.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
    @Override
    List<CategoryEntity> findAll();

    List<CategoryEntity> findCategoryEntityByName(String name);
    CategoryEntity findCategoryEntityById(int id);
}
