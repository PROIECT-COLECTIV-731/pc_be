package com.example.project.service.implementations;

import com.example.project.dto.BookDto;
import com.example.project.dto.DomainDto;
import com.example.project.mapper.BookMapper;
import com.example.project.service.interfaces.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DomainServiceImpl implements DomainService {

    @Autowired
    private com.example.project.repository.DomainRepository DomainRepository;
    @Autowired
    private com.example.project.repository.BookRepository BookRepository;
    @Autowired
    private com.example.project.mapper.DomainMapper DomainMapper;
    @Autowired
    private com.example.project.mapper.BookMapper BookMapper;
    
    @Override
    public List<DomainDto> findAll() {
        return DomainMapper.entitiesToDtos(this.DomainRepository.findAll());
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public List<BookDto> getAllBooks(int id_domain) {
        return this.DomainRepository.findDomainEntitiesById(id_domain).getBookEntities()
                .stream()
                .map(reviewEntity -> BookMapper.entityToDto(reviewEntity))
                .collect(Collectors.toList());
    }


}
