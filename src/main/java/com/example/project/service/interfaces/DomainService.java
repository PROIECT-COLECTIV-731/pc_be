package com.example.project.service.interfaces;

import com.example.project.dto.BookDto;
import com.example.project.dto.DomainDto;
import com.example.project.entity.DomainEntity;

import java.util.List;

public interface DomainService {
    List<DomainDto> findAll();

    List<BookDto> getAllBooks(int id_domain);
}
