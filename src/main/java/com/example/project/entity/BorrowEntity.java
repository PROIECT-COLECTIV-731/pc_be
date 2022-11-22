package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BooksUsers")
public class BorrowEntity {
    @EmbeddedId
    BooksUsersKey id;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "id_book")
    BookEntity book;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "id_user")
    UserEntity user;

    Date borrowTime;
}
