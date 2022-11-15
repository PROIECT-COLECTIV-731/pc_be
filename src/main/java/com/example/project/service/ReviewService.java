package com.example.project.service;

import com.example.project.dto.ReviewDTO;
import com.example.project.entity.BookEntity;
import com.example.project.entity.ReviewEntity;
import com.example.project.entity.UserEntity;
import com.example.project.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;
    private UserService userService;
    @Autowired
    public ReviewService(ReviewRepository reviewRepository, UserService userService) {
        this.reviewRepository = reviewRepository;
        this.userService = userService;
    }

    public List<ReviewEntity> findAll()
    {
        return (List<ReviewEntity>) reviewRepository.findAll();
    }

    public ReviewEntity save(ReviewEntity review)
    {
        ReviewEntity savedReview;
        try{
         savedReview=reviewRepository.save(review);}
        catch (Exception e)
        {
            throw new RuntimeException("Something went wrong");
        }
        return savedReview;
    }

    public List<ReviewEntity> getReviewsFromUser(String username)
    {
        return findAll().stream().filter(review -> review.getUser().getUsername().equals(username)).collect(Collectors.toList());
    }
    public List<ReviewEntity> getReviewsForBook(BookEntity book)
    {
        return findAll().stream().filter(review -> review.getBook().equals(book)).collect(Collectors.toList());
    }

    public ReviewEntity convertReviewDTOToEntity(ReviewDTO reviewDTO)
    {
        UserEntity user=userService.findUserByUserName(reviewDTO.getUsername());
        // findBookByTileAndAuthor
        return  ReviewEntity.builder()
            .description(reviewDTO.getDescription())
            .rating(reviewDTO.getRating())
            .user(user)
            //.book(book)
            .build();

    }
    public ReviewDTO convertEntityToReviewDTO(ReviewEntity review)
    {

        return  ReviewDTO.builder()
                .description(review.getDescription())
                .rating(review.getRating())
                .username(review.getUser().getUsername())
                .author(review.getBook().getAuthor())
                .title(review.getBook().getTitle())
                .build();

    }

    public List<ReviewDTO> getReviews()
    {
        List<ReviewDTO> reviews= new ArrayList<>();
        findAll().forEach(review -> reviews.add(convertEntityToReviewDTO(review)));
        return reviews;

    }
}
