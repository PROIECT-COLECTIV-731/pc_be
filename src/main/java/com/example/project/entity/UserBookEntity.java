package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "user_books")
@AllArgsConstructor
@NoArgsConstructor

public class UserBookEntity {
    @EmbeddedId
    private UserBookID userBookID=new UserBookID();
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userID")
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookID")
    private BookEntity bookEntity;

    @Column(name="startBorrowingDate")
    private LocalDate startDate;

    public BookEntity getBookEntity() {
        return bookEntity;
    }
}
