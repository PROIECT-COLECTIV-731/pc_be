package com.example.project.mapper;

import com.example.project.dto.CategoryDto;
import com.example.project.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(target = "id")
    public CategoryEntity dtoToEntity(CategoryDto dto);

    @InheritInverseConfiguration
    public CategoryDto entityToDto(CategoryEntity entity);
    public List<CategoryEntity> dtosToEntities(List<CategoryEntity> entities);
    public List<CategoryDto> entitiesToDtos(List<CategoryEntity> dtos);
}
