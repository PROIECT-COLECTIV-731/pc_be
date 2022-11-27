package com.example.project.controller;

import com.example.project.dto.ReviewDTO;
import com.example.project.entity.ReviewEntity;
import com.example.project.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {
    private ReviewService reviewService;
    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/review")
    public ResponseEntity<String> addReview(ReviewDTO reviewDTO)
    {
        ReviewEntity review=reviewService.convertReviewDTOToEntity(reviewDTO);
        try{
        reviewService.save(review);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Something went wrong");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Review successfully saved");

    }
    @CrossOrigin(origins = "*")
    @GetMapping("/reviews")
    public List<ReviewDTO> getReviews()
    {

        return reviewService.getReviews();

    }

}
