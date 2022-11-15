package com.example.project.mapper;

import com.example.project.dto.CategoryDto;
import com.example.project.entity.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface CategoryMapper {
    public CategoryEntity dtoToEntity(CategoryDto dto);
    public CategoryDto entityToDto(CategoryEntity entity);
    public List<CategoryEntity> dtosToEntities(List<CategoryEntity> entities);
    public List<CategoryDto> entitiesToDtos(List<CategoryEntity> dtos);
}
