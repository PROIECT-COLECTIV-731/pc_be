package com.example.project.repository;

import com.example.project.DatabaseMockupForTests;
import com.example.project.dto.ReviewDto;
import com.example.project.entity.ReviewEntity;
import com.example.project.mapper.ReviewMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ReviewRepositoryTest extends DatabaseMockupForTests {

    @Autowired
    private com.example.project.mapper.ReviewMapper ReviewMapper;

    @Test
    void findAll() {
        assert (this.reviews.equals(this.reviewRepository.findAll()));
    }

    @Test
    void findReviewEntitiesById_book() {
        List<ReviewDto> result  = this.reviewRepository.findReviewEntitiesByBookEntity(this.books.get(0))
                .stream()
                .map(reviewEntity -> ReviewMapper.entityToDto(reviewEntity))
                .toList();
        assert (result.contains(ReviewMapper.entityToDto(this.reviews.get(0))));
    }

    @Test
    void findReviewEntitiesById_user() {
        List<ReviewDto> result  = this.reviewRepository.findReviewEntitiesByUserEntity(this.users.get(0))
                .stream()
                .map(reviewEntity -> ReviewMapper.entityToDto(reviewEntity))
                .toList();
        assert (result.contains(ReviewMapper.entityToDto(this.reviews.get(0))));
        assert (result.contains(ReviewMapper.entityToDto(this.reviews.get(1))));
    }
}