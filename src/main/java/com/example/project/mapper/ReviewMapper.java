package com.example.project.mapper;

import com.example.project.dto.ReviewDto;
import com.example.project.entity.ReviewEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    @Mapping(target = "id")
    ReviewEntity dtoToEntity(ReviewDto dto);

    @InheritInverseConfiguration
    ReviewDto entityToDto(ReviewEntity entity);
}
