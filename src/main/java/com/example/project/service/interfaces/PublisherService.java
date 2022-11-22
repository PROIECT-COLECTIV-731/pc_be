package com.example.project.service.interfaces;

import com.example.project.dto.BookDto;
import com.example.project.dto.PublisherDto;

import java.util.List;

public interface PublisherService {
    List<PublisherDto> findAll();

    List<BookDto> getAllBooks(int id_publisher);
}
