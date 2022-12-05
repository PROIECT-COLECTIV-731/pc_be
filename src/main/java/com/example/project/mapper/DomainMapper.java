package com.example.project.mapper;

import com.example.project.dto.DomainDto;
import com.example.project.entity.DomainEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DomainMapper {
    DomainMapper INSTANCE = Mappers.getMapper(DomainMapper.class);

    @Mapping(target = "id")
    public DomainEntity dtoToEntity(DomainDto dto);

    @InheritInverseConfiguration
    public DomainDto entityToDto(DomainEntity entity);
    public List<DomainEntity> dtosToEntities(List<DomainEntity> entities);
    public List<DomainDto> entitiesToDtos(List<DomainEntity> dtos);
}
