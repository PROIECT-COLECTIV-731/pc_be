package com.example.project.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Books")
@ToString(exclude = "categories")
public class BookEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String author;

    @Column
    private String title;

    @Column
    private int year;

    @Column
    private String ISBN;

    @Column
    private String contentLink;

    @Column
    private String summary;

    @Column
    private float ranking;

    @OneToMany(mappedBy = "bookEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReviewEntity> reviewEntities;

    @ManyToOne(fetch = FetchType.LAZY)
    private DomainEntity domainEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private PublisherEntity publisherEntity;

    @ManyToMany
    @JoinTable(
            name="borrow",
            joinColumns = @JoinColumn(name="idBook", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name="idUser", referencedColumnName = "ID")
    )
    List<UserEntity> borrowedBy;

    @ManyToMany
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "idBook", referencedColumnName="ID"),
            inverseJoinColumns = @JoinColumn(name = "idCategory", referencedColumnName="ID"))
    List<CategoryEntity> categories;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return id == that.id ||
                ( year == that.year &&
                Float.compare(that.ranking, ranking) == 0 &&
                author.equals(that.author) &&
                title.equals(that.title) &&
                ISBN.equals(that.ISBN) &&
                summary.equals(that.summary));
    }
}
