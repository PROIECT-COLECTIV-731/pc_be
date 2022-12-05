package com.example.project.mapper;

import com.example.project.dto.BookDto;
import com.example.project.entity.BookEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface BookMapper {
    public BookEntity dtoToEntity(BookDto dto);
    public BookDto entityToDto(BookEntity entity);
    public List<BookEntity> dtosToEntities(List<BookEntity> entities);
    public List<BookDto> entitiesToDtos(List<BookEntity> dtos);
}