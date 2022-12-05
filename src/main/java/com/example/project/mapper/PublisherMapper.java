package com.example.project.mapper;

import com.example.project.dto.PublisherDto;
import com.example.project.entity.PublisherEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PublisherMapper {
    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    @Mapping(target = "id")
    public PublisherEntity dtoToEntity(PublisherDto dto);

    @InheritInverseConfiguration
    public PublisherDto entityToDto(PublisherEntity entity);
    public List<PublisherEntity> dtosToEntities(List<PublisherEntity> entities);
    public List<PublisherDto> entitiesToDtos(List<PublisherEntity> dtos);
}
