package com.example.project.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
class BooksUsersKey implements Serializable {

    @Column(name = "id_book")
    int id_book;

    @Column(name = "id_user")
    int id_user;
}