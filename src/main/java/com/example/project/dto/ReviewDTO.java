package com.example.project.dto;

import com.example.project.entity.Book;
import com.example.project.entity.User;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReviewDTO {

    private String description;
    private int rating;
    private String username;
    private String title;
    private String author;
}
