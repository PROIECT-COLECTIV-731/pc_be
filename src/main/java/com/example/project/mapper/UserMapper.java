package com.example.project.mapper;

import com.example.project.dto.UserDto;
import com.example.project.entity.UserEntity;
import com.example.project.service.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel="spring")
@Component
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "email", target="email"),
            @Mapping(source = "password", target="password"),
            @Mapping(source = "permission", target="permission")
    })
    public UserEntity dtoToEntity(UserDto dto);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "email", target ="email"),
            @Mapping(source = "password", target="password"),
            @Mapping(source = "permission", target="permission")
    })
    public UserDto entityToDto(UserEntity entity);
    public List<UserEntity> dtosToEntities(List<UserEntity> entities);
    public List<UserDto> entitiesToDtos(List<UserEntity> dtos);

}