package com.example.project.mapper;

import com.example.project.dto.BookDto;
import com.example.project.entity.BookEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * oriunde folosiit BookMapper puneti deasupra funtiei
 *    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
 * e necesar pt a da load la categoriile mapate prin ManyToMany
 * */
@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "id")
    public BookEntity dtoToEntity(BookDto dto);

    @InheritInverseConfiguration
    @Mapping(target="id_domain", source="entity.domainEntity.id")
    @Mapping(target="id_publisher", source="entity.publisherEntity.id")
    public BookDto entityToDto(BookEntity entity);
    public List<BookEntity> dtosToEntities(List<BookEntity> entities);
    public List<BookDto> entitiesToDtos(List<BookEntity> dtos);
}
