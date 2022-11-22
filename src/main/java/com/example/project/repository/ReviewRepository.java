package com.example.project.repository;

import com.example.project.entity.BookEntity;
import com.example.project.entity.ReviewEntity;
import com.example.project.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, String> {
    @Override
    List<ReviewEntity> findAll();

    List<ReviewEntity> findReviewEntitiesByBookEntity(BookEntity book);

    List<ReviewEntity> findReviewEntitiesByUserEntity(UserEntity user);
}
