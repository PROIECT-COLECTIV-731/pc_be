package com.example.project.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Category")

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;


    @ManyToMany(mappedBy = "bookCategories")
    @JsonIgnore
    private List<BookEntity> categoryBooks;
}

