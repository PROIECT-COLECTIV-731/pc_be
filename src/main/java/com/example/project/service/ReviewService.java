package com.example.project.service;

import com.example.project.entity.Book;
import com.example.project.entity.Review;
import com.example.project.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;
    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getReviews()
    {
        return (List<Review>) reviewRepository.findAll();
    }

    public List<Review> getReviewsFromUser(String username)
    {
        return getReviews().stream().filter(review -> review.getUser().getUsername().equals(username)).collect(Collectors.toList());
    }
    public List<Review> getReviewsForBook(Book book)
    {
        return getReviews().stream().filter(review -> review.getBook().equals(book)).collect(Collectors.toList());
    }
}
