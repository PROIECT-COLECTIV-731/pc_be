package com.example.project.service.interfaces;

import com.example.project.dto.ReviewDto;

import java.util.List;

public interface ReviewService {

    List<ReviewDto> findAll();

    List<ReviewDto> findReviewEntitiesByBookEntity(int id_book);

    List<ReviewDto> findReviewEntitiesByUserEntity(int id_user);
}
