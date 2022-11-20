package com.example.project.dto;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter
public class BookDto {
    private Long ISBN;

    private String author;

    private String title;

    private int publicationYear;

    private String domain;

    private String publisher;

    private List<String> bookCategories;

    private String summary;

    private float ranking;
}
