package com.example.project.repository;

import com.example.project.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    @Override
    List<BookEntity> findAll();

    @Override
    BookEntity save(BookEntity book);

    Optional<BookEntity> findById(Long id);

    @Override
    void delete(BookEntity book);

}
