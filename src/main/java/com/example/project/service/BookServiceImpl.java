package com.example.project.service;

import java.util.ArrayList;
import java.util.List;

import com.example.project.dto.BookDTO;
import com.example.project.dto.BookSearchDTO;
import com.example.project.entity.*;
import com.example.project.repository.BookRepository;
import com.example.project.repository.ReviewRepository;
import com.example.project.repository.UserBookRepository;
import com.example.project.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserBookRepository userBookRepository;



    BookServiceImpl(BookRepository bookRepository, UserBookRepository userBookRepository){
        this.bookRepository = bookRepository;
        this.userBookRepository = userBookRepository;
    }


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

    }


    @Override
    public BookEntity findByISBN(Long ISBN){
        for(BookEntity b: bookRepository.findAll()){
            if(Objects.equals(b.getISBN(), ISBN)){
                return b;
            }
        }
        return null;
    }

    public void delete(BookEntity book) {
        if(book!=null)
        {
            bookRepository.delete(book);
        }
    }
    @Override
    public void deleteAll(List<BookEntity> books) {
        if(books.size()>0)
        {
            books.forEach(this::delete);
        }
    }

    @Override
    public BookDTO findById(Long id) {
        return this.convertEntityToDTO(this.bookRepository.findById(id).orElse(null));
    }

    @Override
    public BookDTO convertEntityToDTO(BookEntity book) {
        List<String>categories=new ArrayList<>();
        book.getBookCategories().forEach(categoryEntity -> categories.add(categoryEntity.getName()));
        return BookDTO.builder().
                ISBN(book.getISBN()).
                author(book.getAuthor()).
                title(book.getTitle()).
                ranking(book.getRanking())
                .publisher(book.getPublisher().getName()).
                publicationYear(book.getPublicationYear()).
                bookCategories(categories)
                .domain(book.getDomain().getName())
                .contentLink(book.getContentLink())
                .summary(book.getSummary())
                .build();
    }

    @Override
    public List<BookDTO> convertEntityListToDTOList(List<BookEntity> books) {
        List<BookDTO>boookList=new ArrayList<>();
        if(books!=null){
            books.forEach(bookEntity -> boookList.add(convertEntityToDTO(bookEntity)));
        }
        return boookList;
    }

    @Override
    public BookEntity findBookByISBN(Long isbn) {

       return bookRepository.findAll().stream().filter(bookEntity -> bookEntity.getISBN().equals(isbn)).findFirst().orElse(null);

    }
    @Override
    public List<String> sortBookTitlesAlphabetical() {
        List<String>titles=new ArrayList<>();
        findAll().forEach(bookEntity -> titles.add(bookEntity.getTitle()));
        return titles.stream().sorted().collect(Collectors.toList());
    }

    public String getNrUsersForABook(BookEntity book) {
        List<UserEntity>user=new ArrayList<>();
        userBookRepository.findAll().forEach(userBookEntity ->{if(Objects.equals(userBookEntity.getBookEntity().getId(), book.getId())){user.add(userBookEntity.getUserEntity());}});
        return String.valueOf(user.size());
    }
    @Override
    public Map<String,String> countUsersForAllBooks() {
        List<BookEntity>allBooks=findAll();
        Map<String,String>booksWithAmount=new LinkedHashMap<>();
        allBooks.forEach(book -> booksWithAmount.put(book.getTitle(),getNrUsersForABook(book)));
        return sortMap(booksWithAmount);
    }
    public Map<String,String> sortMap(Map<String,String>map) {
        Map<String,String>sortedMap=new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.<String,String>comparingByKey())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        return sortedMap;
    }



}

