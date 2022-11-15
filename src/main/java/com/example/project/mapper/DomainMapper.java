package com.example.project.mapper;

import com.example.project.dto.DomainDto;
import com.example.project.entity.DomainEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface DomainMapper {
    public DomainEntity dtoToEntity(DomainDto dto);
    public  DomainDto entityToDto( DomainEntity entity);
    public List<DomainEntity> dtosToEntities(List<DomainEntity> entities);
    public List<DomainDto> entitiesToDtos(List<DomainEntity> dtos);
}