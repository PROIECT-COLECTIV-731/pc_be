package com.example.project.mapper;

import com.example.project.dto.PublisherDto;
import com.example.project.entity.PublisherEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface PublisherMapper {
    public PublisherEntity dtoToEntity(PublisherDto dto);
    public PublisherDto entityToDto(PublisherEntity entity);
    public List<PublisherEntity> dtosToEntities(List<PublisherEntity> entities);
    public List<PublisherDto> entitiesToDtos(List<PublisherEntity> dtos);
}