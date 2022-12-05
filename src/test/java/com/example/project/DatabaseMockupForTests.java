package com.example.project;

import com.example.project.entity.*;
import com.example.project.repository.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public abstract class DatabaseMockupForTests {
    @Autowired
    protected BookRepository bookRepository;

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected DomainRepository domainRepository;

    @Autowired
    protected PublisherRepository publisherRepository;

    @Autowired
    protected CategoryRepository categoryRepository;
    @Autowired
    protected ReviewRepository reviewRepository;

    protected List<DomainEntity> domains = new ArrayList<>();
    protected List<PublisherEntity> publishers = new ArrayList<>();
    protected List<BookEntity> books = new ArrayList<>();
    protected List<UserEntity> users = new ArrayList<>();
    protected List<CategoryEntity> categories = new ArrayList<>();

    protected List<ReviewEntity> reviews = new ArrayList<>();

    @BeforeEach
    void setup() {
        this.users.add(this.userRepository.save(UserEntity.builder()
                .email("email@example.com")
                .username("username")
                .password("pass")
                .build()));

        this.users.add(this.userRepository.save(UserEntity.builder()
                .email("email@stud.ubbcluj.ro")
                .username("username")
                .password("passUser")
                .build()));

        this.users.add(this.userRepository.save(UserEntity.builder()
                .email("email@ubbcluj.ro")
                .username("username")
                .password("passAdmin")
                .build()));

        this.domains.add(this.domainRepository.save(DomainEntity.builder()
                .name("SF")
                .build()));

        this.domains.add(this.domainRepository.save(DomainEntity.builder()
                .name("Biographies")
                .build()));


        this.publishers.add(this.publisherRepository.save(PublisherEntity.builder()
                .name("Polirom")
                .build()));


        this.categories.add(this.categoryRepository.save(CategoryEntity.builder()
                .name("General")
                .build()));


        this.books.add(this.bookRepository.save(BookEntity.builder()
                .title("Das Foundation Projekt: Roman")
                .year(2014)
                .ISBN("9783453528451")
                .author("Isaac Asimov")
                .summary("Das Foundation Projekt: Roman von Isaac Asimov")
                .ranking(4.14f)
                .categories(new ArrayList<>(this.categories))
                .domainEntity(this.domains.get(0))
                .publisherEntity(this.publishers.get(0))
                .contentLink("https://www.medimops.de/isaac-asimov-das-foundation-projekt-roman-taschenbuch-M0345352845X.html")
                .build()));
        this.books.add(this.bookRepository.save(BookEntity.builder()
                .title("Born A Crime")
                .year(2017)
                .ISBN("isbn")
                .author("Trevor Noah")
                .summary("Born a crime by Trevor Noah")
                .ranking(3.28f)
                .categories(new ArrayList<>(this.categories))
                .domainEntity(this.domains.get(1))
                .publisherEntity(this.publishers.get(0))
                .contentLink("https://www.medimops.de/trevor-noah-born-a-crime-stories-from-a-south-african-childhood-taschenbuch-M01473635306.html")
                .build()));
        this.books.add(this.bookRepository.save(BookEntity.builder()
                .title("Das Parfum")
                .year(1994)
                .ISBN("9783257228007")
                .author("Patrick Suskind")
                .summary("crazy kid no smell good nose")
                .ranking(4.17f)
                .categories(new ArrayList<>(this.categories))
                .domainEntity(this.domains.get(1))
                .publisherEntity(this.publishers.get(0))
                .contentLink("https://www.medimops.de/patrick-sueskind-das-parfum-taschenbuch-M03257228007.html")
                .build()));

        this.reviews.add(this.reviewRepository.save(ReviewEntity.builder()
                .description("belea rau")
                .rating(4.3F)
                .bookEntity(this.books.get(0))
                .userEntity(this.users.get(0))
                .build()));

        this.reviews.add(this.reviewRepository.save(ReviewEntity.builder()
                .description("slabutz")
                .rating(2.2F)
                .bookEntity(this.books.get(1))
                .userEntity(this.users.get(0))
                .build()));
    }

    @AfterEach
    void cleanup() {
        this.bookRepository.deleteAll();
        this.domainRepository.deleteAll();
        this.publisherRepository.deleteAll();
        this.categoryRepository.deleteAll();
        this.userRepository.deleteAll();
        this.reviewRepository.deleteAll();
    }
}
