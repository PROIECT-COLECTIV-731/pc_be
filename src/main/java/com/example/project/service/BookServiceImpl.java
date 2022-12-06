package com.example.project.service;

import com.example.project.dto.BookSearchDTO;
import com.example.project.repository.BookRepository;
import com.example.project.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<BookEntity> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public BookEntity save(BookEntity book){
        if (book != null)
            return bookRepository.save(book);
        return null;
    }

    public BookSearchDTO convertToDTO(BookEntity book){
        return BookSearchDTO.builder()
                .ISBN(book.getISBN())
                .author(book.getAuthor())
                .title(book.getTitle())
                .publicationYear(book.getPublicationYear())
                .category(book.getCategory())
                .domain(book.getDomain())
                .build();
    }

    public List<BookSearchDTO> convertListToDTO(List<BookEntity> bookEntities){
        return bookEntities.stream().map(this::convertToDTO).collect(Collectors.toList());

    }

    public List<BookSearchDTO> search(String word){
        if(word == null || word.isBlank() || word.isEmpty())
            return convertListToDTO(this.bookRepository.findAll());
        List<BookSearchDTO> returnList = new ArrayList<>();


        for(BookEntity book : this.bookRepository.findAll()){
            if(book.toString().contains(word))
                returnList.add(convertToDTO(book));

        }
        return returnList;

        /* if(author != null && title == null && year == 0 && isbn == 0 && categorie == null && domain == null)
             return (BookSearchDTO) this.bookRepository.findByAuthor(author);
         else if(author == null && title != null && year == 0 && isbn == 0 && categorie == null && domain == null)
             return (BookSearchDTO) this.bookRepository.findByTitle(title);
         else if(author == null && title == null && year != 0 && isbn == 0 && categorie == null && domain == null)
            return (BookSearchDTO) this.bookRepository.findByPublicationYear(year);
         else if(author == null && title == null && year == 0 && isbn != 0 && categorie == null && domain == null)
            return (BookSearchDTO) this.bookRepository.findByISBN(isbn);
         else if(author == null && title == null && year == 0 && isbn == 0 && categorie != null && domain == null)
            return (BookSearchDTO) this.bookRepository.findByCategory(categorie);
         else if(author == null && title == null && year == 0 && isbn == 0 && categorie == null && domain != null)
             return (BookSearchDTO) this.bookRepository.findByDomain(domain);

         else if(author != null && title != null && year == 0 && isbn == 0 && categorie == null  && domain == null)
            return (BookSearchDTO) this.bookRepository.findByAuthorAndTitle(author, title);
         else if(author != null && title == null && year != 0 && isbn == 0 && categorie == null  && domain == null)
            return (BookSearchDTO) this.bookRepository.findByAuthorAndPublicationYear(author, year );
         else if(author != null && title == null && year == 0 && isbn != 0 && categorie == null  && domain == null)
            return (BookSearchDTO) this.bookRepository.findByAuthorAndISBN(author, isbn);
         else if(author != null && title == null && year == 0 && isbn == 0 && categorie != null  && domain == null)
            return (BookSearchDTO) this.bookRepository.findByAuthorAndCategory(author, categorie);
         else if(author != null && title == null && year == 0 && isbn == 0 && categorie == null && domain != null)
             return (BookSearchDTO) this.bookRepository.findByAuthorAndDomain(author, domain);


         else if(author == null && title != null && year != 0 && isbn == 0 && categorie == null  && domain == null)
            return (BookSearchDTO) this.bookRepository.findByTitleAndPublicationYear(title, year);
         else if(author == null && title != null && year == 0 && isbn != 0 && categorie == null  && domain == null)
            return (BookSearchDTO) this.bookRepository.findByTitleAndISBN(title, isbn);
         else if(author == null && title != null && year == 0 && isbn == 0 && categorie != null  && domain == null)
            return (BookSearchDTO) this.bookRepository.findByTitleAndCategory(title, categorie);
         else if(author == null && title != null && year == 0 && isbn == 0 && categorie == null  && domain != null)
             return (BookSearchDTO) this.bookRepository.findByTitleAndDomain(title, domain);


         else if(author == null && title == null && year != 0 && isbn != 0 && categorie == null  && domain == null)
            return (BookSearchDTO) this.bookRepository.findByPublicationYearAndISBN(year, isbn);
         else if(author == null && title == null && year != 0 && isbn == 0 && categorie != null  && domain == null)
            return (BookSearchDTO) this.bookRepository.findByPublicationYearAndCategory(year, categorie);
         else if(author == null && title == null && year != 0 && isbn == 0 && categorie == null  && domain != null)
             return (BookSearchDTO) this.bookRepository.findByPublicationYearAndDomain(year, domain);

         else if(author == null && title == null && year == 0 && isbn != 0 && categorie != null  && domain == null)
            return (BookSearchDTO) this.bookRepository.findByISBNAndCategory(isbn, categorie);
         else if(author == null && title == null && year == 0 && isbn != 0 && categorie == null  && domain != null)
             return (BookSearchDTO) this.bookRepository.findByISBNAndDomain(isbn, domain);

         else if(author == null && title == null && year == 0 && isbn == 0 && categorie != null  && domain != null)
             return (BookSearchDTO) this.bookRepository.findByCategoryAndDomain(categorie, domain);


         else if(author != null && title != null && year != 0 && isbn == 0 && categorie == null  && domain == null)
            return (BookSearchDTO) this.bookRepository.findByAuthorAndTitleAndPublicationYear(author,title,year);
         else if(author != null && title != null && year == 0 && isbn != 0 && categorie == null  && domain == null)
            return (BookSearchDTO) this.bookRepository.findByAuthorAndTitleAndISBN(author, title, isbn);
         else if(author != null && title != null && year == 0 && isbn == 0 && categorie != null && domain == null)
            return (BookSearchDTO) this.bookRepository.findByAuthorAndTitleAndCategory(author, title, categorie);
         else if(author != null && title != null && year == 0 && isbn == 0 && categorie == null && domain != null)
             return (BookSearchDTO) this.bookRepository.findByAuthorAndTitleAndDomain(author, title, domain);


         else if(author == null && title != null && year != 0 && isbn != 0 && categorie == null  && domain == null)
            return (BookSearchDTO) this.bookRepository.findByTitleAndPublicationYearAndISBN(title, year, isbn);
         else if(author == null && title != null && year != 0 && isbn == 0 && categorie != null  && domain == null)
            return (BookSearchDTO) this.bookRepository.findByTitleAndPublicationYearAndCategory(title, year, categorie);

         else if(author == null && title != null && year != 0 && isbn == 0 && categorie == null  && domain != null)
             return (BookSearchDTO) this.bookRepository.findByTitleAndPublicationYearAndDomain(title, year, domain);
         else if(author == null && title == null && year != 0 && isbn != 0 && categorie != null  && domain == null)
            return (BookSearchDTO) this.bookRepository.findByPublicationYearAndISBNAndCategory(year, isbn, categorie);
         else if(author == null && title == null && year != 0 && isbn != 0 && categorie == null  && domain != null)
             return (BookSearchDTO) this.bookRepository.findByPublicationYearAndISBNAndDomain(year, isbn, domain);

         else if(author == null && title == null && year == 0 && isbn != 0 && categorie != null  && domain != null)
             return (BookSearchDTO) this.bookRepository.findByISBNAndCategoryAndDomain(isbn, categorie, domain);


         else if(author != null && title != null && year != 0 && isbn != 0 && categorie == null  && domain == null)
            return (BookSearchDTO) this.bookRepository.findByAuthorAndTitleAndPublicationYearAndISBN(author, title, year, isbn);
         else if(author != null && title != null && year != 0 && isbn == 0 && categorie != null  && domain == null)
            return (BookSearchDTO) this.bookRepository.findByAuthorAndTitleAndPublicationYearAndCategory(author, title, year, categorie);
         else if(author != null && title != null && year == 0 && isbn != 0 && categorie != null  && domain == null)
            return (BookSearchDTO) this.bookRepository.findByAuthorAndTitleAndISBNAndCategory(author, title, isbn, categorie);
         else if(author != null && title == null && year != 0 && isbn != 0 && categorie != null  && domain == null)
            return (BookSearchDTO) this.bookRepository.findByAuthorAndPublicationYearAndISBNAndCategory(author, year, isbn, categorie);
         else if(author == null && title != null && year != 0 && isbn != 0 && categorie != null  && domain == null)
            return (BookSearchDTO) this.bookRepository.findByTitleAndPublicationYearAndISBNAndCategory(title, year, isbn, categorie);


         else if(author != null && title != null && year != 0 && isbn != 0 && categorie != null  && domain == null)
             return (BookSearchDTO) this.bookRepository.findByAuthorAndTitleAndPublicationYearAndISBNAndCategory(author, title, year, isbn, categorie);
         else if(author != null && title != null && year != 0 && isbn == 0 && categorie == null  && domain != null)
             return (BookSearchDTO) this.bookRepository.findByAuthorAndTitleAndPublicationYearAndISBNAndDomain(author, title, year, isbn, domain);
         else if(author != null && title != null && year != 0 && isbn == 0 && categorie != null  && domain != null)
             return (BookSearchDTO) this.bookRepository.findByAuthorAndTitleAndPublicationYearAndCategoryAndDomain(author, title, year, categorie, domain);
         else if(author != null && title == null && year != 0 && isbn != 0 && categorie != null  && domain != null)
             return (BookSearchDTO) this.bookRepository.findByAuthorAndPublicationYearAndISBNAndCategoryAndDomain(author, year, isbn, categorie, domain);
         else if(author == null && title != null && year != 0 && isbn != 0 && categorie != null  && domain != null)
             return (BookSearchDTO) this.bookRepository.findByTitleAndPublicationYearAndISBNAndCategoryAndDomain(title, year, isbn, categorie, domain);
         else if(author != null && title != null && year == 0 && isbn != 0 && categorie != null  && domain != null)
             return (BookSearchDTO) this.bookRepository.findByAuthorAndTitleAndISBNAndCategoryAndDomain(author, title, isbn, categorie, domain);



         else if(author != null && title != null && year != 0 && isbn != 0 && categorie != null  && domain != null)
            return (BookSearchDTO) this.bookRepository.findAll();

        return null;*/
    }
}