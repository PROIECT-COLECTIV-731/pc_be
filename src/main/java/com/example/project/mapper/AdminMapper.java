package com.example.project.mapper;

import com.example.project.dto.AdminDto;
import com.example.project.entity.AdminEntity;
import com.example.project.service.AdminService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "email", target="email"),
            @Mapping(source = "password", target="password")
    })
    public AdminEntity dtoToEntity(AdminDto dto);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "email", target ="email"),
            @Mapping(source = "password", target="password")
    })
    public AdminDto entityToDto(AdminEntity entity);
    public List<AdminEntity> dtosToEntities(List<AdminEntity> entities);
    public List<AdminDto> entitiesToDtos(List<AdminEntity> dtos);
}
