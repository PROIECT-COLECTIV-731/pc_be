package com.example.project.service.implementations;

import com.example.project.dto.BookDto;
import com.example.project.dto.CategoryDto;
import com.example.project.mapper.BookMapper;
import com.example.project.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private com.example.project.repository.CategoryRepository CategoryRepository;
    @Autowired
    private com.example.project.mapper.CategoryMapper CategoryMapper;
    @Autowired
    private com.example.project.mapper.BookMapper BookMapper;

    @Override
    public List<CategoryDto> findAll() {
        return CategoryMapper.entitiesToDtos(this.CategoryRepository.findAll());
    }

    @Override
    public List<CategoryDto> findCategoryEntityByName(String name) {
        return CategoryMapper.entitiesToDtos(this.CategoryRepository.findCategoryEntityByName(name));
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public List<BookDto> getAllBooks(int id_category) {
        return BookMapper.entitiesToDtos(this.CategoryRepository.findCategoryEntityById(id_category).getBooks());
    }
}
