package com.example.project.entity;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Getter
@Table(name = "Book")
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ISBN", unique = true)
    private Long ISBN;

    @Column(name = "author")
    private String author;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "publication_year")
    private int publicationYear;

    @ManyToOne
    @JoinColumn(name="domain_id", nullable=false)
    private DomainEntity domain;

    @ManyToOne
    @JoinColumn(name="publisher_id", nullable=false)
    private PublisherEntity publisher;

    @ManyToMany
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoryEntity> bookCategories;

    @Column(name = "summary")
    private String summary;

    @Column(name = "ranking")
    private float ranking;

    @OneToMany(mappedBy = "bookEntity")
    private List<UserBookEntity>books;
}
//    a admin user
//        I want to add books with the following attributes and restrictions:
//        - author (minim 1, mandatory, string)
//        - title (mandatory, string)
//        - publication year (mandatory, int - between 1900 - current year)
//        - ISBN (as ID, int, mandatory, unique, max 13 caractere)
//        - domain (from domain catalogue, mandatory)
//        - publisher (from publisher catalogue, mandatory)
//        - categories (recommendations for specific courses - from category catalogue, optional, many)
//        - summary - string, optional
//        - ranking (from a scale from 1 to 5) - read only, default 0
//        That i can create the library of books