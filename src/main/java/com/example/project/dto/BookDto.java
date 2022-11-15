package com.example.project.dto;

import javax.persistence.*;
import java.util.List;

public class BookDto {
    private String author;

    private String title;

    private int publicationYear;

    private DomainDto domain;

    private PublisherDto publisher;

    private List<CategoryDto> bookCategories;

    private String summary;

    private float ranking;
}
