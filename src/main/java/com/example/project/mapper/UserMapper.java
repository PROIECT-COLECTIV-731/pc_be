package com.example.project.mapper;

import com.example.project.dto.UserDto;
import com.example.project.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id")
    public UserEntity dtoToEntity(UserDto dto);

    @InheritInverseConfiguration
    public UserDto entityToDto(UserEntity entity);
    public List<UserEntity> dtosToEntities(List<UserEntity> entities);
    public List<UserDto> entitiesToDtos(List<UserEntity> dtos);
}
