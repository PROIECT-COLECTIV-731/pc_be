package com.example.project.service.implementations;

import com.example.project.dto.ReviewDto;
import com.example.project.service.interfaces.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private com.example.project.repository.ReviewRepository ReviewRepository;
    @Autowired
    private com.example.project.repository.BookRepository BookRepository;
    @Autowired
    private com.example.project.repository.UserRepository UserRepository;
    @Autowired
    private com.example.project.mapper.ReviewMapper ReviewMapper;

    @Autowired
    private com.example.project.mapper.BookMapper BookMapper;

    @Autowired
    private com.example.project.mapper.UserMapper UserMapper;

    @Override
    public List<ReviewDto> findAll() {
        return ReviewRepository.findAll()
                .stream()
                .map(reviewEntity -> ReviewMapper.entityToDto(reviewEntity))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true, noRollbackFor = Exception.class)
    public List<ReviewDto> findReviewEntitiesByBookEntity(int id_book) {
        return  this.ReviewRepository
                .findReviewEntitiesByBookEntity(this.BookRepository.findBookEntityById(id_book))
                .stream()
                .map(reviewEntity -> ReviewMapper.entityToDto(reviewEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<ReviewDto> findReviewEntitiesByUserEntity(int id_user) {
        return this.ReviewRepository
                .findReviewEntitiesByUserEntity(this.UserRepository.findUserEntityById(id_user))
                .stream()
                .map(reviewEntity -> ReviewMapper.entityToDto(reviewEntity))
                .collect(Collectors.toList());
    }
}
