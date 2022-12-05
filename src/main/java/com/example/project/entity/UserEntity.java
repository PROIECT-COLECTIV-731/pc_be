package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class UserEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReviewEntity> reviewEntities;

    @ManyToMany
    @JoinTable(
            name="borrow",
            joinColumns = @JoinColumn(name="idUser", referencedColumnName = "ID"),
            inverseJoinColumns= @JoinColumn(name="idBook", referencedColumnName = "ID")
    )
    List<BookEntity> borrowed;

    public void addBorrowedBook(BookEntity book) {
        this.borrowed.add(book);
        book.getBorrowedBy().add(this);
    }

    public void removeBorrowedBook(BookEntity book) {
        this.borrowed.remove(book);
        book.getBorrowedBy().remove(this);
    }
}
