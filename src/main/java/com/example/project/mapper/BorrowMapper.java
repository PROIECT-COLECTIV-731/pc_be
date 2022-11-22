package com.example.project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BorrowMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

}
