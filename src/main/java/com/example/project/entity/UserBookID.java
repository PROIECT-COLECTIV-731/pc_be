package com.example.project.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserBookID implements Serializable {

    @Column(name="book_id")
    private Long bookID;
    @Column(name="user_id")
    private Long userID;
}
