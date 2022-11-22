package com.example.project.mapper;

import com.example.project.dto.PublisherDto;
import com.example.project.entity.PublisherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PublisherMapper {
    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name")
    })
    public PublisherEntity dtoToEntity(PublisherDto dto);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name")
    })
    public PublisherDto entityToDto(PublisherEntity entity);
    public List<PublisherEntity> dtosToEntities(List<PublisherEntity> entities);
    public List<PublisherDto> entitiesToDtos(List<PublisherEntity> dtos);
}
