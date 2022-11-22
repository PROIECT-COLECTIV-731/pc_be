package com.example.project.mapper;

import com.example.project.dto.CategoryDto;
import com.example.project.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "books", target = "books")
    })
    public CategoryEntity dtoToEntity(CategoryDto dto);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "books", target = "books")
    })
    public CategoryDto entityToDto(CategoryEntity entity);
    public List<CategoryEntity> dtosToEntities(List<CategoryEntity> entities);
    public List<CategoryDto> entitiesToDtos(List<CategoryEntity> dtos);
}
