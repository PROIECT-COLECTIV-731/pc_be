package com.example.project.service.implementations;

import com.example.project.dto.BookDto;
import com.example.project.dto.PublisherDto;
import com.example.project.mapper.BookMapper;
import com.example.project.service.interfaces.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private com.example.project.repository.PublisherRepository PublisherRepository;
    @Autowired
    private com.example.project.repository.BookRepository BookRepository;
    @Autowired
    private com.example.project.mapper.PublisherMapper PublisherMapper;
    @Autowired
    private com.example.project.mapper.BookMapper BookMapper;

    @Override
    public List<PublisherDto> findAll() {
        return PublisherMapper.entitiesToDtos(this.PublisherRepository.findAll());
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public List<BookDto> getAllBooks(int id_publisher) {
        return this.PublisherRepository.findPublisherEntitiesById(id_publisher).getBookEntities()
                .stream()
                .map(reviewEntity -> BookMapper.entityToDto(reviewEntity))
                .collect(Collectors.toList());
    }

}
