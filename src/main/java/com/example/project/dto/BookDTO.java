package com.example.project.dto;

import com.example.project.entity.CategoryEntity;
import com.example.project.entity.DomainEntity;
import com.example.project.entity.PublisherEntity;
import com.example.project.entity.UserBookEntity;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookDTO {

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
