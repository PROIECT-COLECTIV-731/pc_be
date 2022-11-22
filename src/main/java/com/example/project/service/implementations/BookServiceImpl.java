package com.example.project.service.implementations;

import com.example.project.dto.BookDto;
import com.example.project.dto.CategoryDto;
import com.example.project.entity.BookEntity;
import com.example.project.entity.CategoryEntity;
import com.example.project.mapper.BookMapper;
import com.example.project.mapper.CategoryMapper;
import com.example.project.repository.BookRepository;
import com.example.project.repository.DomainRepository;
import com.example.project.repository.PublisherRepository;
import com.example.project.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository BookRepository;
    @Autowired
    private DomainRepository DomainRepository;
    @Autowired
    private PublisherRepository PublisherRepository;
    @Autowired
    private BookMapper BookMapper;

    @Override
    public List<BookDto> findAll() {
        return BookMapper.entitiesToDtos(this.BookRepository.findAll());
    }

    @Override
    public List<BookDto> findBookEntityByTitleAndAuthor(String author, String title) {
        return BookMapper.entitiesToDtos(this.BookRepository.findBookEntityByTitleAndAuthor(author, title));
    }

    @Override
    public BookDto findBookEntityByISBN(String isbn) {
        return BookMapper.entityToDto(this.BookRepository.findBookEntityByISBN(isbn));
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public List<CategoryDto> getAllCategories(int id_book) {
        return CategoryMapper.INSTANCE.entitiesToDtos(this.BookRepository.findBookEntityById(id_book).getCategories());
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public List<BookDto> findBookEntityByDomainEntity(int id_domain) {
        return this.BookRepository.findBookEntityByDomainEntity(this.DomainRepository.findDomainEntitiesById(id_domain))
                .stream()
                .map(reviewEntity -> BookMapper.entityToDto(reviewEntity))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public List<BookDto> findBookEntityByPublisherEntity(int id_publisher) {
        return this.BookRepository.findBookEntityByPublisherEntity(this.PublisherRepository.findPublisherEntitiesById(id_publisher))
                .stream()
                .map(reviewEntity -> BookMapper.entityToDto(reviewEntity))
                .collect(Collectors.toList());
    }
}
