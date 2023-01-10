package com.example.project.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Publisher")

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PublisherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy="publisher")
    @JsonIgnore
    private List<BookEntity> publisherBooks;
}