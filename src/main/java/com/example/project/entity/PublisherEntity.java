package com.example.project.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@Table(name = "Publisher")
@AllArgsConstructor
@NoArgsConstructor
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