package com.example.project.repository;

import com.example.project.entity.BookEntity;
import com.example.project.entity.CategoryEntity;
import com.example.project.entity.DomainEntity;
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

    List<BookEntity> findByAuthor( String author);
    List<BookEntity> findByTitle(String title);
    List<BookEntity> findByPublicationYear(int publicationYear);
    List<BookEntity> findByISBN(Long ISBN);
    List<BookEntity> findByCategory(CategoryEntity category);
    List<BookEntity> findByDomain(DomainEntity domain);

    //2
    List<BookEntity> findByAuthorAndTitle(String author, String title);
    List<BookEntity> findByAuthorAndPublicationYear(String author, int publicationYear);
    List<BookEntity> findByAuthorAndISBN(String author, Long ISBN);
    List<BookEntity> findByAuthorAndCategory(String author, CategoryEntity category);
    List<BookEntity> findByAuthorAndDomain(String author, DomainEntity domain);
    List<BookEntity> findByTitleAndPublicationYear(String title, int publicationYear);
    List<BookEntity> findByTitleAndISBN(String title, Long ISBN);
    List<BookEntity> findByTitleAndCategory(String title, CategoryEntity category);
    List<BookEntity> findByTitleAndDomain( String title, DomainEntity domain);
    List<BookEntity> findByPublicationYearAndISBN(int publicationYear, Long ISBN);
    List<BookEntity> findByPublicationYearAndCategory(int publicationYear, CategoryEntity category);
    List<BookEntity> findByPublicationYearAndDomain(int publicationYear, DomainEntity domain);
    List<BookEntity> findByISBNAndCategory(Long ISBN, CategoryEntity category);
    List<BookEntity> findByISBNAndDomain(Long isbn, DomainEntity domain);
    List<BookEntity> findByCategoryAndDomain(CategoryEntity category, DomainEntity domain);

    //3
    List<BookEntity> findByAuthorAndTitleAndPublicationYear(String author, String title, int publicationYear);
    List<BookEntity> findByAuthorAndTitleAndISBN(String author, String title, Long ISBN);
    List<BookEntity> findByAuthorAndTitleAndCategory(String author, String title, CategoryEntity category);
    List<BookEntity> findByAuthorAndTitleAndDomain(String author, String title, DomainEntity domain);
    List<BookEntity> findByTitleAndPublicationYearAndISBN(String title, int publicationYear, Long ISBN);
    List<BookEntity> findByTitleAndPublicationYearAndCategory(String title, int publicationYear, CategoryEntity category);
    List<BookEntity> findByTitleAndPublicationYearAndDomain(String title, int publicationYear, DomainEntity domain);
    List<BookEntity> findByPublicationYearAndISBNAndCategory(int publicationYear, Long ISBN, CategoryEntity category);
    List<BookEntity> findByPublicationYearAndISBNAndDomain(int publicationYear, Long ISBN, DomainEntity domain);
    List<BookEntity> findByISBNAndCategoryAndDomain(Long ISBN, CategoryEntity category, DomainEntity domain);

    //todo: sa termin posibilitatile de 4
    List<BookEntity> findByAuthorAndTitleAndPublicationYearAndISBN(String author, String title, int publicationYear, Long ISBN);
    List<BookEntity> findByAuthorAndTitleAndPublicationYearAndCategory(String author, String title, int publicationYear, CategoryEntity category);
    List<BookEntity> findByAuthorAndTitleAndISBNAndCategory(String author, String title, Long ISBN, CategoryEntity category);
    List<BookEntity> findByAuthorAndPublicationYearAndISBNAndCategory(String author, int publicationYear, Long ISBN, CategoryEntity category);
    List<BookEntity> findByTitleAndPublicationYearAndISBNAndCategory(String title, int publicationYear, Long ISBN, CategoryEntity category);

    //5
    List<BookEntity> findByAuthorAndTitleAndPublicationYearAndISBNAndCategory(String author, String title, int publicationYear, Long ISBN, CategoryEntity category);
    List<BookEntity> findByAuthorAndTitleAndPublicationYearAndISBNAndDomain(String author, String title, int publicationYear, Long ISBN, DomainEntity domain);
    List<BookEntity> findByAuthorAndTitleAndPublicationYearAndCategoryAndDomain(String author, String title, int publicationYear, CategoryEntity category, DomainEntity domain);
    List<BookEntity> findByAuthorAndTitleAndISBNAndCategoryAndDomain(String author, String title, Long ISBN, CategoryEntity category, DomainEntity domain);
    List<BookEntity> findByAuthorAndPublicationYearAndISBNAndCategoryAndDomain(String author, int publicationYear, Long ISBN, CategoryEntity category, DomainEntity domain);
    List<BookEntity> findByTitleAndPublicationYearAndISBNAndCategoryAndDomain(String title, int publicationYear, Long ISBN, CategoryEntity category, DomainEntity domain);
}