package com.example.project.repository;

import com.example.project.DatabaseMockupForTests;
import com.example.project.entity.DomainEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DomainRepositoryTest extends DatabaseMockupForTests {

    @Test
    void findAll() {
        assert (this.domains.equals(this.domainRepository.findAll()));
    }

    @Test
    void findDomainEntityByName() {
        List<DomainEntity> result = this.domainRepository.findDomainEntityByName("Biographies");
        assert (result.contains(this.domains.get(1)));
    }
}