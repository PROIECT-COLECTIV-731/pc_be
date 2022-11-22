package com.example.project.repository;

import com.example.project.DatabaseMockupForTests;
import com.example.project.entity.PublisherEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PublisherRepositoryTest extends DatabaseMockupForTests {

    @Test
    void findAll() {
        assert (this.publishers.equals(this.publisherRepository.findAll()));
    }

    @Test
    void findPublisherEntityByName() {
        List<PublisherEntity> result = this.publisherRepository.findPublisherEntityByName("Polirom");
        assert (result.contains(this.publishers.get(0)));
    }
}