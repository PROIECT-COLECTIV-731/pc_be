package com.example.project.entity;


import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "Users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;
}
