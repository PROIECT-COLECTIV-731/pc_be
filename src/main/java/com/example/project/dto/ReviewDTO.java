package com.example.project.dto;

import lombok.*;

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
