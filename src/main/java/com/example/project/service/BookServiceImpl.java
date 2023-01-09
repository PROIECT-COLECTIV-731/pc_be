package com.example.project.service;

import com.example.project.dto.BookDTO;
import com.example.project.dto.DomainDto;
import com.example.project.dto.PublisherDto;
import com.example.project.entity.*;
import com.example.project.repository.BookRepository;
import java.util.ArrayList;
import java.util.List;

import com.example.project.dto.BookDTO;
import com.example.project.dto.BookSearchDTO;
import com.example.project.entity.*;
import org.apache.catalina.User;
import com.example.project.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.Flow;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private DomainRepository domainRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private CategoryRepository categoryRepository;

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
    public BookEntity save(BookEntity book) {
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
    public BookEntity findByISBN(Long ISBN) {
        for (BookEntity b : bookRepository.findAll()) {
            if (Objects.equals(b.getISBN(), ISBN)) {
                return b;
            }
        }
        return null;
    }

    public void delete(BookEntity book) {
        if (book != null) {
            bookRepository.delete(book);
        }
    }

    @Override
    public void deleteAll(List<BookEntity> books) {
        if (books.size() > 0) {
            books.forEach(this::delete);
        }
    }

    @Override
    public BookDTO findById(Long id) {
        return this.convertEntityToDTO(this.bookRepository.findById(id).orElse(null));
    }

    @Override
    public BookDTO convertEntityToDTO(BookEntity book) {
        List<String> categories = new ArrayList<>();
        book.getBookCategories().forEach(categoryEntity -> categories.add(categoryEntity.getName()));
        return BookDTO.builder().
                ISBN(book.getISBN()).
                author(book.getAuthor()).
                title(book.getTitle()).
                ranking(book.getRanking())
                .publisher(convertPublisherToDTO(book.getPublisher())).
                publicationYear(book.getPublicationYear())
                .bookCategories(book.getBookCategories().stream().map(CategoryEntity::getName).toList())
         
                .domain(convertDomainToDTO(book.getDomain()))     
    
                .contentLink(book.getContentLink())
                .summary(book.getSummary())

                .build();
    }



    @Override
    public List<BookDTO> convertEntityListToDTOList(List<BookEntity> books) {
        List<BookDTO> boookList = new ArrayList<>();
        if (books != null) {
            books.forEach(bookEntity -> boookList.add(convertEntityToDTO(bookEntity)));
        }
        return boookList;
    }

    @Override
    public BookEntity findBookByISBN(Long isbn) {

        return bookRepository.findAll().stream().filter(bookEntity -> bookEntity.getISBN().equals(isbn)).findFirst().orElse(null);

    }

    @Override

    public PublisherDto convertPublisherToDTO(PublisherEntity publisherEntity) {
        return PublisherDto.builder()
                        .name(publisherEntity.getName())
                .build();
    }

    @Override
    public DomainDto convertDomainToDTO(DomainEntity domainEntity) {
        return DomainDto.builder().name(domainEntity.getName()).build();
    }

    public List<String> sortBookTitlesAlphabetical() {
        List<String> titles = new ArrayList<>();
        findAll().forEach(bookEntity -> titles.add(bookEntity.getTitle()));
        return titles.stream().sorted().collect(Collectors.toList());
    }

    public String getNrUsersForABook(BookEntity book) {
        List<UserEntity> user = new ArrayList<>();
        userBookRepository.findAll().forEach(userBookEntity -> {
            if (Objects.equals(userBookEntity.getBookEntity().getId(), book.getId())) {
                user.add(userBookEntity.getUserEntity());
            }
        });
        return String.valueOf(user.size());
    }

    @Override
    public Map<String, String> countUsersForAllBooks() {
        List<BookEntity> allBooks = findAll();
        Map<String, String> booksWithAmount = new LinkedHashMap<>();
        allBooks.forEach(book -> booksWithAmount.put(book.getTitle(), getNrUsersForABook(book)));
        return sortMap(booksWithAmount);
    }

    @Override
    public BookEntity update(BookDTO book) {
        BookEntity bookEntity = null;
        if (book != null) {
            bookEntity = findBookByISBN(book.getISBN());
            if (bookEntity != null) {
                bookEntity.setISBN(book.getISBN());
                bookEntity.setAuthor(book.getAuthor());
                bookEntity.setContentLink(book.getContentLink());
                bookEntity.setPublicationYear(book.getPublicationYear());
                bookEntity.setRanking(book.getRanking());
                bookEntity.setSummary(book.getSummary());
                bookEntity.setTitle(book.getTitle());
                PublisherEntity publisher;
                List<CategoryEntity>categoryEntityList;
                DomainEntity domain;
                try{
                    publisher= findExistingPublisher(book.getPublisher());
                    domain=findExistingDomain(book.getDomain());
                    categoryEntityList=findExistingCategories(book.getBookCategories());}
                catch (Exception e){
                    throw  new RuntimeException(e.getMessage());
                }
                bookEntity.setPublisher(publisher);
                bookEntity.setBookCategories(categoryEntityList);
                bookEntity.setDomain(domain);
                bookRepository.save(bookEntity);
            }
        }

        return bookEntity;
    }

    @Override
    public BookEntity convertDTOToEntity(BookDTO bookDTO) {
        List<CategoryEntity> categories;
        PublisherEntity publisher = findExistingPublisher(bookDTO.getPublisher());
        if (publisher == null) {
            throw new RuntimeException("Publisher "+bookDTO.getPublisher().getName()+" does not exists");
        }
        publisherRepository.save(publisher);
        DomainEntity domain = findExistingDomain(bookDTO.getDomain());
        if (domain == null) {
            throw new RuntimeException("Domain"+bookDTO.getDomain().getName()+" does not exists");
        }
        domainRepository.save(domain);
        categories = findExistingCategories(bookDTO.getBookCategories());
        return BookEntity.builder().
                ISBN(bookDTO.getISBN()).
                author(bookDTO.getAuthor()).
                title(bookDTO.getTitle()).
                ranking(bookDTO.getRanking())
                .publisher(publisher).
                publicationYear(bookDTO.getPublicationYear()).
                bookCategories(categories)
                .contentLink(bookDTO.getContentLink())
                .domain(domain)
                .build();
    }


    public Map<String, String> sortMap(Map<String, String> map) {
        Map<String, String> sortedMap = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.<String, String>comparingByKey())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        return sortedMap;
    }

    public DomainEntity findExistingDomain(DomainDto domainDto) {
        DomainEntity foundDomain;
        try {
            foundDomain = domainRepository.findByName(domainDto.getName());
        } catch (Exception e) {
            foundDomain = null;
        }
        return foundDomain;
    }

    public PublisherEntity findExistingPublisher(PublisherDto publisherDto) {
        PublisherEntity publisher;
        try {
            publisher = publisherRepository.findByName(publisherDto.getName());
        } catch (Exception e) {
            publisher = null;
        }
        return publisher;
    }

    public List<CategoryEntity> findExistingCategories(List<String> nameList) {
        List<CategoryEntity> categoryEntityList = new ArrayList<>();
        nameList.forEach(categoryName -> {
            if (findExistingCategory(categoryName) == null) {
                throw new RuntimeException("Category "+categoryName+ " does not exists");
            } else {
                categoryEntityList.add(findExistingCategory(categoryName));
            }
        });
        return categoryEntityList;
    }

    public CategoryEntity findExistingCategory(String name) {
        CategoryEntity category;
        try {
            category = categoryRepository.findByName(name);
        } catch (Exception e) {
            category = null;
        }
        return category;


    }


}

