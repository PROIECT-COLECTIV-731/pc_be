package com.example.project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
public class BookDTO {
    private Long ISBN;

    private String author;

    private String title;

    private int publicationYear;

    private DomainDto domain;

    private PublisherDto publisher;

    private List<String> bookCategories;

    private String summary;

    private float ranking;

    private String contentLink;
}
