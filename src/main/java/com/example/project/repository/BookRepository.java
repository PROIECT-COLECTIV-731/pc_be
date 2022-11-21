package com.example.project.repository;

import com.example.project.entity.BookEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    @Override
    List<BookEntity> findAll();

    @Override
    BookEntity save(BookEntity book);
}