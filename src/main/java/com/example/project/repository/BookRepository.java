package com.example.project.repository;

import com.example.project.entity.BookEntity;
import com.example.project.entity.DomainEntity;
import com.example.project.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, String> {
    @Override
    List<BookEntity> findAll();

    List<BookEntity> findBookEntityByTitleAndAuthor(String title, String author);

    BookEntity findBookEntityById(int id);

    List<BookEntity> findBookEntityByTitle(String title);

    List<BookEntity> findBookEntityByAuthor(String author);

    BookEntity findBookEntityByISBN(String isbn);

    List<BookEntity> findBookEntityByDomainEntity(DomainEntity domainEntity);

    List<BookEntity> findBookEntityByPublisherEntity(PublisherEntity publisherEntity);
}
