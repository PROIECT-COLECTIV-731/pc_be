package com.example.project.mapper;

import com.example.project.dto.UserDto;
import com.example.project.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface UserMapper {
    public UserEntity dtoToEntity(UserDto dto);
    public UserDto entityToDto(UserEntity entity);
    public List<UserEntity> dtosToEntities(List<UserEntity> entities);
    public List<UserDto> entitiesToDtos(List<UserEntity> dtos);
}