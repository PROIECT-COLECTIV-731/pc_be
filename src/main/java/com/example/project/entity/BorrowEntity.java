package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@Getter
@Table(name = "Borrow")
public class BorrowEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(optional = false, cascade=CascadeType.ALL)
    @JoinColumn(name = "id_book", nullable = false, referencedColumnName="id")
    private BookEntity borrowedBook;

    @ManyToOne(optional = false, cascade=CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName="id")
    private UserEntity user;

    @Column
    private String status;

    @Column
    private LocalDate returnDate;

    @Column
    private LocalDate borrowDate;

    public BorrowEntity() {
    }

    public BorrowEntity(BookEntity book, UserEntity user, String status, LocalDate borrowDate, LocalDate returnDate) {
        this.id = id;
        this.user = user;
        this.borrowedBook = book;
        this.status = status;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }
}
